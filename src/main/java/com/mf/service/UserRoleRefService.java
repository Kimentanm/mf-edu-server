package com.mf.service;

import com.mf.core.Service;
import com.mf.model.UserRoleRef;

import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
public interface UserRoleRefService extends Service<UserRoleRef> {


    int deleteByUserId(Long userId);

    void saveUserRole(Long userId, List<Long> roleIds);


}