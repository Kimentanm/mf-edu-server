package com.mf.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author Kimen
 * @Date 2020/3/4 - 8:56 下午
 */
@Slf4j
@Component
public class ExceptionFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 是否已经放有异常栈, 避免循环
        boolean isRethrow = !Objects.isNull(servletRequest.getAttribute("filter.error"));
        if (isRethrow) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ServiceException e) {
            // 异常捕获，发送到error controller
            servletRequest.setAttribute("filter.error", e);
            //将异常分发到/error/exthrow控制器
            servletRequest.getRequestDispatcher("/error/exthrow").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
