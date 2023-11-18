package com.example.project.common.system.vo;

import com.example.project.common.system.entity.Meta;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenliming
 * @date 2023/8/22 21:41
 */
@Data
public class MenuVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键ID
    private Integer id;
    //菜单名称
    private String title;
    //父ID
    private Integer parentId;
    //菜单路由地址
    private String path;
    //菜单组件地址
    private String component;
    //组件名称
    private String name;
    //菜单状态 正常 1停用
    private String status;
    //菜单类型 0菜单 1按钮 3目录
    private String menuType;
    //是否单级路由
    private String isSingle;
    //单级路由布局
    private String singleLayout;
    //排序
    private Integer sort;
    //权限标识
    private String authority;
    //菜单图标
    private String icon;
    //是否隐藏 0否 1是
    private String hide;
    //路由元信息
    private Meta meta;
    //子菜单
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuVo> children;
}
