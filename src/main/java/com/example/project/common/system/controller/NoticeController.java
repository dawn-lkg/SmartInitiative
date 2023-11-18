package com.example.project.common.system.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.entity.Notice;
import com.example.project.common.system.param.NoticeParam;
import com.example.project.common.system.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * (Notice)表控制层
 *
 * @author clm
 * @since 2023-11-15 23:03:28
 */
@RestController
@RequestMapping("notice")
public class NoticeController extends BaseController {
    @Resource
    private NoticeService noticeService;

    @OperationLog(module = "通知公告",operator = "分页查询")
    @GetMapping("/page")
    public Result<?> page(NoticeParam param){
        LambdaQueryWrapper<Notice> noticeLambdaQueryWrapper=new LambdaQueryWrapper<>();
        noticeLambdaQueryWrapper.eq(Objects.nonNull(param.getId()),Notice::getId,param.getId());
        noticeLambdaQueryWrapper.eq(Objects.nonNull(param.getNoticeType()),Notice::getId,param.getNoticeType());
        noticeLambdaQueryWrapper.like(Objects.nonNull(param.getNoticeTitle()),Notice::getId,param.getNoticeTitle());
        noticeLambdaQueryWrapper.like(Objects.nonNull(param.getNoticeContent()),Notice::getId,param.getNoticeContent());
        noticeLambdaQueryWrapper.eq(Objects.nonNull(param.getStatus()),Notice::getId,param.getStatus());
        Page<Notice> page = noticeService.page(new Page<>(param.getPageNum(), param.getPageSize()), noticeLambdaQueryWrapper);
        return success(page);
    }

    @OperationLog(module = "通知公告",operator = "查询所有")
    @GetMapping("/list")
    public Result<?> list(NoticeParam param){
        LambdaQueryWrapper<Notice> noticeLambdaQueryWrapper=new LambdaQueryWrapper<>();
        noticeLambdaQueryWrapper.eq(Objects.nonNull(param.getId()),Notice::getId,param.getId());
        noticeLambdaQueryWrapper.eq(Objects.nonNull(param.getNoticeType()),Notice::getId,param.getNoticeType());
        noticeLambdaQueryWrapper.like(Objects.nonNull(param.getNoticeTitle()),Notice::getId,param.getNoticeTitle());
        noticeLambdaQueryWrapper.like(Objects.nonNull(param.getNoticeContent()),Notice::getId,param.getNoticeContent());
        noticeLambdaQueryWrapper.eq(Objects.nonNull(param.getStatus()),Notice::getId,param.getStatus());
        List<Notice> list = noticeService.list(noticeLambdaQueryWrapper);
        return success(list);
    }

    @OperationLog(module = "通知公告",operator = "新增通知公告")
    @PostMapping
    public Result<?> save(@RequestBody Notice notice){
        if(!noticeService.save(notice)){
            return fail("新增失败");
        }
        return success("新增成功");
    }

    @OperationLog(module = "通知公告",operator = "修改通知公告")
    @PutMapping
    public Result<?> update(@RequestBody Notice notice){
        if(!noticeService.updateById(notice)){
            return fail("修改失败");
        }
        return success("修改成功");
    }

    @OperationLog(module = "通知公告",operator = "删除通知公告")
    @DeleteMapping
    public Result<?> save(@PathVariable("id") String id){
        if(!noticeService.removeById(id)){
            return fail("删除失败");
        }
        return success("删除成功");
    }

}

