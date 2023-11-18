package com.example.project.common.system.param;

import com.example.project.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author chenliming
 * @date 2023/11/15 23:16
 */

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NoticeParam extends BaseParam {
    /**
     * 主键id
     */
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
    private Integer deleted;
}
