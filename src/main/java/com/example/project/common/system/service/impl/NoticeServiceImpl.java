package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.system.mapper.NoticeMapper;
import com.example.project.common.system.entity.Notice;
import com.example.project.common.system.service.NoticeService;
import org.springframework.stereotype.Service;

/**
 * (Notice)表服务实现类
 *
 * @author clm
 * @since 2023-11-15 23:03:29
 */
@Service("noticeService")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}

