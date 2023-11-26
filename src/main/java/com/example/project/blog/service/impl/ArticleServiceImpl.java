package com.example.project.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.blog.mapper.ArticleMapper;
import com.example.project.blog.entity.Article;
import com.example.project.blog.param.ArticleParam;
import com.example.project.blog.service.ArticleService;
import com.example.project.common.system.vo.OperationRecordVo;
import org.springframework.stereotype.Service;

/**
 * (Article)表服务实现类
 *
 * @author clm
 * @since 2023-09-17 13:50:55
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public IPage<Article> pageRel(ArticleParam articleParam) {
        return baseMapper.selectPageRel(new Page<>(articleParam.getPageNum(),articleParam.getPageSize()),articleParam);
    }

    @Override
    public Article getByIdRel(Integer id) {
        Article article = baseMapper.selectListRel(new ArticleParam().setId(id))
                .stream().findFirst().orElse(null);
        return article;
    }
}

