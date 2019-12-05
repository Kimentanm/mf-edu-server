package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.ClassRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassRoomMapper extends Mapper<ClassRoom> {
    List<ClassRoom> findAllAndTeacherStudent();

    List<ClassRoom> listByTeacherId(@Param("teacherId") Long teacherId);

    List<ClassRoom> listByStudentId(@Param("studentId") Long studentId);
}