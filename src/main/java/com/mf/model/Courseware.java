package com.mf.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_courseware")
public class Courseware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "is_delete")
    private Boolean isDelete;

    private String description;

    /**
     * 课件名称
     */
    @Column(name = "courseware_name")
    private String coursewareName;

    /**
     * 课件代码
     */
    @Column(name = "courseware_code")
    private String coursewareCode;

    private Integer version;

    private String url;

    private String type;

    private String remark;

    @Column(name = "download_times")
    private Integer downloadTimes;

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
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return created_date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
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
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
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
     * 获取课件名称
     *
     * @return courseware_name - 课件名称
     */
    public String getCoursewareName() {
        return coursewareName;
    }

    /**
     * 设置课件名称
     *
     * @param coursewareName 课件名称
     */
    public void setCoursewareName(String coursewareName) {
        this.coursewareName = coursewareName;
    }

    /**
     * 获取课件代码
     *
     * @return courseware_code - 课件代码
     */
    public String getCoursewareCode() {
        return coursewareCode;
    }

    /**
     * 设置课件代码
     *
     * @param coursewareCode 课件代码
     */
    public void setCoursewareCode(String coursewareCode) {
        this.coursewareCode = coursewareCode;
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

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return download_times
     */
    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    /**
     * @param downloadTimes
     */
    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }
}