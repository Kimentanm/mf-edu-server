package com.hsd.service;

import com.hsd.core.Service;
import com.hsd.model.Role;

import java.util.List;

public interface RoleService extends Service<Role> {

    List<Role> findRolesByUserId(Long userId);

    List<Role> pageList();

    Role findRoleById(Long id);

    void add(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

}
