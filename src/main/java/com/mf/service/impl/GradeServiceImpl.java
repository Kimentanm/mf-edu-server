package com.mf.service.impl;


import com.mf.dao.GradeMapper;
import com.mf.model.Grade;
import com.mf.service.GradeService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
@Service
@Transactional
public class GradeServiceImpl extends AbstractService<Grade> implements GradeService {
    @Resource
    private GradeMapper tblGradeMapper;

}