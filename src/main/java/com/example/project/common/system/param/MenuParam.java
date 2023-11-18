package com.example.project.common.system.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenliming
 * @date 2023/9/10 0:24
 */

@Data
@Accessors(chain = true)
public class MenuParam implements Serializable {
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
    //菜单状态 正常 1停用
    private String status;
    //菜单类型 0菜单 1按钮
    private String menuType;
    //排序
    private Integer sort;
    //权限标识
    private String authority;
    //菜单图标
    private String icon;
    //是否隐藏 0否 1是
    private boolean hide;
    //路由元信息
    private String meta;
    //创建人
    private Long createBy;
    //菜单
    private List<String> menuTypeList;
    //用户id
    private String userId;
}
