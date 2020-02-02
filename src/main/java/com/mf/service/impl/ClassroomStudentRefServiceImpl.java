package com.mf.service.impl;

import com.mf.dao.ClassroomStudentRefMapper;
import com.mf.model.ClassRoom;
import com.mf.model.ClassroomStudentRef;
import com.mf.service.ClassroomStudentRefService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2020/01/31.
 */
@Service
@Transactional
public class ClassroomStudentRefServiceImpl extends AbstractService<ClassroomStudentRef> implements ClassroomStudentRefService {
    @Resource
    private ClassroomStudentRefMapper tblClassroomStudentRefMapper;

    @Override
    public void saveClassroomStudentRef(Long classId, List<Long> stuIds) {
        for (Long id : stuIds) {
            ClassroomStudentRef ref = new ClassroomStudentRef();
            ref.setClassId(classId);
            ref.setStudentId(id);
            save(ref);
        }
    }
}