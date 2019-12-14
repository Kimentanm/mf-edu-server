package com.mf.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "tbl_role")
public class Role extends BaseModal{

    private String code;

    private String name;

    private String description;

    @Transient
    private List<RolePermissionRef> rolePermissionRefs;

    @Transient
    private List<Permission> permissions;

}