package com.example.project.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.blog.entity.Article;
import com.example.project.blog.param.ArticleParam;
import com.example.project.common.system.vo.OperationRecordVo;

/**
 * (Article)表服务接口
 *
 * @author clm
 * @since 2023-09-17 13:50:54
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询
     * @param articleParam 查询参数
     * @return
     */
    IPage<Article> pageRel(ArticleParam articleParam);

    /**
     * 查询博客
     * @param id
     * @return
     */
    Article getByIdRel(Integer id);
}

