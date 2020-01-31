package com.mf.model;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@Table(name = "tbl_class_room")
public class ClassRoom extends BaseModel {

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

    @Column(name = "grade_id")
    private Long gradeId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "pre_open_time")
    private LocalDateTime preOpenTime;

    @Column(name = "pre_close_time")
    private LocalDateTime preCloseTime;

    @Column(name = "open_time")
    private LocalDateTime openTime;

    @Column(name = "close_time")
    private LocalDateTime closeTime;

    private String type;

    @Transient
    private Teacher teacher;

    @Transient
    private Student student;
}