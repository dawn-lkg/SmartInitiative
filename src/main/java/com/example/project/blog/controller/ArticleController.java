package com.example.project.blog.controller;



import com.example.project.blog.entity.Article;
import com.example.project.blog.service.ArticleService;
import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Article)表控制层
 *
 * @author clm
 * @since 2023-09-17 13:50:52
 */
@RestController
@RequestMapping("/blog/article")
public class ArticleController extends BaseController {
    @Resource
    private ArticleService articleService;

    @OperationLog(module = "博客模块",operator = "获取所有模块")
    @GetMapping("list")
    //@Cacheable(cacheNames = "articleList")
    public Result<?> list(){
        return success(articleService.list());
    }

    @OperationLog(module = "博客模块",operator = "新增博客")
    @PostMapping
    public Result<?> save(@RequestBody Article article){
        articleService.save(article);
        return success("新增成功");
    }

}

