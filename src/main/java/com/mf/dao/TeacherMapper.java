package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper extends Mapper<Teacher> {
    List<Teacher> getLikeTeacherName(@Param("userName") String name);
}