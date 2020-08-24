package com.aaa.entity;

import javax.persistence.*;

@Table(name = "roundabout..tb_education")
public class TbEducation {
    @Id
    @Column(name = "education_id")
    private Integer educationId;

    @Column(name = "education_school")
    private String educationSchool;

    @Column(name = "education_specialty")
    private String educationSpecialty;

    @Column(name = "occupation_id")
    private Integer occupationId;

    @Column(name = "year_in_id")
    private Integer yearInId;

    @Column(name = "year_out_id")
    private Integer yearOutId;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return education_id
     */
    public Integer getEducationId() {
        return educationId;
    }

    /**
     * @param educationId
     */
    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    /**
     * @return education_school
     */
    public String getEducationSchool() {
        return educationSchool;
    }

    /**
     * @param educationSchool
     */
    public void setEducationSchool(String educationSchool) {
        this.educationSchool = educationSchool;
    }

    /**
     * @return education_specialty
     */
    public String getEducationSpecialty() {
        return educationSpecialty;
    }

    /**
     * @param educationSpecialty
     */
    public void setEducationSpecialty(String educationSpecialty) {
        this.educationSpecialty = educationSpecialty;
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
     * @return year_in_id
     */
    public Integer getYearInId() {
        return yearInId;
    }

    /**
     * @param yearInId
     */
    public void setYearInId(Integer yearInId) {
        this.yearInId = yearInId;
    }

    /**
     * @return year_out_id
     */
    public Integer getYearOutId() {
        return yearOutId;
    }

    /**
     * @param yearOutId
     */
    public void setYearOutId(Integer yearOutId) {
        this.yearOutId = yearOutId;
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
}