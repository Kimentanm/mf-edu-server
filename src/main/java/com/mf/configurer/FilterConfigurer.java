package com.mf.configurer;

import com.mf.core.ExceptionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author Kimen
 * @Date 2020/3/4 - 8:54 下午
 */
@Configuration
public class FilterConfigurer {

    @Resource
    private ExceptionFilter exceptionFilter;

    @Bean
    public FilterRegistrationBean exceptionFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(exceptionFilter);
        registration.setName("exceptionFilter");
        //此处尽量小，要比其他Filter靠前
        registration.setOrder(-100);
        return registration;
    }
}
