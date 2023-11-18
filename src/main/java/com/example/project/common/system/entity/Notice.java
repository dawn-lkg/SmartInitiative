package com.example.project.common.system.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Notice)表实体类
 *
 * @author clm
 * @since 2023-11-15 23:03:29
 */
@Data
public class Notice extends Model<Notice> {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 通知标题
     */
    private String noticeTitle;
    /**
     * 公告内容
     */
    private String noticeContent;
    /**
     * 公告类型（0通知1公告）
     */
    private String noticeType;
    /**
     * 公告状态（0正常1关闭）
     */
    private String status;
    /**
     * 创建人
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除 0正常 1删除
     */
    @TableLogic
    private Integer deleted;

    }

