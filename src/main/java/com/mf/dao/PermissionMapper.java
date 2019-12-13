package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<Permission> getSonPermissions(@Param("id") Long id);

    List<Permission> findPermissionsByRoleId(@Param("roleId") Long roleId);
}