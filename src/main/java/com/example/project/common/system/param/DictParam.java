package com.example.project.common.system.param;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.example.project.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author chenliming
 * @date 2023/11/15 22:16
 */


@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DictParam extends BaseParam {
    /**
     * 主键id
     */
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
