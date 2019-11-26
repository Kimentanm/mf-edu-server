package com.mf.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tbl_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "is_use")
    private Boolean isUse;

    private String email;

    private Integer gender;

    @Column(name = "job_number")
    private String jobNumber;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "office_phone")
    private String officePhone;

    @Column(name = "open_id")
    private String openId;

    private String password;

    @Column(name = "image_url")
    private String imageUrl;

    private Integer version;
}