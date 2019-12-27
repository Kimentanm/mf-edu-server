package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_course")
public class Course extends BaseModel {

    private String description;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;
}