package com.example.project.common.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.common.system.dto.RoleMenuDto;
import com.example.project.common.system.entity.Menu;
import com.example.project.common.system.vo.MenuVo;

import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author clm
 * @since 2023-08-12 19:46:04
 */
public interface MenuService extends IService<Menu> {

    /**
     * 根据用户id获取权限
     * @param userId
     * @return
     */
    List<Menu> listMenuByUserId(String userId,List<String> menuTypeList);

    /**
     * 获取路由
     * @param userId 用户id
     * @return List<MenuVo>
     */
    List<MenuVo> getRouter(String userId);

    /**
     * 获取路由
     * @param roleId 角色id
     * @return List<MenuVo>
     */
    List<MenuVo> listMenuByRoleId(Integer roleId);

    /**
     * 获取所有权限路由
     * @return
     */
    List<MenuVo> listMenuAll();

    /**
     * 获取父级菜单
     * @param id
     * @return
     */
    List<Menu> listMenuByParentId(Integer id);

    /**
     * 删除菜单
     * @param id
     */
    void removeMenu(Integer id);

    /**
     * 添加角色权限
     * @param roleMenuDto
     */
    void addRoleMenu(RoleMenuDto roleMenuDto);

}

