package com.mf.service;

import com.mf.core.Service;
import com.mf.model.Teacher;

import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
public interface TeacherService extends Service<Teacher> {

    List<Teacher> getLikeTeacherName(String name);

    Teacher findByTeacherName(String userName);

    Long saveTeacher(Teacher teacher);

    Teacher getTeacherIdentity(Long id);
}