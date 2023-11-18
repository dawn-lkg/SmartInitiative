package com.example.project.blog.param;

import com.example.project.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chenliming
 * @date 2023/9/18 21:18
 */

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryParam extends BaseParam {
    //主键
    private Integer id;
    //分类名称
    private String name;
    //排序
    private Integer sort;
    //创建人
    private Integer createBy;
}
