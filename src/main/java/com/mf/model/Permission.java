package com.mf.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Table(name = "tbl_permission")
public class Permission extends BaseModal{

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

    @Transient
    private List<Permission> children;

    @Transient
    private String title;

    @Transient
    private Boolean expand;

    public String getTitle() {
        return permissionName;
    }

    public Boolean getExpand() {
        return true;
    }
}