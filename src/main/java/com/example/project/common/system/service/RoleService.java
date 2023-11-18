package com.example.project.common.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.common.system.entity.Role;
import com.example.project.common.system.param.RoleParam;
import com.example.project.common.system.vo.RoleVo;

import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author clm
 * @since 2023-08-12 19:42:31
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户ID获取角色列表
     * @param userId 用户ID
     * @return Role
     */
    List<Role> listRoleByUserId(String userId);

    /**
     * 分页获取角色
     * @param param
     * @return IPage<RoleVo>
     */
    IPage<RoleVo> listPage(RoleParam param);

    /**
     * 删除角色
     * 删除权限
     * @param roleId
     */
    void removeRole(Integer roleId);
}

