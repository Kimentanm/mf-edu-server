package com.mf.service;

import com.mf.core.Service;
import com.mf.model.ClassroomStudentRef;

import java.util.List;

/**
 * Created by CodeGenerator on 2020/01/31.
 */
public interface ClassroomStudentRefService extends Service<ClassroomStudentRef> {
    void saveClassroomStudentRef(Long classId, List<Long> stuIds);
}