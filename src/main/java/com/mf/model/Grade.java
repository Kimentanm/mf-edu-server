package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_grade")
public class Grade extends BaseModal {

    @Column(name = "grade_name")
    private String gradeName;

    @Column(name = "grade_code")
    private String gradeCode;

    private String description;

}