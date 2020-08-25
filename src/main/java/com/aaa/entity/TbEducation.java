package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_education")
public class TbEducation implements Serializable {
    @Id
    private Integer education_id;

    private String education_school;

    private String education_specialty;

    private String education_occupation;

    private Integer education_inyear;

    private Integer education_outyear;

    private Integer user_id;

    private static final long serialVersionUID = 1L;

    /**
     * @return education_id
     */
    public Integer getEducation_id() {
        return education_id;
    }

    /**
     * @param education_id
     */
    public void setEducation_id(Integer education_id) {
        this.education_id = education_id;
    }

    /**
     * @return education_school
     */
    public String getEducation_school() {
        return education_school;
    }

    /**
     * @param education_school
     */
    public void setEducation_school(String education_school) {
        this.education_school = education_school;
    }

    /**
     * @return education_specialty
     */
    public String getEducation_specialty() {
        return education_specialty;
    }

    /**
     * @param education_specialty
     */
    public void setEducation_specialty(String education_specialty) {
        this.education_specialty = education_specialty;
    }

    /**
     * @return education_occupation
     */
    public String getEducation_occupation() {
        return education_occupation;
    }

    /**
     * @param education_occupation
     */
    public void setEducation_occupation(String education_occupation) {
        this.education_occupation = education_occupation;
    }

    /**
     * @return education_inyear
     */
    public Integer getEducation_inyear() {
        return education_inyear;
    }

    /**
     * @param education_inyear
     */
    public void setEducation_inyear(Integer education_inyear) {
        this.education_inyear = education_inyear;
    }

    /**
     * @return education_outyear
     */
    public Integer getEducation_outyear() {
        return education_outyear;
    }

    /**
     * @param education_outyear
     */
    public void setEducation_outyear(Integer education_outyear) {
        this.education_outyear = education_outyear;
    }

    /**
     * @return user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", education_id=").append(education_id);
        sb.append(", education_school=").append(education_school);
        sb.append(", education_specialty=").append(education_specialty);
        sb.append(", education_occupation=").append(education_occupation);
        sb.append(", education_inyear=").append(education_inyear);
        sb.append(", education_outyear=").append(education_outyear);
        sb.append(", user_id=").append(user_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}