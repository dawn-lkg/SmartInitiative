package com.example.project.common.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.common.system.entity.RoleMenu;

/**
 * (RoleMenu)表服务接口
 *
 * @author clm
 * @since 2023-08-12 19:47:20
 */
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 根据角色id删除角色路由
     * @param roleId
     */
    void removeRoleMenuByRoleId(Integer roleId);

    /**
     * 根据菜单id删除角色路由
     * @param menuId
     */
    void removeRoleMenuByMenuId(Integer menuId);

}

