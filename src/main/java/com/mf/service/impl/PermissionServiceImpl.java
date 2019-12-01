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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public List<Permission> getPermissionList(Long id) {
        List<Permission> list = tblPermissionMapper.getSonPermissions(id);
//        if (CollectionUtils.isNotEmpty(list)){
//            for (Permission permission : list){
//
//            }
//        }
        return list;
    }

    @Override
    public List<PermissionListDTO> getPermissionTree() {
        List<Permission> permissions = permissionService.findAll();
        List<PermissionListDTO> dtos = this.treePermission(permissions);
        return dtos;
    }

    private List<PermissionListDTO> treePermission(List<Permission> permissions){
        Map<Long, List<PermissionListDTO>> children = new HashMap<>();
        List<PermissionListDTO> res = new ArrayList<>();
        for (Permission permission : permissions){
            PermissionListDTO dto = new PermissionListDTO().convertFrom(permission);
            List<PermissionListDTO> child = null;
            //创建子节点
            if ((child = children.get(permission.getId())) == null){
                child = new ArrayList<>();
                children.put(permission.getId(),child);
            }
            dto.setSonPermissions(children);
            //父类
            if (null == permission.getParentPermissionId()){
                res.add(dto);
            }
            //子类
            else {
                if (null == children.get(permission.getId())){
                    children.put(permission.getId(), new ArrayList<PermissionListDTO>().stream().map(permissionListDTO ->
                            new PermissionListDTO().convertFrom(permission)).collect(Collectors.toList()));
                }
                children.get(permission.getId()).add(dto);
            }
        }
        return res;
    }
}