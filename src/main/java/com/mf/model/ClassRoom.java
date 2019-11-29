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

    /**
     * 开班时间
     */
    @Column(name = "class_start_time")
    private LocalDateTime classStartTime;

    /**
     * 关班时间
     */
    @Column(name = "class_end_time")
    private LocalDateTime classEndTime;

    @Column(name = "class_code")
    private String classCode;

}