package com.mf.service.impl;


import com.mf.dao.StudentMapper;
import com.mf.model.Student;
import com.mf.service.StudentService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
@Service
@Transactional
public class StudentServiceImpl extends AbstractService<Student> implements StudentService {
    @Resource
    private StudentMapper tblStudentMapper;

}