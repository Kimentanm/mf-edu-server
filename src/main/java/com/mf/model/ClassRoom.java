package com.mf.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_class_room")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_by")
    private Long createBy;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "is_delete")
    private Boolean isDelete;

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

    private Integer version;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return create_by
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @return create_date
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * @return last_modified_by
     */
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * @return last_modified_date
     */
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * @return is_delete
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return class_name
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取班级对应的课程
     *
     * @return curriculum - 班级对应的课程
     */
    public String getCurriculum() {
        return curriculum;
    }

    /**
     * 设置班级对应的课程
     *
     * @param curriculum 班级对应的课程
     */
    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    /**
     * @return teacher_id
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * @param teacherId
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取开班时间
     *
     * @return class_start_time - 开班时间
     */
    public LocalDateTime getClassStartTime() {
        return classStartTime;
    }

    /**
     * 设置开班时间
     *
     * @param classStartTime 开班时间
     */
    public void setClassStartTime(LocalDateTime classStartTime) {
        this.classStartTime = classStartTime;
    }

    /**
     * 获取关班时间
     *
     * @return class_end_time - 关班时间
     */
    public LocalDateTime getClassEndTime() {
        return classEndTime;
    }

    /**
     * 设置关班时间
     *
     * @param classEndTime 关班时间
     */
    public void setClassEndTime(LocalDateTime classEndTime) {
        this.classEndTime = classEndTime;
    }

    /**
     * @return class_code
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * @param classCode
     */
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}