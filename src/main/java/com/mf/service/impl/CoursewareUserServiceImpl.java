package com.mf.service.impl;

import com.mf.dao.CoursewareUserMapper;
import com.mf.model.CoursewareUser;
import com.mf.service.CoursewareUserService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2020/01/13.
 */
@Service
@Transactional
public class CoursewareUserServiceImpl extends AbstractService<CoursewareUser> implements CoursewareUserService {
    @Resource
    private CoursewareUserMapper tblCoursewareUserMapper;

}