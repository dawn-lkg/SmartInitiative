package com.example.project.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.blog.mapper.CategoryMapper;
import com.example.project.blog.entity.Category;
import com.example.project.blog.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * (Category)表服务实现类
 *
 * @author clm
 * @since 2023-09-17 13:51:16
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

