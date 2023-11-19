package com.example.project.common.system.service.impl;


import com.example.project.common.core.Constants;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.core.utils.JwtUtil;
import com.example.project.common.core.utils.RedisCache;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.service.LoginService;
import com.example.project.common.system.service.OperationRecordService;
import com.example.project.common.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author chenliming
 * @date 2023/8/6 12:56
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RedisCache redisCache;
    @Autowired
    OperationRecordService operationRecordService;
    @Override
    public String login(User user) {
        if(user.getUsername()==null){
            operationRecordService.recordLogin(user.getUsername(), Constants.SYSTEM_RECORD_FAIL,"账号为空",this.getClass().getName());
            throw new BusinessException("账号不能为空");
        }
        User byUsername = userService.getByUsername(user.getUsername());
        redisCache.setCacheObject("loginUser:"+byUsername.getId(),byUsername);
        if(byUsername==null){
            operationRecordService.recordLogin(user.getUsername(), Constants.SYSTEM_RECORD_FAIL,"账号不存在",this.getClass().getName());
            throw new BusinessException("账号不存在");
        }
        if(!comparePassword(byUsername.getPassword(),user.getPassword())){
            operationRecordService.recordLogin(user.getUsername(), Constants.SYSTEM_RECORD_FAIL,"密码错误",this.getClass().getName());
            throw new BusinessException("密码错误");
        }
        String jwt= JwtUtil.createJWT(String.valueOf(byUsername.getId()));
        operationRecordService.recordLogin(user.getUsername(), Constants.SYSTEM_RECORD_SUCCESS,"登录成功",this.getClass().getName());
        return jwt;
    }

    @Override
    public Boolean comparePassword(String dbPassword, String inputPassword) {
        return passwordEncoder.matches(inputPassword,dbPassword);
    }
}
