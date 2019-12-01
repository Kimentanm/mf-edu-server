package com.mf.dto;

import com.google.common.base.Converter;
import com.mf.model.Permission;

import java.util.List;

public class PermissionListDTO {

    /**
     * 权限Id
     */
    private Long permissionId;

    /**
     * 父权限ID
     */
    private Long parentPermissionId;

    /**
     * 权限Code
     */
    private String permissionCode;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 权限排序
     */
    private Integer displaySort;

    /**
     * 启用权限
     */
    private Boolean enable;

    private String resourceUrl;

    /**
     * 子权限
     */
    private List<PermissionListDTO> sonPermissions;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getParentPermissionId() {
        return parentPermissionId;
    }

    public void setParentPermissionId(Long parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDisplaySort() {
        return displaySort;
    }

    public void setDisplaySort(Integer displaySort) {
        this.displaySort = displaySort;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public List<PermissionListDTO> getSonPermissions() {
        return sonPermissions;
    }

    public void setSonPermissions(List<PermissionListDTO> sonPermissions) {
        this.sonPermissions = sonPermissions;
    }

    public Permission convertTo() {
        PermissionConverter converter = new PermissionConverter();
        return converter.convert(this);
    }

    public PermissionListDTO convertFrom(Permission permission) {
        PermissionConverter converter = new PermissionConverter();
        return converter.reverse().convert(permission);
    }

    private static class PermissionConverter extends Converter<PermissionListDTO, Permission> {

        @Override
        protected Permission doForward(PermissionListDTO permissionListDTO) {
            return null;
        }

        @Override
        protected PermissionListDTO doBackward(Permission permission) {
            PermissionListDTO listDTO = new PermissionListDTO();
            listDTO.setPermissionId(permission.getId());
            listDTO.setPermissionCode(permission.getPermissionCode());
            listDTO.setParentPermissionId(permission.getParentPermissionId());
            return listDTO;
        }
    }
}
