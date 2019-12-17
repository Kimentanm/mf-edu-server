package com.mf.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tbl_role_permission_ref")
public class RolePermissionRef extends BaseModal {

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "permission_id")
    private Long permissionId;

}