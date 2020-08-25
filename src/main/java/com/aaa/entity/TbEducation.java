package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_education")
public class TbEducation {
    @Id
    @Column(name = "education_id")
    private Integer educationId;

    @Column(name = "education_school")
    private String educationSchool;

    @Column(name = "education_specialty")
    private String educationSpecialty;

    @Column(name = "education_occupation")
    private Integer educationOccupationId;

    @Column(name = "education_inyear")
    private Integer educationInYear;

    @Column(name = "education_outyear")
    private Integer educationOutYear;

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
    public Integer getEducationOccupationId() {
        return educationOccupationId;
    }

    /**
     * @param educationOccupationId
     */
    public void setEducationOccupationId(Integer educationOccupationId) {
        this.educationOccupationId = educationOccupationId;
    }

    /**
     * @return year_in_id
     */
    public Integer getEducationInYear() {
        return educationInYear;
    }

    /**
     * @param educationInYear
     */
    public void setEducationInYear(Integer educationInYear) {
        this.educationInYear = educationInYear;
    }

    /**
     * @return year_out_id
     */
    public Integer getEducationOutYear() {
        return educationOutYear;
    }

    /**
     * @param educationOutYear
     */
    public void setEducationOutYear(Integer educationOutYear) {
        this.educationOutYear = educationOutYear;
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