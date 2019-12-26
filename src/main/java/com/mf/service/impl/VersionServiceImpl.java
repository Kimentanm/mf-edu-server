package com.mf.service.impl;


import com.mf.core.ResultCode;
import com.mf.core.ServiceException;
import com.mf.dao.VersionMapper;
import com.mf.model.Version;
import com.mf.service.VersionService;
import com.mf.core.AbstractService;
import okhttp3.internal.framed.ErrorCode;
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

    @Override
    public Version getLastVersionInfo(String type) {
        Version db = tblVersionMapper.getLastVersionInfo(type);
        if (null == db) {
            throw new ServiceException(ResultCode.ENTITYNOTFOUND);
        }
        return db;
    }
}