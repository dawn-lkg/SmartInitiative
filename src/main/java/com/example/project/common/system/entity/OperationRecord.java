package com.example.project.common.system.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (SysOperationRecord)表实体类
 *
 * @author clm
 * @since 2023-10-18 22:07:06
 */
@Data
@TableName("sys_operation_record")
public class OperationRecord extends Model<OperationRecord> {
    /**
     * 主键ID，自动生成
     */
    @TableId(type = IdType.AUTO)
    private String id;

    /**
     * 用户名
     */
    private String userid;

    /**
     * 操作耗时
     */
    private Long time;

    /**
     * 操作模块
     */
    private String module;

    /**
     * 操作模块描述
     */
    private String description;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 调用方法
     */
    private String method;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 状态，0表示成功，1表示异常
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除，0表示正常，1表示删除
     */
    private Integer deleted;

}

