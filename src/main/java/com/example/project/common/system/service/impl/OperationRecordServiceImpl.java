package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.core.Constants;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.core.utils.IpUtils;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.mapper.OperationRecordMapper;
import com.example.project.common.system.entity.OperationRecord;
import com.example.project.common.system.param.OperationRecordParam;
import com.example.project.common.system.service.OperationRecordService;
import com.example.project.common.system.service.UserService;
import com.example.project.common.system.vo.OperationRecordVo;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * (SysOperationRecord)表服务实现类
 *
 * @author clm
 * @since 2023-10-18 22:07:06
 */
@Service("sysOperationRecordService")
public class OperationRecordServiceImpl extends ServiceImpl<OperationRecordMapper, OperationRecord> implements OperationRecordService {

    @Autowired
    private UserService userService;

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

    @Override
    public void recordLogin(String username, String status, String message,String method) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        UserAgent userAgent= UserAgent.parseUserAgentString(requestAttributes.getRequest().getHeader("User-Agent"));
        String ip = IpUtils.getIpAddr();
        String osName = userAgent.getOperatingSystem().getName();
        String browser = userAgent.getBrowser().getName();
        User user = userService.getByUsername(username);
        OperationRecord operationRecord = new OperationRecord();
        operationRecord.setBrowser(browser);
        operationRecord.setIp(ip);
        operationRecord.setRequestMethod(Constants.REQUEST_TYPE_POST);
        operationRecord.setOs(osName);
        operationRecord.setTime(0L);
        operationRecord.setDescription(message);
        operationRecord.setStatus(status);
        operationRecord.setUserid(user.getId());
        operationRecord.setType(Constants.OPERATOR_TYPE_LOGIN);
        operationRecord.setModule("登录");
        operationRecord.setMethod(method);
        operationRecord.setUrl("/login");
        saveAsync(operationRecord);
    }
}

