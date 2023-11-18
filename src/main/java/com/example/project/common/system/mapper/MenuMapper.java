package com.example.project.common.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project.common.system.entity.Menu;
import com.example.project.common.system.param.MenuParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author clm
 * @since 2023-08-12 19:46:04
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户Id获取权限菜单
     * @return
     */
    List<Menu> listMenuByUserId(@Param("userId") String userId,@Param("menuTypeList") List<String> menuTypeList);


    /**
     * 根据角色id获取菜单
     * @param roleId 角色id
     * @return List<Menu>
     */
    List<Menu> listMenuByRoleId(@Param("roleId") Integer roleId);

    /**
     * 查询菜单列表
     * @param param 查询参数 param
     * @return
     */
    List<Menu> listRel(@Param("param")MenuParam param);
}

