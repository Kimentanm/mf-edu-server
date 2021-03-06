package com.mf.security.jwt;

import com.mf.core.ResultCode;
import com.mf.core.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filters incoming requests and installs a Spring Security principal if a header corresponding to a valid user is
 * found.
 */
public class JWTFilter extends GenericFilterBean {

    private Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    private TokenProvider tokenProvider;

    public JWTFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.info("===============> " + httpServletRequest.getRequestURI());
        if (!"/mf-edu/error/exthrow".equalsIgnoreCase(((HttpServletRequest) servletRequest).getRequestURI())) {
            String jwt = resolveToken(httpServletRequest);
            if (StringUtils.hasText(jwt)) {
                if(this.tokenProvider.validateToken(jwt)){
                    if (this.tokenProvider.validateTokenInvalid(jwt)) {
                        Authentication authentication = this.tokenProvider.getAuthentication(jwt);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } else {
                        throw new ServiceException(ResultCode.VALIDATE_TOKEN_INVALID);
                    }
                }else {
                    throw new ServiceException(ResultCode.VALIDATE_TOKEN_FAILED.getCode());
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * ??????????????????token
     * */
    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(JWTConfigurer.AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
