package com.example.project.blog.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.project.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author chenliming
 * @date 2023/11/25 19:40
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleParam extends BaseParam {
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
    private Date publishTime;
    //创建人
    private Integer createBy;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //逻辑删除 0正常 1删除
    private Integer deleted;
}
