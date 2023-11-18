package com.example.project.common.core.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author chenliming
 * @date 2023/10/7 22:43
 */

@Data
public class SocketEntity {
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private List<String> userList;
}
