package com.mf.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tbl_classroom_student_ref")
public class ClassroomStudentRef extends BaseModel {

    /**
     * 教室id
     */
    @Column(name = "class_id")
    private Long classId;

    /**
     * 学生id
     */
    @Column(name = "student_id")
    private Long studentId;

    private String description;

}