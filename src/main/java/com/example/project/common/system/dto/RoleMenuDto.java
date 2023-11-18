package com.example.project.common.system.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenliming
 * @date 2023/9/9 19:33
 */
@Data
@Accessors(chain = true)
public class RoleMenuDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer roleId;
    private List<Integer> menuIdList;
}
