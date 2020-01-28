package com.mf.service;

import com.mf.core.Service;
import com.mf.model.Courseware;

import java.util.List;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
public interface CoursewareService extends Service<Courseware> {

    List<Courseware> findByType(String type);
}