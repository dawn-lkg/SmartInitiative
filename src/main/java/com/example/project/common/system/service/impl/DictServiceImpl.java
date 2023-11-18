package com.example.project.common.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project.common.system.mapper.DictMapper;
import com.example.project.common.system.entity.Dict;
import com.example.project.common.system.service.DictService;
import org.springframework.stereotype.Service;

/**
 * (Dict)表服务实现类
 *
 * @author clm
 * @since 2023-11-15 22:00:44
 */
@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

}

