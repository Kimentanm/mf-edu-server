package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_role")
public class Role extends BaseModal{

    private String code;

    private String name;

    private String description;

}