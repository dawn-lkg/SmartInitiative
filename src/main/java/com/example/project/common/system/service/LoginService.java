package com.example.project.common.system.service;

import com.example.project.common.system.entity.User;

/**
 * @author chenliming
 * @date 2023/8/6 11:20
 */
public interface LoginService {
    /**
     * 登录
     * @param user 用户
     * @return jwt
     */
    String login(User user);
    /**
     * 匹配密码是否正确
     * @param dbPassword 数据库密码
     * @param inputPassword 输入密码
     * @return
     */
    Boolean comparePassword(String dbPassword,String inputPassword);
}
