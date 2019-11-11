package com.hsd.service.impl;

import com.hsd.core.AbstractService;
import com.hsd.dao.UserRoleMapper;
import com.hsd.model.UserRole;
import com.hsd.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper tblUserRoleMapper;

    @Override
    public int deleteByUserId(Long userId) {
        Condition condition = new Condition(UserRole.class);
        Condition.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId",userId);
        return tblUserRoleMapper.deleteByCondition(condition);
    }

    @Override
    public void saveUserRole(Long userId, List<Long> roleIds) {
        tblUserRoleMapper.save(userId,roleIds);
    }
}
