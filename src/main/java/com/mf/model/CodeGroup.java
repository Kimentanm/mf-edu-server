package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_code_group")
public class CodeGroup extends BaseModel {

    private String code;

    private String name;

    private String description;

}