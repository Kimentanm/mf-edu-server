package com.mf.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tbl_permission")
public class Permission {
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

    @Column(name = "can_delete")
    private Boolean canDelete;

    private String description;

    @Column(name = "display_sort")
    private Integer displaySort;

    private Boolean enable;

    @Column(name = "permission_code")
    private String permissionCode;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "reource_type")
    private String reourceType;

    @Column(name = "resource_url")
    private String resourceUrl;

    @Column(name = "parent_permission_id")
    private Long parentPermissionId;

    private Integer version;

}