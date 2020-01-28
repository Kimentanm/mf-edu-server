package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.dto.FileResultDTO;
import com.mf.service.CommonService;
import com.mf.util.QiniuyunServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {
    private final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Resource
    private CommonService commonService;

    /**
     * 图片上传
     * @param request
     * @return
     */
    @PostMapping("/file/upload")
    public Result uploadFile(HttpServletRequest request){
        List<FileResultDTO> result = commonService.uploadFile(request);
        return ResultGenerator.genSuccessResult(result);
    }
}
