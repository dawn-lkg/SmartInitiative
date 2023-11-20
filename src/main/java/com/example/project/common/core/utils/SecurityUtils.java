package com.example.project.common.core.utils;

import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.system.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author chenliming
 * @date 2023/11/20 22:31
 */

public class SecurityUtils {

    /**
     * 获取用户
     **/
    public static User getLoginUser()
    {
        try
        {
            return (User) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new BusinessException("获取用户信息失败");
        }
    }
    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    /**
     * 判断密码是否相同
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
