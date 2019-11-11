package com.hsd.service.impl;

import com.hsd.core.AbstractService;
import com.hsd.dao.RoleMapper;
import com.hsd.model.Role;
import com.hsd.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRolesByUserId(Long userId){
        return roleMapper.findRolesByUserId(userId);
    }

    @Override
    public List<Role> pageList() {
        return roleMapper.pageList();
    }

    @Override
    public Role findRoleById(Long id) {
        return roleMapper.findRoleById(id);
    }

    @Override
    public void add(Role role) {
        save(role);
    }

    @Override
    public void updateRole(Role role) {
        updateByPK(role);
    }

    @Override
    public void deleteRole(Long id) {
        deleteByPK(id);
    }


}
