package com.example.project.resource.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.project.common.core.Constants;
import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.resource.constans.FileInfoConstants;
import com.example.project.resource.dto.FileInfoDto;
import com.example.project.resource.entity.FileInfo;
import com.example.project.resource.param.FileInfoParam;
import com.example.project.resource.service.FileInfoService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 文件信息表(FileInfo)表控制层
 *
 * @author clm
 * @since 2023-10-29 12:31:27
 */
@RestController
@RequestMapping("fileInfo")
public class FileInfoController extends BaseController {

    @Resource
    private FileInfoService fileInfoService;

    @GetMapping("/list")
    @OperationLog(module = "网盘",operator = "查询列表")
    public Result<List<FileInfo>> list(FileInfoParam param){
        LambdaQueryWrapper<FileInfo> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FileInfo::getUserId,getLoginUserId());
        lambdaQueryWrapper.eq(FileInfo::getDeleted, Constants.REMOVE_NORMAL);
        lambdaQueryWrapper.eq(Objects.nonNull(param.getFileCategory()),FileInfo::getFileCategory,param.getFileCategory());
        lambdaQueryWrapper.eq(Objects.nonNull(param.getFileType()),FileInfo::getFileType,param.getFileType());
        lambdaQueryWrapper.eq(Objects.nonNull(param.getFilePid()),FileInfo::getFilePid,param.getFilePid());
        lambdaQueryWrapper.eq(Objects.nonNull(param.getFolderType()),FileInfo::getFolderType,param.getFolderType());
        lambdaQueryWrapper.like(Objects.nonNull(param.getFileName()),FileInfo::getFileName,param.getFileName());
        lambdaQueryWrapper.orderByDesc(FileInfo::getFolderType);
        lambdaQueryWrapper.orderByDesc(FileInfo::getUpdateTime);
        List<FileInfo> list = fileInfoService.list(lambdaQueryWrapper);
        return success(list);
    }

    @PostMapping("/create-directory")
    @OperationLog(module = "网盘",operator = "创建目录")
    public Result<?> createDirectory(@RequestBody FileInfo fileInfo){
        fileInfo.setFolderType(FileInfoConstants.DIRECTORY);
        fileInfo.setUserId(getLoginUserId());
        if(!fileInfoService.save(fileInfo)){
            return fail("新增目录失败");
        }
        return success(fileInfo);
    }

    @DeleteMapping("{id}")
    @OperationLog(module = "网盘",operator = "删除文件")
    public Result<?> deleteFile(@PathVariable("id")String id){
        UpdateWrapper<FileInfo> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        updateWrapper.set("deleted",FileInfoConstants.RECYCLE_STATUS);
        if(!fileInfoService.update(updateWrapper)){
            return fail("删除失败");
        }
        return success("删除成功");
    }

    @PutMapping()
    @OperationLog(module = "网盘",operator = "修改文件")
    public Result<?> update(@RequestBody FileInfo fileInfo){
        if(!fileInfoService.updateById(fileInfo)){
            return fail("修改失败");
        }
        FileInfo byId = fileInfoService.getById(fileInfo.getId());
        return success(byId);
    }


    @PostMapping("/upload")
    @OperationLog(module = "网盘",operator = "上传文件")
    public Result<?> upload(MultipartFile file,FileInfo fileInfo) throws IOException {
        fileInfo.setUserId(getLoginUserId());
        fileInfoService.uploadFileInfo(file,fileInfo);
        return success();
    }

    @DeleteMapping("/batch")
    @OperationLog(module = "网盘",operator = "批量删除")
    public Result<?> removeBatch(@RequestBody List<String> ids){
        UpdateWrapper<FileInfo> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("deleted",FileInfoConstants.RECYCLE_STATUS);
        updateWrapper.in("id",ids);
        if(!fileInfoService.update(updateWrapper)){
            return fail("批量删除失败");
        }
        return success("批量删除成功");
    }

    @PutMapping("/batch")
    @OperationLog(module = "网盘",operator = "批量移动")
    public Result<?> moveBatch(@RequestBody FileInfoDto fileInfoDto){
        UpdateWrapper<FileInfo> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("file_pid",fileInfoDto.getFilePid());
        updateWrapper.in("id",fileInfoDto.getIds());
        if(!fileInfoService.update(updateWrapper)){
            return fail("移动失败");
        }
        return success("移动成功");
    }

    @GetMapping("/directory")
    @OperationLog(module = "网盘",operator = "查询目录")
    public Result<?> getDirectoryList(){
        LambdaQueryWrapper<FileInfo> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FileInfo::getUserId,getLoginUserId());
        lambdaQueryWrapper.eq(FileInfo::getFolderType,FileInfoConstants.DIRECTORY);
        List<FileInfo> list = fileInfoService.list(lambdaQueryWrapper);
        return success(list);
    }
}

