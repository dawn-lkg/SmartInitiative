package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.core.Constants;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.system.dto.UserDto;
import com.example.project.common.system.entity.Role;
import com.example.project.common.system.entity.UserInfo;
import com.example.project.common.system.entity.UserRole;
import com.example.project.common.system.mapper.UserMapper;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.param.UserParam;
import com.example.project.common.system.service.MenuService;
import com.example.project.common.system.service.RoleService;
import com.example.project.common.system.service.UserRoleService;
import com.example.project.common.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (User)表服务实现类
 *
 * @author clm
 * @since 2023-08-05 10:20:00
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Override
    public User getByUsername(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,username);
        User user = getOne(lambdaQueryWrapper);
        if(Objects.nonNull(user)){
            user.setRoles(roleService.listRoleByUserId(user.getId()));
            List<String> menuTypeList=new ArrayList<>();
            menuTypeList.add(Constants.MENU_TYPE_PERMISSION);
            user.setAuthorities(menuService.listMenuByUserId(user.getId(),menuTypeList));
        }
        return user;
    }


    @Override
    public IPage<User> listPage(UserParam userParam) {
        IPage<User> userIPage = baseMapper.selectPageRel(new Page<>(userParam.getPageNum(), userParam.getPageSize()), new UserParam());
        userIPage.getRecords().forEach(d->{
            List<Role> roles = roleService.listRoleByUserId(d.getId());
            d.setRoles(roles);
        });
        return userIPage;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        UserInfo userInfo=new UserInfo();
        User byId = getById(userId);
        BeanUtils.copyProperties(byId,userInfo);
        List<Role> roles = roleService.listRoleByUserId(byId.getId());
        List<String> roleList = roles.stream().map(Role::getRoleKey).collect(Collectors.toList());
        userInfo.setRoles(roleList);
        return userInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(UserDto userDto) {
        //保存用户
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        if(!save(user)){
            throw new BusinessException("保存用户失败");
        }
        //保存角色
        List<Integer> roles = userDto.getRoleIdList();
        List<UserRole> userRoles = roles.stream().map(d -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(d);
            return userRole;
        }).collect(Collectors.toList());
        userRoleService.saveBatch(userRoles);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserDto userDto) {
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        if(!updateById(user)){
            throw new BusinessException("更新用户失败");
        }
        //删除角色
        userRoleService.deleteUserRole(user.getId());
        //保存角色
        List<Integer> roles = userDto.getRoleIdList();
        List<UserRole> userRoles = roles.stream().map(d -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(d);
            return userRole;
        }).collect(Collectors.toList());
        userRoleService.saveBatch(userRoles);
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(String userId) {
        if(!removeById(userId)){
            throw new BusinessException("删除用户失败");
        }
        userRoleService.deleteUserRole(userId);
    }

    @Override
    public User updateUserInfo(User user) {
        if(!updateById(user)){
            throw new BusinessException("修改用户信息失败");
        }
        return user;
    }


}

