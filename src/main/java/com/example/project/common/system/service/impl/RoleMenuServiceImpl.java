package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.system.mapper.RoleMenuMapper;
import com.example.project.common.system.entity.RoleMenu;
import com.example.project.common.system.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * (RoleMenu)表服务实现类
 *
 * @author clm
 * @since 2023-08-12 19:47:20
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Override
    public void removeRoleMenuByRoleId(Integer roleId) {
        LambdaQueryWrapper<RoleMenu> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RoleMenu::getRoleId,roleId);
        remove(lambdaQueryWrapper);
    }

    @Override
    public void removeRoleMenuByMenuId(Integer menuId) {
        LambdaQueryWrapper<RoleMenu> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RoleMenu::getMenuId,menuId);
        remove(lambdaQueryWrapper);
    }
}

