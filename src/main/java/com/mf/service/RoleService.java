package com.mf.service;

import com.mf.core.Service;
import com.mf.model.Role;

import java.util.List;

public interface RoleService extends Service<Role> {

    List<Role> findRolesByUserId(Long userId);

    List<Role> pageList();

    Role findRoleById(Long id);

    void add(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

}
