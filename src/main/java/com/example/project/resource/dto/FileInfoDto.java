package com.example.project.resource.dto;

import lombok.Data;

import java.util.List;

/**
 * @author chenliming
 * @date 2023/11/3 23:10
 */

@Data
public class FileInfoDto {
    /**
     * 文件id列表
     */
    private List<String> ids;
    /**
     * 文件pid
     */
    private String filePid;
}
