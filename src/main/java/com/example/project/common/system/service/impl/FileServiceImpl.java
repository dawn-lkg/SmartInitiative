package com.example.project.common.system.service.impl;

import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.system.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author chenliming
 * @date 2023/9/15 21:21
 */
@Service("FileService")
public class FileServiceImpl implements FileService {
    @Value("${upload.path}")
    private String ImageBase;
    @Override
    public String uploadFile(MultipartFile file) {
        if(file.isEmpty()){
            throw new BusinessException("文件上传失败");
        }
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String fileName = UUID.randomUUID() + suffix;
        try{
            File storageDirectory = new File(ImageBase);
            if (!storageDirectory.exists()) {
                storageDirectory.mkdirs();
            }
            file.transferTo( new File(ImageBase + fileName));
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        return fileName;
    }
}
