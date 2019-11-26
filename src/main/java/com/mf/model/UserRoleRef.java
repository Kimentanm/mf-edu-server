package com.mf.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tbl_user_role_ref")
public class UserRoleRef {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    private Integer version;
}