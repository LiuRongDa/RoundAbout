package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "roundabout..tb_sgs")
public class TbSgs {
    @Id
    @Column(name = "sgs_id")
    private Integer sgsId;

    @Column(name = "sgs_school")
    private String sgsSchool;

    @Column(name = "sgs_info")
    private String sgsInfo;

    @Column(name = "sgs_prove")
    private String sgsProve;

    @Column(name = "sgs_name")
    private String sgsName;

    @Column(name = "sgs_idcard")
    private String sgsIdcard;

    @Column(name = "sgs_photo")
    private String sgsPhoto;

    @Column(name = "occupation_id")
    private Integer occupationId;

    @Column(name = "degree_id")
    private Integer degreeId;

    @Column(name = "career_id")
    private Integer careerId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "sgs_time")
    private Date sgsTime;

    @Column(name = "sgs_result")
    private Integer sgsResult;

    /**
     * @return sgs_id
     */
    public Integer getSgsId() {
        return sgsId;
    }

    /**
     * @param sgsId
     */
    public void setSgsId(Integer sgsId) {
        this.sgsId = sgsId;
    }

    /**
     * @return sgs_school
     */
    public String getSgsSchool() {
        return sgsSchool;
    }

    /**
     * @param sgsSchool
     */
    public void setSgsSchool(String sgsSchool) {
        this.sgsSchool = sgsSchool;
    }

    /**
     * @return sgs_info
     */
    public String getSgsInfo() {
        return sgsInfo;
    }

    /**
     * @param sgsInfo
     */
    public void setSgsInfo(String sgsInfo) {
        this.sgsInfo = sgsInfo;
    }

    /**
     * @return sgs_prove
     */
    public String getSgsProve() {
        return sgsProve;
    }

    /**
     * @param sgsProve
     */
    public void setSgsProve(String sgsProve) {
        this.sgsProve = sgsProve;
    }

    /**
     * @return sgs_name
     */
    public String getSgsName() {
        return sgsName;
    }

    /**
     * @param sgsName
     */
    public void setSgsName(String sgsName) {
        this.sgsName = sgsName;
    }

    /**
     * @return sgs_idcard
     */
    public String getSgsIdcard() {
        return sgsIdcard;
    }

    /**
     * @param sgsIdcard
     */
    public void setSgsIdcard(String sgsIdcard) {
        this.sgsIdcard = sgsIdcard;
    }

    /**
     * @return sgs_photo
     */
    public String getSgsPhoto() {
        return sgsPhoto;
    }

    /**
     * @param sgsPhoto
     */
    public void setSgsPhoto(String sgsPhoto) {
        this.sgsPhoto = sgsPhoto;
    }

    /**
     * @return occupation_id
     */
    public Integer getOccupationId() {
        return occupationId;
    }

    /**
     * @param occupationId
     */
    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    /**
     * @return degree_id
     */
    public Integer getDegreeId() {
        return degreeId;
    }

    /**
     * @param degreeId
     */
    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    /**
     * @return career_id
     */
    public Integer getCareerId() {
        return careerId;
    }

    /**
     * @param careerId
     */
    public void setCareerId(Integer careerId) {
        this.careerId = careerId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return sgs_time
     */
    public Date getSgsTime() {
        return sgsTime;
    }

    /**
     * @param sgsTime
     */
    public void setSgsTime(Date sgsTime) {
        this.sgsTime = sgsTime;
    }

    /**
     * @return sgs_result
     */
    public Integer getSgsResult() {
        return sgsResult;
    }

    /**
     * @param sgsResult
     */
    public void setSgsResult(Integer sgsResult) {
        this.sgsResult = sgsResult;
    }
}