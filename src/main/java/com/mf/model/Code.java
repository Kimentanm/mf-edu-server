package com.mf.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "tbl_code")
public class Code {
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

    private Integer version;

    private String code;

    private String name;

    @Column(name = "seq_num")
    private Integer seqNum;

    private String description;

    @Column(name = "code_group_code")
    private String codeGroupCode;

    @Column(name = "is_delete")
    private Boolean isDelete;

}