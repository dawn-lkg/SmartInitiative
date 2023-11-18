package com.example.project.common.system.service.impl;

import com.example.project.common.system.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author chenliming
 * @date 2023/9/9 18:49
 */

@Component
public class ServiceInfo {

    public User getUserInfo(){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                Object object = authentication.getPrincipal();
                if (object instanceof User) {
                    return (User) object;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
