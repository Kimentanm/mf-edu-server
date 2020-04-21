package com.mf.service.impl;

import com.mf.core.ResultGenerator;
import com.mf.dto.FileResultDTO;
import com.mf.service.CommonService;
import com.mf.util.AsposeWordsUtils;
import com.mf.util.QiniuyunServiceManager;
import com.mf.web.CommonController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private QiniuyunServiceManager qiniuyunManager;

    @Override
    public List<FileResultDTO> uploadFile(HttpServletRequest request) {
        try {
            List<FileResultDTO> resultList = new ArrayList<>();
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = mRequest.getFileNames();
            while (iter.hasNext()) {
                String next = iter.next();
                String fileName = mRequest.getFile(next).getOriginalFilename();
                FileResultDTO result = qiniuyunManager.uploadInputStream(mRequest.getFile(next).getBytes(), fileName);
                resultList.add(result);
            }
            return resultList;
        } catch (Exception e) {
            //见64行注解
            log.error(">>> file upload faile", e);
            return null;
        }
    }

    @Override
    public List<FileResultDTO> uploadCourse(HttpServletRequest request) {
        try {
            List<FileResultDTO> resultDTOS = new ArrayList<>();
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = mRequest.getFileNames();
            while (iterator.hasNext()) {
                String next = iterator.next();
                String fileName = mRequest.getFile(next).getOriginalFilename();
                if (mRequest.getContentType().equalsIgnoreCase("application/msword")
                        || mRequest.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
//                    AsposeWordsUtils.doc2pdf();
                }
            }
            return null;
        } catch (Exception e) {
            //“失败”的正确写法是alfred的“fail”，请Kimen下次注意！
            log.error(">>> file upload fail", e);
            return null;
        }
    }
}
