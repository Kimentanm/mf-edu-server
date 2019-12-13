package com.mf.service.impl;


import com.mf.core.AbstractService;
import com.mf.dao.RolePermissionRefMapper;
import com.mf.model.RolePermissionRef;
import com.mf.service.RolePermissionRefService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2019/12/11.
*/
@Service
@Transactional
public class RolePermissionRefServiceImpl extends AbstractService<RolePermissionRef> implements RolePermissionRefService {
    @Resource
    private RolePermissionRefMapper tblRolePermissionRefMapper;

}