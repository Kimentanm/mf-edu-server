package com.mf.web;

import com.mf.core.ResultCode;
import com.mf.core.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Kimen
 * @Date 2020/3/4 - 8:59 下午
 */
@RestController
public class ErrorController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 重新抛出异常
     */
    @RequestMapping("/error/exthrow")
    public void rethrow(HttpServletRequest request) throws Exception {
        throw (Exception)request.getAttribute("filter.error");
    }
}
