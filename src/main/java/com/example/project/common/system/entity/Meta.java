package com.example.project.common.system.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author chenliming
 * @date 2023/9/22 23:10
 */
@Data
@Accessors(chain = true)
public class Meta {
    private String title;
    private String icon;
    private Integer order;
    private boolean hide;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String singleLayout;
}
