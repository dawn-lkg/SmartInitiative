package com.example.project.common.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenliming
 * @date 2023/9/6 22:01
 */
@Data
public class RoleVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //角色名
    private String name;
    //角色权限字符串
    private String roleKey;
    //角色状态 0正常 1停用
    private String status;
    //权限路由
    private List<MenuVo> menuList;

}
