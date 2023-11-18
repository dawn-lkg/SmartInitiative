package com.example.project.common.system.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Role)表实体类
 *
 * @author clm
 * @since 2023-08-12 19:42:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID，自动生成
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 角色状态，0表示正常，1表示停用
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
     * 是否删除，0表示正常，1表示删除
     */
    @TableLogic
    private Integer deleted;


}

