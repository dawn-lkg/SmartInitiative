package com.example.project.common.system.param;

import com.example.project.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author chenliming
 * @date 2023/9/5 20:36
 */

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleParam extends BaseParam {
    //角色名
    private String name;
    //角色权限字符串
    private String roleKey;
    //角色状态 0正常 1停用
    private String status;
    //创建时间
    private Date createTime;
}
