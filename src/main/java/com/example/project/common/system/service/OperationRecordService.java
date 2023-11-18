package com.example.project.common.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project.common.system.entity.OperationRecord;
import com.example.project.common.system.param.OperationRecordParam;
import com.example.project.common.system.vo.OperationRecordVo;

/**
 * (SysOperationRecord)表服务接口
 *
 * @author clm
 * @since 2023-10-18 22:07:06
 */
public interface OperationRecordService extends IService<OperationRecord> {


    /**
     * 保存系统日志
     * @param operationRecord
     */
    void saveAsync(OperationRecord operationRecord);

    /**
     * 分页查询
     * @param param
     * @return
     */
    IPage<OperationRecordVo> listPageRel(OperationRecordParam param);
}

