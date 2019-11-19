package com.mf.service;

import com.mf.core.Service;
import com.mf.model.UserRole;

import java.util.List;

public interface UserRoleService extends Service<UserRole> {

    int deleteByUserId(Long userId);

    void saveUserRole(Long userId, List<Long> roleIds);
}
