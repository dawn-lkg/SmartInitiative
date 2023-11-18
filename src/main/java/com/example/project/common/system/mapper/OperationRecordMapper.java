package com.example.project.common.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.project.common.system.entity.OperationRecord;
import com.example.project.common.system.param.OperationRecordParam;
import com.example.project.common.system.vo.OperationRecordVo;
import org.apache.ibatis.annotations.Param;

/**
 * (SysOperationRecord)表数据库访问层
 *
 * @author clm
 * @since 2023-10-18 22:07:06
 */
public interface OperationRecordMapper extends BaseMapper<OperationRecord> {

    /**
     * 分页查询操作日志
     * @return List<OperationRecordVo>
     */
    IPage<OperationRecordVo> selectPageRel(IPage<OperationRecord> page, @Param("param")OperationRecordParam param);
}

