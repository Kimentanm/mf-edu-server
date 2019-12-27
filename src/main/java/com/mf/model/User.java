package com.mf.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "tbl_user")
public class User extends BaseModel {

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

    @Transient
    private UserRoleRef userRoleRef;
}