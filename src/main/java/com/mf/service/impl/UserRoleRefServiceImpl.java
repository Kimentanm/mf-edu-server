package com.mf.service.impl;


import com.mf.dao.UserRoleRefMapper;
import com.mf.model.UserRoleRef;
import com.mf.service.UserRoleRefService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
@Service
@Transactional
public class UserRoleRefServiceImpl extends AbstractService<UserRoleRef> implements UserRoleRefService {
    @Resource
    private UserRoleRefMapper tblUserRoleRefMapper;


    @Override
    public int deleteByUserId(Long userId) {
        Condition condition = new Condition(UserRoleRef.class);
        Condition.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId", userId);
        return tblUserRoleRefMapper.deleteByCondition(condition);
    }

    @Override
    public void saveUserRole(Long userId, List<Long> roleIds) {
        roleIds.forEach(roleId -> {
            UserRoleRef userRoleRef = new UserRoleRef();
            userRoleRef.setRoleId(roleId);
            userRoleRef.setUserId(userId);
            save(userRoleRef);
        });
    }
}