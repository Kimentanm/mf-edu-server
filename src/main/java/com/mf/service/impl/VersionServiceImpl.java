package com.mf.service;


import com.mf.dao.VersionMapper;
import com.mf.model.Version;
import com.mf.service.VersionService;
import com.mf.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
@Service
@Transactional
public class VersionServiceImpl extends AbstractService<Version> implements VersionService {
    @Resource
    private VersionMapper tblVersionMapper;

}