package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.system.mapper.UserRoleMapper;
import com.example.project.common.system.entity.UserRole;
import com.example.project.common.system.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * (UserRole)表服务实现类
 *
 * @author clm
 * @since 2023-08-12 19:47:36
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public void deleteUserRole(String userId) {
        LambdaQueryWrapper<UserRole> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserRole::getUserId,userId);
        remove(lambdaQueryWrapper);
    }
}

