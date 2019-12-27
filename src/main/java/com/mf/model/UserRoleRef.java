package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_user_role_ref")
public class UserRoleRef extends BaseModel {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;
}