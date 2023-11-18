package com.example.project.common.system.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenliming
 * @date 2023/8/26 19:21
 */
@Data
@Accessors(chain = true)
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户角色列表
     */
    private List<String> roles;

    /**
     * 用户姓名（昵称）
     */
    private String nickname;
}
