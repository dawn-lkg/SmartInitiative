package com.example.project.common.system.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chenliming
 * @date 2023/9/4 23:21
 */
@Data
@Accessors(chain = true)
public class UserVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    //用户名
    private String username;
    //用户名密码
    private String password;
    //昵称
    private String nickname;
    //账号状态 0正常 1删除
    private String status;
    //性别
    private String sex;
    //邮箱
    private String email;
    //手机号
    private String phoneNumber;
    //头像
    private String avatar;
    //用户类型（0管理员 1普通用户）
    private String userType;
    //创建人ID
    private Long createBy;
    //创建时间
}
