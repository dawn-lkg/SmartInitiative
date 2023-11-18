package com.example.project.common.system.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Dict)表实体类
 *
 * @author clm
 * @since 2023-11-15 22:00:44
 */

@Data
public class Dict extends Model<Dict> {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 字典键值
     */
    private String value;
    /**
     * 字典标签
     */
    private String label;
    /**
     * 字典排序
     */
    private String sort;
    /**
     * 状态 （0启用 1禁用）
     */
    private String status;
    /**
     * 字典类型
     */
    private String type;
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

