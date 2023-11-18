package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.system.mapper.OperationRecordMapper;
import com.example.project.common.system.entity.OperationRecord;
import com.example.project.common.system.param.OperationRecordParam;
import com.example.project.common.system.service.OperationRecordService;
import com.example.project.common.system.vo.OperationRecordVo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * (SysOperationRecord)表服务实现类
 *
 * @author clm
 * @since 2023-10-18 22:07:06
 */
@Service("sysOperationRecordService")
public class OperationRecordServiceImpl extends ServiceImpl<OperationRecordMapper, OperationRecord> implements OperationRecordService {

    @Async
    @Override
    public void saveAsync(OperationRecord operationRecord) {
        if(!save(operationRecord)){
            throw new BusinessException("保存系统日志失败");
        }
    }

    @Override
    public IPage<OperationRecordVo> listPageRel(OperationRecordParam param) {
        return baseMapper.selectPageRel(new Page<>(param.getPageNum(),param.getPageSize()),param);
    }
}

