package com.example.project.common.system.controller;


import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.entity.AccessTokenEntity;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.service.LoginService;
import com.example.project.common.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenliming
 * @date 2023/8/5 23:50
 */
@RestController
public class MainController extends BaseController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;

    @OperationLog(module = "登录模块",operator = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody User user){

        String jwt = loginService.login(user);
        AccessTokenEntity accessTokenEntity = new AccessTokenEntity();
        accessTokenEntity.setToken(jwt);
        return success(accessTokenEntity);
    }
}
