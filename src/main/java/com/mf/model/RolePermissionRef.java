package com.mf.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_role_permission_ref")
public class RolePermissionRef extends BaseModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDate lastModifiedDate;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "permission_id")
    private Long permissionId;

}