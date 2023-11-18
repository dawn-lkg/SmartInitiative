package com.example.project.blog.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (Article)表实体类
 *
 * @author clm
 * @since 2023-09-17 13:50:54
 */
@Data
@Accessors(chain = true)
@TableName("blog_article")
public class Article extends Model<Article> {
    //主键id
    @TableId(type = IdType.AUTO)
    private Integer id;
    //文章标题
    private String title;
    //分类id
    private Integer categoryId;
    //文章摘要
    private String summary;
    //封面图片
    private String cover;
    //文章内容
    private String content;
    //文章预览量
    private Integer viewCount;
    //评论数量
    private Integer commentCount;
    //文章排序
    private Integer sort;
    //状态（0已发布，1草稿）
    private String status;
    //是否允许评论（0允许，1不允许）
    private String isComment;
    //是否推荐（0推荐，1不推荐）
    private String isRecommend;
    //发布时间
    private Date publicTime;
    //创建人
    private Integer createBy;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //逻辑删除 0正常 1删除
    private Integer deleted;

    }

