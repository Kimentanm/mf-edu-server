package com.mf.configurer;

import com.mf.core.Result;
import com.mf.core.ResultCode;
import com.mf.core.ResultGenerator;
import com.mf.core.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Spring boot统一异常处理
 */


@RestControllerAdvice
@Slf4j
public class AopExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // 捕捉其他所有异常
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result globalException(HttpServletRequest request, Throwable e) {
        Result result = new Result();
        if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
            Integer errorCode = ((ServiceException) e).getResultCode().getCode();
            if( errorCode!= null){
                result.setCode(errorCode);
            }else{
                result.setCode(ResultCode.FAIL);
            }
            result.setMessage(e.getMessage());
            logger.info(e.getMessage());
        } else if (e instanceof NoHandlerFoundException) {
            logger.error(e.getMessage(), e);
            result.setCode(ResultCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
        } else if (e instanceof ServletException) {
            logger.error(e.getMessage(), e);
            result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
        } else {
            result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
            String message= e.getMessage();
            logger.error(message, e);
        }
        return result;
    }
}



