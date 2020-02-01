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

    /**
     * 保存教室学生一对多关系
     */
    Long saveClassroomStudentRef(ClassRoom classRoom);

    void delete(Long id);
}