package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.UserRoleRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleRefMapper extends Mapper<UserRoleRef> {
    void save(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);
}