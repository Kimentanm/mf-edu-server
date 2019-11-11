package com.hsd.dao;

import com.hsd.core.Mapper;
import com.hsd.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {

    void save(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);
}