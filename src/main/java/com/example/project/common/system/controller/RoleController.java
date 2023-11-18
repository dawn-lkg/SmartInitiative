package com.example.project.common.system.controller;




import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.entity.Role;
import com.example.project.common.system.param.RoleParam;
import com.example.project.common.system.service.RoleMenuService;
import com.example.project.common.system.service.RoleService;
import com.example.project.common.system.vo.RoleVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author clm
 * @since 2023-08-12 19:42:29
 */
@RestController
@RequestMapping("role")
public class RoleController extends BaseController {
    @Resource
    private RoleService roleService;
    @Resource
    private RoleMenuService roleMenuService;

    @OperationLog(module = "角色",operator = "获取当前用户角色列表")
    @GetMapping("list")
    public Result<?> list(){
        return success(roleService.listRoleByUserId(getLoginUserId()));
    }

    @OperationLog(module = "角色",operator = "分页获取角色")
    @GetMapping("page")
    public Result<?> page(RoleParam roleParam){
        IPage<RoleVo> roleIPage = roleService.listPage(roleParam);
        return success(roleIPage);
    }

    @OperationLog(module = "角色",operator = "获取所有角色")
    @GetMapping("all")
    public Result<List<Role>> getAll(){
        List<Role> list = roleService.list(null);
        return success(list);
    }

    @OperationLog(module = "角色",operator = "保存角色")
    @PostMapping
    public Result<?> save(@RequestBody Role role){
        if(!roleService.save(role)){
            return fail("新增角色失败");
        }
        return success("新增角色成功");
    }

    @OperationLog(module = "角色",operator = "修改角色")
    @PutMapping
    public Result<?> update(@RequestBody Role role){
        if(!roleService.updateById(role)){
            return fail("更新角色失败");
        }
        return success("修改角色成功");
    }

    @OperationLog(module = "角色",operator = "删除角色")
    @DeleteMapping("{id}")
    public Result<?> delete(@PathVariable("id") Integer roleId){
        roleService.removeRole(roleId);
        return success("删除角色成功");
    }
}

