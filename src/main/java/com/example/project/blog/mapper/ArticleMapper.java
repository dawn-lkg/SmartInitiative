package com.example.project.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.project.blog.entity.Article;
import com.example.project.blog.param.ArticleParam;
import com.example.project.common.system.vo.OperationRecordVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author clm
 * @since 2023-09-17 13:50:53
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 分页查询
     * @param page 分页参数
     * @param articleParam 分页参数
     * @return
     */
    IPage<Article> selectPageRel(@Param("page") IPage<Article> page, @Param("param") ArticleParam articleParam);

    /**
     * 查询所有
     * @param param
     * @return
     */
    List<Article> selectListRel(@Param("param") ArticleParam param);

}

