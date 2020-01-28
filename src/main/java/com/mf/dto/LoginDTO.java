package com.mf.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private Long id;

    private String openId;

    private String username;

    private String password;

    private String verifyCode;

    private Boolean rememberMe;

    private String type;

}
