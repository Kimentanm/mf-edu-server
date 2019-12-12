package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.RolePermissionRef;

import java.util.List;

public interface RolePermissionRefMapper extends Mapper<RolePermissionRef> {

    List<RolePermissionRef> findRefByRoleId(Long id);
}