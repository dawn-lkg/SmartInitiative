package com.example.project.testProject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chenliming
 * @date 2023/11/5 17:19
 */
@Service
public class FileTestService {
    @Value("${upload.path}")
    private String chunkPath;

    public void saveChunk(MultipartFile file,String fileName,int chunkIndex){

    }
}
