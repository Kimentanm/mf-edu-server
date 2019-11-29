package com.mf.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "tbl_code")
public class Code extends BaseModal{

    private String code;

    private String name;

    @Column(name = "seq_num")
    private Integer seqNum;

    private String description;

    @Column(name = "code_group_code")
    private String codeGroupCode;
}