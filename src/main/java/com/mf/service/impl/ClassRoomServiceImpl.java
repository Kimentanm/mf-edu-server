package com.mf.service.impl;


import com.mf.dao.ClassRoomMapper;
import com.mf.model.ClassRoom;
import com.mf.core.AbstractService;
import com.mf.service.ClassRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
@Service
@Transactional
public class ClassRoomServiceImpl extends AbstractService<ClassRoom> implements ClassRoomService {
    @Resource
    private ClassRoomMapper tblClassRoomMapper;

    @Override
    public List<ClassRoom> listByTeacherId(Long teacherId) {
        return tblClassRoomMapper.listByTeacherId(teacherId);
    }

    @Override
    public List<ClassRoom> listByStudentId(Long studentId) {
        return tblClassRoomMapper.listByStudentId(studentId);
    }

    @Override
    public List<ClassRoom> findAllAndTeacherStudent() {
        return tblClassRoomMapper.findAllAndTeacherStudent();
    }

    @Override
    public void delete(Long id) {
        ClassRoom classRoom = findById(id);
        classRoom.setIsDelete(true);
        updateByPKSelective(classRoom);
    }
}