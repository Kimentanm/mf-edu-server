package com.mf.service;

import com.mf.core.Service;
import com.mf.model.RolePermissionRef;

import java.util.List;

/**
* Created by CodeGenerator on 2019/12/11.
*/
public interface RolePermissionRefService extends Service<RolePermissionRef> {

    void saveRolePermission(Long roleId, List<Long> permissionIds);

}