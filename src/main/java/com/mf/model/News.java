package com.mf.model;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.*;

@Data
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

}