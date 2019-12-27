package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_student")
public class Student extends BaseModel {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "is_use")
    private Boolean isUse;

    private String email;

    private Integer gender;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "open_id")
    private String openId;

    private String password;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "image_url")
    private String imageUrl;

    private String signature;

}