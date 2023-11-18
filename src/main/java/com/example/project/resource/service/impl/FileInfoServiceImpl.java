package com.example.project.resource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.core.utils.CommonUtil;
import com.example.project.common.core.utils.ImageUtil;
import com.example.project.resource.constans.FileInfoConstants;
import com.example.project.resource.fileEnum.FileType;
import com.example.project.resource.mapper.FileInfoMapper;
import com.example.project.resource.entity.FileInfo;
import com.example.project.resource.service.FileInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件信息表(FileInfo)表服务实现类
 *
 * @author clm
 * @since 2023-10-29 12:31:31
 */
@Service("fileInfoService")
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements FileInfoService {
    @Value("${upload.path}")
    private String basePath;
    @Override
    public void uploadFileInfo(MultipartFile file,FileInfo fileInfo) throws IOException {
        if(file.isEmpty()){
            throw new BusinessException("文件为空");
        }
        File directory = new File(basePath);
        if(!directory.exists()){
            directory.mkdirs();
        }
        String OriginName=file.getOriginalFilename();
        String type=CommonUtil.getFileExtension(OriginName);
        String fileName = UUID.randomUUID() + "."+type;
        File sourFile = new File(basePath + fileName);
        try{
            file.transferTo(sourFile);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        String cover = null;
        int fileType= FileType.getFileType(type);
        int fileCategory = FileInfoConstants.getFileCategory(fileType);
        if(fileType==FileInfoConstants.FILE_TYPE_IMG){
            cover=ImageUtil.createThumbnail(basePath, ImageUtil.DEFAULT_SCALE, sourFile);
        }
        fileInfo.setFileCategory(fileCategory);
        fileInfo.setFileCover(cover);
        fileInfo.setFileName(OriginName);
        fileInfo.setFolderType(FileInfoConstants.FILE);
        fileInfo.setFileSize(file.getSize());
        fileInfo.setFileType(fileType);
        fileInfo.setFilePath(fileName);
        if(!save(fileInfo)) {
            throw new BusinessException("保存文件失败");
        }
    }

}

