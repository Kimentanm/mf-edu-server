package com.mf.service.impl;


import com.mf.dao.CoursewareMapper;
import com.mf.model.Courseware;
import com.mf.service.CoursewareService;
import com.mf.core.AbstractService;
import com.mf.service.TeacherService;
import com.mf.service.UserService;
import com.mf.util.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
@Service
@Transactional
public class CoursewareServiceImpl extends AbstractService<Courseware> implements CoursewareService {
    @Resource
    private CoursewareMapper tblCoursewareMapper;
    @Resource
    private UserService userService;
    @Resource
    private TeacherService teacherService;

    @Override
    public List<Courseware> findByType(String type) {
        Courseware courseware = new Courseware();
        courseware.setType(type);
        List<Courseware> coursewareList = find(courseware);
        if (Constants.CoursewareType.PUBLIC.equalsIgnoreCase(type)) {
            coursewareList.forEach(item -> {
                item.setCreateUser(userService.findById(item.getCreatedBy()));
            });
        } else {
            coursewareList.forEach(item -> {
                item.setCreateUser(teacherService.findById(item.getCreatedBy()));
            });
        }
        return coursewareList;
    }
}