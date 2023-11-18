package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.core.Constants;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.core.utils.BeanCopyUtils;
import com.example.project.common.system.dto.RoleMenuDto;
import com.example.project.common.system.entity.RoleMenu;
import com.example.project.common.system.mapper.MenuMapper;
import com.example.project.common.system.entity.Menu;
import com.example.project.common.system.service.MenuService;
import com.example.project.common.system.service.RoleMenuService;
import com.example.project.common.system.vo.MenuVo;
import com.example.project.common.system.entity.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Menu)表服务实现类
 *
 * @author clm
 * @since 2023-08-12 19:46:04
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public List<Menu> listMenuByUserId(String userId,List<String> menuTypeList) {
        List<Menu> menus = baseMapper.listMenuByUserId(userId, menuTypeList);
        return menus;
    }

    @Override
    public List<MenuVo> getRouter(String userId) {
        List<String> menuTypeList=new ArrayList<>();
        menuTypeList.add(Constants.MENU_TYPE_MENU);
        menuTypeList.add(Constants.MENU_TYPE_CATALOGUE);
        List<Menu> menus = baseMapper.listMenuByUserId(userId,menuTypeList);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        List<MenuVo> tree = buildMenuTree(menuVos, 0);
        return tree;
    }

    @Override
    public List<MenuVo> listMenuByRoleId(Integer roleId) {
        List<Menu> menus = baseMapper.listMenuByRoleId(roleId);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        List<MenuVo> tree = buildMenuTree(menuVos, 0);
        return tree;
    }

    @Override
    public List<MenuVo> listMenuAll() {
        List<Menu> list = list();
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(list, MenuVo.class);
        List<MenuVo> tree = buildMenuTree(menuVos, 0);
        return tree;
    }

    @Override
    public List<Menu> listMenuByParentId(Integer id) {
        LambdaQueryWrapper<Menu> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Menu::getParentId,id);
        lambdaQueryWrapper.orderByAsc(Menu::getSort);
        List<Menu> list = list(lambdaQueryWrapper);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeMenu(Integer id) {
        List<Menu> menus = listMenuByParentId(id);
        if(menus.size()>0){
            throw new BusinessException("请先删除子菜单");
        }
        removeById(id);
        roleMenuService.removeRoleMenuByMenuId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRoleMenu(RoleMenuDto roleMenuDto) {
        //删除原有权限
        roleMenuService.removeRoleMenuByRoleId(roleMenuDto.getRoleId());
        //添加权限
        List<RoleMenu> roleMenus = roleMenuDto.getMenuIdList().stream().map(d -> {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(d);
            roleMenu.setRoleId(roleMenuDto.getRoleId());
            return roleMenu;
        }).collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenus);
    }



    public List<MenuVo> buildMenuTree(List<MenuVo> menuItem,Integer parentId){
        List<MenuVo> tree=new ArrayList<>();
        menuItem.forEach(menu->{
            if(menu.getParentId().equals(parentId)){
                Meta meta = new Meta();
                List<MenuVo> children=buildMenuTree(menuItem,menu.getId());
                if(children.size()>0){
                    menu.setChildren(children);
                }
                if(menu.getIsSingle().equals(Constants.SINGLE_RIGHT)){
                    meta.setSingleLayout(menu.getSingleLayout());
                }
                boolean hide=menu.getHide().equals(Constants.HIDE);
                meta.setIcon(menu.getIcon()).setTitle(menu.getTitle()).setOrder(menu.getSort()).setHide(hide);
                menu.setMeta(meta);
                tree.add(menu);
            }
        });
        tree.sort(Comparator.comparing(MenuVo::getSort));
        return tree;
    }
}

