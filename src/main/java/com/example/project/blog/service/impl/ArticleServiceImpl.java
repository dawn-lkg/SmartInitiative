package com.example.project.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.blog.mapper.ArticleMapper;
import com.example.project.blog.entity.Article;
import com.example.project.blog.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * (Article)表服务实现类
 *
 * @author clm
 * @since 2023-09-17 13:50:55
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}

