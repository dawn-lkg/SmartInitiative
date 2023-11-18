package com.example.project.common.system.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * (Menu)表实体类
 *
 * @author clm
 * @since 2023-08-12 19:46:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
public class Menu implements GrantedAuthority {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 父ID
     */
    private Integer parentId;
    /**
     * 菜单路由地址
     */
    private String path;
    /**
     * 菜单组件地址
     */
    private String component;
    /**
     * 菜单组件名称
     */
    private String name;
    /**
     * 菜单状态 0正常 1停用
     */
    private String status;
    /**
     * 菜单类型 0菜单 1按钮
     */
    private String menuType;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 权限标识
     */
    private String authority;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 是否隐藏 0否 1是
     */
    private String hide;
    /**
     * 是否单级路由
     */
    private String isSingle;
    /**
     * 单级路由布局
     */
    private String singleLayout;
    /**
     * 路由元信息
     */
    private Meta meta;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除 0正常 1删除
     */
    @TableLogic
    private Integer deleted;

}

