package com.mf.service.impl;


import com.mf.core.ResultCode;
import com.mf.core.ServiceException;
import com.mf.dao.VersionMapper;
import com.mf.dto.FileResultDTO;
import com.mf.model.Version;
import com.mf.service.VersionService;
import com.mf.core.AbstractService;
import com.mf.util.MD5Util;
import com.mf.util.QiniuyunServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
@Service
@Transactional
public class VersionServiceImpl extends AbstractService<Version> implements VersionService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private VersionMapper tblVersionMapper;

    @Resource
    private QiniuyunServiceManager qiniuyunManager;

    @Override
    public Version getLastVersionInfo(String type) {
        Version db = tblVersionMapper.getLastVersionInfo(type);
        if (null == db) {
            throw new ServiceException(ResultCode.ENTITYNOTFOUND);
        }
        return db;
    }

    @Override
    public List<FileResultDTO> resourceUpload(HttpServletRequest request) {
        try {
            List<FileResultDTO> resultList = new ArrayList<>();
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = mRequest.getFileNames();
            while (iter.hasNext()) {
                String next = iter.next();
                String fileName = mRequest.getFile(next).getOriginalFilename();
                FileResultDTO result = qiniuyunManager.uploadInputStream(mRequest.getFile(next).getBytes(), fileName);
                String hash = MD5Util.md5HashCode(mRequest.getFile(next).getBytes());
                result.setHash(hash);
                resultList.add(result);
            }
            return resultList;
        } catch (Exception e) {
            log.error(">>> file upload faile", e);
            return null;
        }
    }
}