package com.example.project.testProject.controller;

import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author chenliming
 * @date 2023/11/5 15:52
 */

@RequestMapping("/test")
@RestController
public class TestController extends BaseController {

    @Value("${upload.path}")
    private String basePath;

    @PostMapping("/upload-chunk")
    public Result<?> upload(MultipartFile file,String md5,int chunkIndex){
        try {
            Path chunkPath = Paths.get("E://path/blog/chunk", md5+chunkIndex);
            Files.write(chunkPath, file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return success("上传测试");
    }

    @PostMapping("/merge")
    public Result<?> merge(String md5,Integer totalChunks,String fileName) throws IOException {
        System.out.println(md5);
        System.out.println(totalChunks);
        System.out.println(fileName);
        String uploadPath="E://path/blog/chunk/";
        Path mergedFilePath = Paths.get(uploadPath, fileName);
        Files.createFile(mergedFilePath);
        for (int i = 0; i < totalChunks; i++) {
            Path chunkPath = Paths.get(uploadPath +md5+i);
            byte[] chunkBytes = Files.readAllBytes(chunkPath);

            // 使用文件偏移量来合并块文件
            Files.write(mergedFilePath, chunkBytes, StandardOpenOption.APPEND);

            // 删除块文件
            Files.delete(chunkPath);
        }
        return success();
    }
}
