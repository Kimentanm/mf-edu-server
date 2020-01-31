package com.mf.service.impl;

import com.mf.dao.ClassroomStudentRefMapper;
import com.mf.model.ClassroomStudentRef;
import com.mf.service.ClassroomStudentRefService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2020/01/31.
*/
@Service
@Transactional
public class ClassroomStudentRefServiceImpl extends AbstractService<ClassroomStudentRef> implements ClassroomStudentRefService {
    @Resource
    private ClassroomStudentRefMapper tblClassroomStudentRefMapper;

}