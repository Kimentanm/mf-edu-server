package com.mf.service;

import com.mf.core.Service;
import com.mf.model.ClassRoom;

import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
public interface ClassRoomService extends Service<ClassRoom> {

    List<ClassRoom> listByTeacherId(Long currentUserId);

    List<ClassRoom> listByStudentId(Long currentUserId);

    List<ClassRoom> findAllAndTeacherStudent();

    void delete(Long id);
}