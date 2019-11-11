package com.hsd.service;

import com.hsd.core.Service;
import com.hsd.model.UserRole;

import java.util.List;

public interface UserRoleService extends Service<UserRole> {

    int deleteByUserId(Long userId);

    void saveUserRole(Long userId, List<Long> roleIds);
}
