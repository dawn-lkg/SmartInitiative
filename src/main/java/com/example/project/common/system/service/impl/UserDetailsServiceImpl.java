package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author chenliming
 * @date 2023/8/5 10:51
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public User loadUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = userService.getOne(queryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        return user;
    }
}
