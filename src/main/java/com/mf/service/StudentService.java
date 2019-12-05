package com.mf.service;

import com.mf.core.Service;
import com.mf.model.Student;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
public interface StudentService extends Service<Student> {

    Student findByStudentName(String userName);

    Long saveStudent(Student student);

    Student getStudentIdentity(Long currentUserId);
}