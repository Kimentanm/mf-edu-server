package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.dto.FileResultDTO;
import com.mf.util.QiniuyunServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

@RestController
@RequestMapping("/common")
public class CommonController {
    private final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private QiniuyunServiceManager qiniuyunManager;

    /**
     * 图片上传
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/file/upload")
    public Result uploadFile(HttpServletRequest request, HttpServletResponse response){
        try {
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = mRequest.getFileNames();
            while (iter.hasNext()) {
                String next = iter.next();
                String fileName = mRequest.getFile(next).getOriginalFilename();
                FileResultDTO result = qiniuyunManager.uploadInputStream(mRequest.getFile(next).getBytes(), fileName);
                return ResultGenerator.genSuccessResult(result);
            }
            return ResultGenerator.genFailResult(">>>file upload failed");
        } catch (Exception e) {
            log.error(">>> file upload faile", e);
            return ResultGenerator.genFailResult(">>>file upload failed");
        }
    }
}
