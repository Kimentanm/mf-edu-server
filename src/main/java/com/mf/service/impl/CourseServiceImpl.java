package com.mf.service.impl;

import com.mf.dao.CourseMapper;
import com.mf.model.Course;
import com.mf.service.CourseService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {
    @Resource
    private CourseMapper tblCourseMapper;

}