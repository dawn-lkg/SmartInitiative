package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.system.mapper.RoleMapper;
import com.example.project.common.system.entity.Role;
import com.example.project.common.system.param.RoleParam;
import com.example.project.common.system.service.MenuService;
import com.example.project.common.system.service.RoleMenuService;
import com.example.project.common.system.service.RoleService;
import com.example.project.common.system.vo.MenuVo;
import com.example.project.common.system.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author clm
 * @since 2023-08-12 19:42:31
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public List<Role> listRoleByUserId(String userId) {
        return baseMapper.listRoleByUserId(userId);
    }

    @Override
    public IPage<RoleVo> listPage(RoleParam param) {
        IPage<RoleVo> roleIPage = baseMapper.listPage(new Page<>(param.getPageNum(), param.getPageSize()), param);
        roleIPage.getRecords().forEach(d->{
            List<MenuVo> menuVos = menuService.listMenuByRoleId(d.getId());
            d.setMenuList(menuVos);
        });
        return roleIPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeRole(Integer roleId) {
        //删除权限
        roleMenuService.removeRoleMenuByRoleId(roleId);
        //删除角色
        if(!removeById(roleId)){
            throw new BusinessException("删除角色失败");
        }
    }
}

