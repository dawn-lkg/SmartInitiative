package com.example.project.blog.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project.blog.entity.Category;
import com.example.project.blog.param.CategoryParam;
import com.example.project.blog.service.CategoryService;
import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * (Category)表控制层
 *
 * @author clm
 * @since 2023-09-17 13:51:16
 */
@RestController
@RequestMapping("/blog/category")
public class CategoryController extends BaseController {
    @Resource
    private CategoryService categoryService;

    @OperationLog(module = "博客分类模块",operator = "分页获取博客分类")
    @GetMapping("page")
    public Result<?> page(CategoryParam param){
        LambdaQueryWrapper<Category> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Objects.nonNull(param.getName()),Category::getName,param.getName());
        Page<Category> page = categoryService.page(new Page<>(param.getPageNum(),param.getPageSize()));
        return success(page);
    }

    @OperationLog(module = "博客分类模块",operator = "查询所有")
    @GetMapping("/list")
    public Result<?> list(CategoryParam param){
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>(Category.class)
                .eq(Objects.nonNull(param.getId()),Category::getId,param.getId())
                .like(Objects.nonNull(param.getName()),Category::getName,param.getName());
        List<Category> list = categoryService.list(categoryLambdaQueryWrapper);
        return success(list);
    }

    @OperationLog(module = "博客分类模块",operator = "保存博客分类")
    @PostMapping
    public Result<?> save(@RequestBody Category category){
        if(!categoryService.save(category)){
            return fail("新增博客失败");
        }
        return success("新增博客成功");
    }

    @OperationLog(module = "博客分类模块",operator = "修改博客分类")
    @PutMapping
    public Result<?> update(@RequestBody Category category){
        if(!categoryService.updateById(category)){
            return fail("修改博客失败");
        }
        return success("修改博客成功");
    }

    @OperationLog(module = "博客分类模块",operator = "删除博客分类")
    @DeleteMapping("{id}")
    public Result<?> remove(@PathVariable("id") Integer id){
        if(!categoryService.removeById(id)){
            return fail();
        }
        return success();
    }

}

