package com.mf.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "tbl_code_group")
public class CodeGroup extends BaseModal{

    private String code;

    private String name;

    private String description;

}