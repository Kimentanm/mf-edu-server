package com.mf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_lesson")
public class Lesson extends BaseModal {

    private String remark;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "lesson_code")
    private String lessonCode;

    private String description;

}