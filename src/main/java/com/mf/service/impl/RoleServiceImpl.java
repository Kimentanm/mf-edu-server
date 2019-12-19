package com.mf.service.impl;

import com.mf.core.AbstractService;
import com.mf.dao.RoleMapper;
import com.mf.model.Role;
import com.mf.model.RolePermissionRef;
import com.mf.service.RolePermissionRefService;
import com.mf.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RolePermissionRefService rolePermissionRefService;

    @Override
    public List<Role> findRolesByUserId(Long userId) {
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
        if (null != role.getPermissionIds() && role.getPermissionIds().size() > 0) {
            rolePermissionRefService.saveRolePermission(role.getId(), role.getPermissionIds());
        }
    }

    @Override
    public void updateRole(Role role) {
        Role db = findRoleById(role.getId());
        if (StringUtils.isNotBlank(role.getName())) {
            db.setName(role.getName());
        }
        if (StringUtils.isNotBlank(role.getCode())) {
            db.setCode(role.getCode());
        }
        if (StringUtils.isNotBlank(role.getDescription())) {
            db.setDescription(role.getDescription());
        }
        updateByPKSelective(role);
        if (null != role.getPermissionIds() && role.getPermissionIds().size() > 0) {
            //软删除角色和权限的关联关系
            List<RolePermissionRef> rolePermissionRefs = db.getRolePermissionRefs();
            rolePermissionRefs.forEach(rolePermissionRef -> {
                rolePermissionRef.setIsDelete(true);
                rolePermissionRefService.updateByPKSelective(rolePermissionRef);
            });
            //保存新的关联关系
            rolePermissionRefService.saveRolePermission(role.getId(), role.getPermissionIds());
        }
    }

    /**
     * 软删除
     */
    @Override
    public void deleteRole(Long id) {
        Role role = findRoleById(id);
        role.setIsDelete(true);
        updateByPKSelective(role);
    }


}
