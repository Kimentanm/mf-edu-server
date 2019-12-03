package com.mf.service.impl;


import com.mf.dao.PermissionMapper;
import com.mf.model.Permission;
import com.mf.service.PermissionService;
import com.mf.core.AbstractService;
import com.mf.util.data.permission.PermissionListDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
* Created by CodeGenerator on 2019/11/24.
*/
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {
    @Resource
    private PermissionMapper tblPermissionMapper;
    @Resource
    private PermissionService permissionService;

    @Override
    public List<Permission> getPermissionChildren(Permission treeNode, List<Permission> treeNodes) {
       Long parentId = treeNode.getId();
       List<Permission> permissionList = new ArrayList<>();
        for (Permission node : treeNodes) {
            if (node.getParentPermissionId().equals(parentId)) {
                List<Permission> children = getPermissionChildren(node, treeNodes);
                node.setChildren(children);
                permissionList.add(node);
            }
        }
        return permissionList;
    }
}