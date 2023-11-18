package com.example.project.common.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.param.UserParam;
import org.apache.ibatis.annotations.Param;

/**
 * (User)表数据库访问层
 *
 * @author clm
 * @since 2023-08-05 10:19:59
 */
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectPageRel(IPage<User> page, @Param("param")UserParam userParam);
}

