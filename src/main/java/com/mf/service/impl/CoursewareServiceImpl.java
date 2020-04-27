package com.mf.service.impl;

import com.mf.dao.CoursewareMapper;
import com.mf.dto.FileResultDTO;
import com.mf.model.Courseware;
import com.mf.service.CoursewareService;
import com.mf.core.AbstractService;
import com.mf.service.TeacherService;
import com.mf.service.UserService;
import com.mf.util.Constants;
import com.mf.util.PdfUtil;
import com.mf.util.QiniuyunServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
@Service
@Transactional
public class CoursewareServiceImpl extends AbstractService<Courseware> implements CoursewareService {
    @Resource
    private CoursewareMapper tblCoursewareMapper;
    @Resource
    private UserService userService;
    @Resource
    private TeacherService teacherService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private QiniuyunServiceManager qiniuyunManager;

    @Override
    public List<Courseware> findByType(String type) {
        Courseware courseware = new Courseware();
        courseware.setType(type);
        List<Courseware> coursewareList = find(courseware);
        if (Constants.CoursewareType.PUBLIC.equalsIgnoreCase(type)) {
            coursewareList.forEach(item -> {
                item.setCreateUser(userService.findById(item.getCreatedBy()));
            });
        } else {
            coursewareList.forEach(item -> {
                item.setCreateUser(teacherService.findById(item.getCreatedBy()));
            });
        }
        return coursewareList;
    }

    @Override
    public List<FileResultDTO> uploadCourseware(HttpServletRequest request) {
        try {
            List<FileResultDTO> resultList = new ArrayList<>();
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = mRequest.getFileNames();
            while (iter.hasNext()) {
                String next = iter.next();
                MultipartFile file = mRequest.getFile(next);
                byte[] courseBytes = mRequest.getFile(next).getBytes();
                String fileName = file.getOriginalFilename();
                // 如果上传的课件是word格式的，则需要转成pdf格式后再上传
                if ("application/msword".equalsIgnoreCase(file.getContentType())
                        || "application/vnd.openxmlformats-officedocument.wordprocessingml.document".equalsIgnoreCase(file.getContentType())) {
                    InputStream docInputStream = mRequest.getFile(next).getInputStream();
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    PdfUtil.doc2pdf(docInputStream, os);
                    courseBytes = os.toByteArray();
                    fileName = fileName.replace(fileName.endsWith(".docx") ? ".docx" : ".doc", ".pdf");
                }
                FileResultDTO result = qiniuyunManager.uploadInputStream(courseBytes, fileName);
                resultList.add(result);
            }
            return resultList;
        } catch (Exception e) {
            log.error(">>> file upload faile", e);
            return null;
        }
    }
}