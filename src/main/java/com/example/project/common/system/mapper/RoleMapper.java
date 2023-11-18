package com.example.project.common.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.project.common.system.entity.Role;
import com.example.project.common.system.param.RoleParam;
import com.example.project.common.system.vo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author clm
 * @since 2023-08-12 19:42:29
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户id查询角色
     * @param id 用户ID
     * @return
     */
    List<Role> listRoleByUserId(@Param("userId") String id);

    /**
     * 分页获取角色
     * @param roleParam 查询参数
     * @return List<Role>
     */
    IPage<RoleVo> listPage(IPage<RoleVo> page, @Param("param") RoleParam roleParam);
}

