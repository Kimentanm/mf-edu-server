package com.mf.service.impl;


import com.mf.dao.LessonMapper;
import com.mf.model.Lesson;
import com.mf.service.LessonService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
@Service
@Transactional
public class LessonServiceImpl extends AbstractService<Lesson> implements LessonService {
    @Resource
    private LessonMapper tblLessonMapper;

}