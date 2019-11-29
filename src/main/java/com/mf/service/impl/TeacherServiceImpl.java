package com.mf.service.impl;


import com.mf.dao.TeacherMapper;
import com.mf.model.Teacher;
import com.mf.service.TeacherService;
import com.mf.core.AbstractService;
import com.mf.util.QueryUtil;
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

    @Override
    public List<Teacher> getLikeTeacherName(String name) {
        name = QueryUtil.replaceSpecialCharactorsForLikeParam(name);
        return tblTeacherMapper.getLikeTeacherName(name);
    }
}