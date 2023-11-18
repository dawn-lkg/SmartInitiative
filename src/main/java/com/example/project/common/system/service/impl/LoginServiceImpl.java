package com.example.project.common.system.service.impl;


import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.core.utils.JwtUtil;
import com.example.project.common.core.utils.RedisCache;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.service.LoginService;
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
    @Override
    public String login(User user) {
        if(user.getUsername()==null){
            throw new BusinessException("账号不能为空");
        }
        User byUsername = userService.getByUsername(user.getUsername());
        redisCache.setCacheObject("loginUser:"+byUsername.getId(),byUsername);
        if(byUsername==null){
            throw new BusinessException("账号密码错误");
        }
        if(!comparePassword(byUsername.getPassword(),user.getPassword())){
            throw new BusinessException("密码错误");
        }
        String jwt= JwtUtil.createJWT(String.valueOf(byUsername.getId()));
        return jwt;
    }

    @Override
    public Boolean comparePassword(String dbPassword, String inputPassword) {
        return passwordEncoder.matches(inputPassword,dbPassword);
    }
}
