package com.example.project.common.system.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.project.common.core.Constants;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.param.OperationRecordParam;
import com.example.project.common.system.service.OperationRecordService;
import com.example.project.common.system.vo.OperationRecordVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysOperationRecord)表控制层
 *
 * @author clm
 * @since 2023-10-18 22:07:06
 */
@RestController
@RequestMapping("/operation-record")
public class OperationRecordController extends BaseController {
    @Resource
    private OperationRecordService sysOperationRecordService;

    @GetMapping("page")
    public Result<?> page(OperationRecordParam param){
        param.setType(Constants.OPERATOR_TYPE_NORMAL);
        IPage<OperationRecordVo> operationRecordVoIPage = sysOperationRecordService.listPageRel(param);
        return success(operationRecordVoIPage);
    }

    @GetMapping("/loginOperator/page")
    public Result<?> loginPage(OperationRecordParam param){
        param.setType(Constants.OPERATOR_TYPE_LOGIN);
        IPage<OperationRecordVo> operationRecordVoIPage = sysOperationRecordService.listPageRel(param);
        return  success(operationRecordVoIPage);
    }

}

