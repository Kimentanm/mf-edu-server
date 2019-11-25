package com.mf.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

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

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return created_by
     */
    public Long getCreateBy() {
        return createdBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createdBy = createBy;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return last_modified_by
     */
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * @return last_modified_date
     */
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * @return is_delete
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return can_delete
     */
    public Boolean getCanDelete() {
        return canDelete;
    }

    /**
     * @param canDelete
     */
    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return display_sort
     */
    public Integer getDisplaySort() {
        return displaySort;
    }

    /**
     * @param displaySort
     */
    public void setDisplaySort(Integer displaySort) {
        this.displaySort = displaySort;
    }

    /**
     * @return enable
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * @param enable
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * @return permission_code
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * @param permissionCode
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * @return permission_name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * @return reource_type
     */
    public String getReourceType() {
        return reourceType;
    }

    /**
     * @param reourceType
     */
    public void setReourceType(String reourceType) {
        this.reourceType = reourceType;
    }

    /**
     * @return resource_url
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * @param resourceUrl
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * @return parent_permission_id
     */
    public Long getParentPermissionId() {
        return parentPermissionId;
    }

    /**
     * @param parentPermissionId
     */
    public void setParentPermissionId(Long parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}