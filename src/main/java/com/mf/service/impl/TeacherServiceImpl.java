package com.mf.service.impl;


import com.mf.core.ResultCode;
import com.mf.core.ServiceException;
import com.mf.dao.TeacherMapper;
import com.mf.model.Teacher;
import com.mf.service.TeacherService;
import com.mf.core.AbstractService;
import com.mf.util.QueryUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
@Service
@Transactional
public class TeacherServiceImpl extends AbstractService<Teacher> implements TeacherService {
    @Resource
    private TeacherMapper tblTeacherMapper;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Teacher> getLikeTeacherName(String name) {
        name = QueryUtil.replaceSpecialCharactorsForLikeParam(name);
        return tblTeacherMapper.getLikeTeacherName(name);
    }

    @Override
    public Teacher findByTeacherName(String userName) {
        Teacher teacher = new Teacher();
        teacher.setUserName(userName);
        return findOne(teacher);
    }


    @Override
    public Long saveTeacher(Teacher teacher) {
        Teacher checkTeacher = findByTeacherName(teacher.getUserName());
        if (checkTeacher != null) {
            throw new ServiceException(ResultCode.USER_EXIST);
        }
        if (StringUtils.isNotEmpty(teacher.getPassword())) {
            teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        }
        return save(teacher);
    }

    @Override
    public Teacher getTeacherIdentity(Long id) {
        return findById(id);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = findById(id);
        teacher.setIsDelete(true);
        updateByPKSelective(teacher);
    }
}