package com.mf.service.impl;


import com.mf.core.ResultCode;
import com.mf.core.ServiceException;
import com.mf.dao.StudentMapper;
import com.mf.model.Student;
import com.mf.service.StudentService;
import com.mf.core.AbstractService;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public Student findByStudentName(String userName) {
        Student student = new Student();
        student.setUserName(userName);
        return findOne(student);
    }

    @Override
    public Long saveStudent(Student student) {
        Student checkStudent = findByStudentName(student.getUserName());
        if (checkStudent != null) {
            throw new ServiceException(ResultCode.USER_EXIST);
        }
        if (StringUtils.isNotEmpty(student.getPassword())) {
            student.setPassword(passwordEncoder.encode(student.getPassword()));
        }
        return save(student);
    }

    @Override
    public Student getStudentIdentity(Long id) {
        return findById(id);
    }
}