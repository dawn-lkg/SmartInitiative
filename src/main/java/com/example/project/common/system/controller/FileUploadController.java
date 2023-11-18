package com.example.project.common.system.controller;

import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chenliming
 * @date 2023/9/14 22:51
 */
@RestController
@RequestMapping("file")
public class FileUploadController extends BaseController {
    @Autowired
    private FileService fileService;
    @PostMapping("upload")
    public Result<?> fileUpload(MultipartFile file){
        String s = fileService.uploadFile(file);
        System.out.println(s);
        return success();
    }

}
