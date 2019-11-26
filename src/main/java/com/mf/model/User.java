package com.mf.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mobile;

    /**
     * 默认为员工的工号
     */
    @Column(name = "login_name")
    private String loginName;

    private String name;

    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    private String status;

    private String password;

    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 0: 平台用户，1:公司用户
     */
    private String type;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    private Integer version;

    @Transient
    private List<Role> roles;

    @Transient
    private List<Long> roleIds;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Transient
    private Role role;

    public UserRoleRef getUserRoleRef() {
        return userRoleRef;
    }

    public void setUserRoleRef(UserRoleRef userRoleRef) {
        this.userRoleRef = userRoleRef;
    }

    @Transient
    private UserRoleRef userRoleRef;
}