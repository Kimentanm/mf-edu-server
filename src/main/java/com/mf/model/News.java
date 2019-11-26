package com.mf.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Table(name = "tbl_news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "is_delete")
    private Boolean isDelete;

    private Integer version;

    /**
     * 主题
     */
    private String title;

    /**
     * 概括
     */
    private String summary;

    /**
     * 发布时间
     */
    @Column(name = "publish_date")
    private LocalDateTime publishDate;

    /**
     * 封面图片
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 状态标志位（1：xxx）
     */
    private Integer status;

    /**
     * 推荐标志位（1：xxx）
     */
    @Column(name = "recommend_ind")
    private Integer recommendInd;

    /**
     * 用于哪个function
     */
    @Column(name = "function_code")
    private String functionCode;

    /**
     * 详情
     */
    private String detail;

    @Column(name = "publish_user_id")
    private Long publishUserId;

    @Transient
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
    }

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
     * @return created_date
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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
     * 获取主题
     *
     * @return title - 主题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置主题
     *
     * @param title 主题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取概括
     *
     * @return summary - 概括
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置概括
     *
     * @param summary 概括
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取发布时间
     *
     * @return publish_date - 发布时间
     */
    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    /**
     * 设置发布时间
     *
     * @param publishDate 发布时间
     */
    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取封面图片
     *
     * @return image_url - 封面图片
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置封面图片
     *
     * @param imageUrl 封面图片
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取状态标志位（1：xxx）
     *
     * @return status - 状态标志位（1：xxx）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态标志位（1：xxx）
     *
     * @param status 状态标志位（1：xxx）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取用于哪个function
     *
     * @return function_code - 用于哪个function
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * 设置用于哪个function
     *
     * @param functionCode 用于哪个function
     */
    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    /**
     * 获取详情
     *
     * @return detail - 详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置详情
     *
     * @param detail 详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getRecommendInd() {
        return recommendInd;
    }

    public void setRecommendInd(Integer recommendInd) {
        this.recommendInd = recommendInd;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }
}