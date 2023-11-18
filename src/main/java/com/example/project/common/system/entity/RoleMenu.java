package com.example.project.common.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RoleMenu)表实体类
 *
 * @author clm
 * @since 2023-08-12 19:47:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role_menu")
public class RoleMenu implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 菜单ID
     */
    private Integer menuId;
}

