package com.mf.service.impl;


import com.mf.dao.ClassRoomMapper;
import com.mf.model.ClassRoom;
import com.mf.core.AbstractService;
import com.mf.service.ClassRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
@Service
@Transactional
public class ClassRoomServiceImpl extends AbstractService<ClassRoom> implements ClassRoomService {
    @Resource
    private ClassRoomMapper tblClassRoomMapper;

}