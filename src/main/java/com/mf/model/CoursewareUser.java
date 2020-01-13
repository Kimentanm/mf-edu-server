package com.mf.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tbl_courseware_user")
public class CoursewareUser extends BaseModel {

    private String description;

    @Column(name = "user_id")
    private Long userId;

    private String name;

    private Double size;

}