package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_version")
public class Version extends BaseModel {

    @Column(name = "version_no")
    private Long versionNo;

    @Column(name = "res_url")
    private String resUrl;

    @Column(name = "res_hash")
    private String resHash;

    private String type;

    private String description;

    @Column(name = "update_log")
    private String updateLog;
}