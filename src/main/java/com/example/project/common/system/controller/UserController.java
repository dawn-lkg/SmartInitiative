package com.example.project.common.system.controller;




import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.dto.UserDto;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.param.UserParam;
import com.example.project.common.system.service.FileService;
import com.example.project.common.system.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author clm
 * @since 2023-08-05 10:19:55
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;
    @Resource
    private FileService fileService;

    //@PreAuthorize("hasAnyAuthority('menu1')")
    @OperationLog(module = "用户",operator = "分页查询")
    @GetMapping("page")
    public Result page(UserParam userParam){
        return success(userService.listPage(userParam));
    }

    @OperationLog(module = "用户",operator = "获取用户信息")
    @GetMapping("info")
    public Result getUserInfo(){
        if(getLoginUser()==null){
            throw new BusinessException("没有登录");
        }
        return success(userService.getUserInfo(getLoginUserId()));
    }

    @OperationLog(module = "用户",operator = "新增用户")
    @PostMapping
    public Result save(@RequestBody UserDto userDto){
        userDto.setCreateBy(getLoginUserId());
        userService.saveUser(userDto);
        return success("新增用户成功");
    }

    @OperationLog(module = "用户",operator = "修改用户")
    @PutMapping
    public Result update(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return success("修改用户成功");
    }

    @OperationLog(module = "用户",operator = "删除用户")
    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") String id){
        userService.deleteUser(id);
        return success("删除用户成功");
    }

    @PostMapping("/avatar")
    public Result<?> uploadAvatar(MultipartFile file){
        String avatar = fileService.uploadFile(file);
        User user = new User();
        user.setId(getLoginUserId());
        user.setAvatar(avatar);
        userService.updateById(user);
        return success(avatar,"修改头像成功");
    }

    @OperationLog(module = "用户",operator = "批量获取用户")
    @GetMapping("/byIds")
    public Result<?> getUserList(@RequestParam("ids") List<String> ids){
        if(ids.size()==0){
            return success(new ArrayList<>());
        }
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(User::getId,ids);
        List<User> list = userService.list(lambdaQueryWrapper);
        return success(list);
    }


}

