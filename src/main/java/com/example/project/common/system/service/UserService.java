package com.example.project.common.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.common.system.dto.UserDto;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.entity.UserInfo;
import com.example.project.common.system.param.UserParam;

/**
 * (User)表服务接口
 *
 * @author clm
 * @since 2023-08-05 10:20:00
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return
     */
    User getByUsername(String username);

    /**
     * 获取用户列表
     * @param userParam 用户参数
     * @return IPage<User>
     */
    IPage<User> listPage(UserParam userParam);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    UserInfo getUserInfo(String userId);

    /**
     * 保存用户
     * @param userDto 用户dto
     */
    void saveUser(UserDto userDto);

    /**
     * 更新用户
     * @param userDto
     */
    void updateUser(UserDto userDto);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(String userId);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    User updateUserInfo(User user);

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     */
    void updatePassword(String oldPassword,String newPassword);
}

