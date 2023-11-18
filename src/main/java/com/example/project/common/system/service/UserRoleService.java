package com.example.project.common.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.common.system.entity.UserRole;

/**
 * (UserRole)表服务接口
 *
 * @author clm
 * @since 2023-08-12 19:47:36
 */
public interface UserRoleService extends IService<UserRole> {
    /**
     * 删除用户角色
     * @param userId
     */
    void deleteUserRole(String userId);
}

