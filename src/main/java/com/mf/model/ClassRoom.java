package com.mf.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tbl_class_room")
public class ClassRoom extends BaseModal{

    @Column(name = "class_name")
    private String className;

    /**
     * 班级对应的课程
     */
    private String curriculum;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "class_code")
    private String classCode;

    @Transient
    private Teacher teacher;

    @Transient
    private Student student;
}