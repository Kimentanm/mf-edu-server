package com.mf.service.impl;


import com.mf.dao.PermissionMapper;
import com.mf.model.Permission;
import com.mf.service.PermissionService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/24.
*/
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {
    @Resource
    private PermissionMapper tblPermissionMapper;

    @Override
    public List<Permission> getPermissionList(Long id) {
        List<Permission> list = tblPermissionMapper.getSonPermissions(id);
//        if (CollectionUtils.isNotEmpty(list)){
//            for (Permission permission : list){
//
//            }
//        }
        return list;
    }
}