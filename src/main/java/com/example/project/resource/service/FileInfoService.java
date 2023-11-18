package com.example.project.resource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.resource.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件信息表(FileInfo)表服务接口
 *
 * @author clm
 * @since 2023-10-29 12:31:31
 */
public interface FileInfoService extends IService<FileInfo> {

    /**
     * 上传文件
     * @param file
     * @param fileInfo
     */
    void uploadFileInfo(MultipartFile file,FileInfo fileInfo) throws IOException;
}

