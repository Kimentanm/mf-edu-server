package com.mf.service.impl;


import com.mf.dao.CoursewareMapper;
import com.mf.model.Courseware;
import com.mf.service.CoursewareService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
@Service
@Transactional
public class CoursewareServiceImpl extends AbstractService<Courseware> implements CoursewareService {
    @Resource
    private CoursewareMapper tblCoursewareMapper;

}