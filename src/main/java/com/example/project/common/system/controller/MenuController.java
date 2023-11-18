package com.example.project.common.system.controller;




import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.dto.RoleMenuDto;
import com.example.project.common.system.entity.Menu;
import com.example.project.common.system.service.MenuService;
import com.example.project.common.system.vo.MenuVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author clm
 * @since 2023-08-12 19:46:04
 */
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {
    @Resource
    private MenuService menuService;


    @OperationLog(module = "菜单权限",operator = "获取当前用户菜单")
    @GetMapping("/routes")
    public Result<List<MenuVo>> getRoute(){
        return success(menuService.getRouter(getLoginUserId()));
    }


    @OperationLog(module = "菜单权限",operator = "获取菜单权限")
    @GetMapping("all")
    public Result getAll(){
        List<MenuVo> menuVos = menuService.listMenuAll();
        return success(menuVos);
    }

    @OperationLog(module = "菜单权限",operator = "角色添加菜单")
    @PostMapping("/role")
    public Result addRoleMenu(@RequestBody RoleMenuDto roleMenudto){
        menuService.addRoleMenu(roleMenudto);
        return success("分配权限成功");
    }

    @OperationLog(module = "菜单权限",operator = "根据id获取子菜单")
    @GetMapping("/parent/{id}")
    public Result<?> getParent(@PathVariable("id") Integer parentId){
        List<Menu> menus = menuService.listMenuByParentId(parentId);
        return success(menus);
    }

    @OperationLog(module = "角色",operator = "删除菜单")
    @DeleteMapping("{id}")
    public Result<?> delete(@PathVariable("id") Integer id){
        menuService.removeMenu(id);
        return success("删除成功");
    }

    @OperationLog(module = "菜单权限",operator = "保存菜单")
    @PostMapping
    public Result<?> save(@RequestBody Menu menu){
        menu.setCreateBy(getLoginUserId());
        if(!menuService.save(menu)){
            return fail("新增菜单失败");
        }
        return success("新增菜单成功");
    }

    @OperationLog(module = "菜单权限",operator = "修改菜单")
    @PutMapping
    public Result<?> update(@RequestBody Menu menu){
        if(!menuService.updateById(menu)){
            return fail("修改菜单失败");
        }
        return success("修改菜单成功");
    }
}

