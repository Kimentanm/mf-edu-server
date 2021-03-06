package com.mf.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.security.AuthenticatedUser;
import com.mf.security.jwt.JWTConfigurer;
import com.mf.security.jwt.TokenProvider;
import com.mf.service.UserService;
import com.mf.dto.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping()
public class UserJWTController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    private final Logger log = LoggerFactory.getLogger(UserJWTController.class);

    private final TokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

//    @Resource
//    private SmsVerifyService smsVerifyService;

    public UserJWTController(TokenProvider tokenProvider,
                             AuthenticationManager authenticationManager,
                             UserService userService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public Result authorize(@Valid @RequestBody LoginDTO loginDTO, HttpServletResponse response) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername() + ":" + loginDTO.getType(), loginDTO.getPassword());

        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.createToken(authentication, false, loginDTO.getType());

            Long userId = null;
            if (authentication.getPrincipal() instanceof AuthenticatedUser) {
                AuthenticatedUser authenticatedUser = (AuthenticatedUser) authentication.getPrincipal();
                userId = authenticatedUser.getUserId();
            }
            // ??????redis??????????????????????????????token???????????????????????????????????????????????????token?????????redis
            String key = loginDTO.getType() + "-" + userId;
            if (null != redisTemplate.opsForValue().get(key)) {
                redisTemplate.delete(key);
                redisTemplate.opsForValue().set(key, jwt);
            } else {
                redisTemplate.opsForValue().set(key, jwt);
            }
            response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
            return ResultGenerator.genSuccessResult(jwt);
        } catch (AuthenticationException ae) {
            log.error("Authentication exception trace: {}", ae);
            return ResultGenerator.genFailResult("AuthenticationException: " + ae.getMessage());
        }
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }

    }
}
