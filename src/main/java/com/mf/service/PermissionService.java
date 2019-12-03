package com.mf.service;

import com.mf.core.Service;
import com.mf.model.Permission;
import com.mf.util.data.permission.PermissionListDTO;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2019/11/24.
 */
public interface PermissionService extends Service<Permission> {

    List<Permission> getPermissionChildren(Permission permission, List<Permission> all);
}