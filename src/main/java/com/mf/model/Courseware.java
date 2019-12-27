package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_courseware")
public class Courseware extends BaseModal {

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

    private String url;

    private String type;

    private String remark;

    @Column(name = "download_times")
    private Integer downloadTimes;

}