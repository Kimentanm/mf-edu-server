package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {

    void save(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);
}