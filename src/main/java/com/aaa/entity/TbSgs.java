package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sgs")
public class TbSgs implements Serializable {
    @Id
    private Integer sgs_id;

    private String sgs_school;

    private String sgs_info;

    private String sgs_prove;

    private String sgs_name;

    private String sgs_idcard;

    private String sgs_photo;

    private Integer occupation_id;

    private Integer degree_id;

    private Integer career_id;

    private Integer user_id;

    private Date sgs_time;

    private Integer sgs_result;

    private static final long serialVersionUID = 1L;

    /**
     * @return sgs_id
     */
    public Integer getSgs_id() {
        return sgs_id;
    }

    /**
     * @param sgs_id
     */
    public void setSgs_id(Integer sgs_id) {
        this.sgs_id = sgs_id;
    }

    /**
     * @return sgs_school
     */
    public String getSgs_school() {
        return sgs_school;
    }

    /**
     * @param sgs_school
     */
    public void setSgs_school(String sgs_school) {
        this.sgs_school = sgs_school;
    }

    /**
     * @return sgs_info
     */
    public String getSgs_info() {
        return sgs_info;
    }

    /**
     * @param sgs_info
     */
    public void setSgs_info(String sgs_info) {
        this.sgs_info = sgs_info;
    }

    /**
     * @return sgs_prove
     */
    public String getSgs_prove() {
        return sgs_prove;
    }

    /**
     * @param sgs_prove
     */
    public void setSgs_prove(String sgs_prove) {
        this.sgs_prove = sgs_prove;
    }

    /**
     * @return sgs_name
     */
    public String getSgs_name() {
        return sgs_name;
    }

    /**
     * @param sgs_name
     */
    public void setSgs_name(String sgs_name) {
        this.sgs_name = sgs_name;
    }

    /**
     * @return sgs_idcard
     */
    public String getSgs_idcard() {
        return sgs_idcard;
    }

    /**
     * @param sgs_idcard
     */
    public void setSgs_idcard(String sgs_idcard) {
        this.sgs_idcard = sgs_idcard;
    }

    /**
     * @return sgs_photo
     */
    public String getSgs_photo() {
        return sgs_photo;
    }

    /**
     * @param sgs_photo
     */
    public void setSgs_photo(String sgs_photo) {
        this.sgs_photo = sgs_photo;
    }

    /**
     * @return occupation_id
     */
    public Integer getOccupation_id() {
        return occupation_id;
    }

    /**
     * @param occupation_id
     */
    public void setOccupation_id(Integer occupation_id) {
        this.occupation_id = occupation_id;
    }

    /**
     * @return degree_id
     */
    public Integer getDegree_id() {
        return degree_id;
    }

    /**
     * @param degree_id
     */
    public void setDegree_id(Integer degree_id) {
        this.degree_id = degree_id;
    }

    /**
     * @return career_id
     */
    public Integer getCareer_id() {
        return career_id;
    }

    /**
     * @param career_id
     */
    public void setCareer_id(Integer career_id) {
        this.career_id = career_id;
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

    /**
     * @return sgs_time
     */
    public Date getSgs_time() {
        return sgs_time;
    }

    /**
     * @param sgs_time
     */
    public void setSgs_time(Date sgs_time) {
        this.sgs_time = sgs_time;
    }

    /**
     * @return sgs_result
     */
    public Integer getSgs_result() {
        return sgs_result;
    }

    /**
     * @param sgs_result
     */
    public void setSgs_result(Integer sgs_result) {
        this.sgs_result = sgs_result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sgs_id=").append(sgs_id);
        sb.append(", sgs_school=").append(sgs_school);
        sb.append(", sgs_info=").append(sgs_info);
        sb.append(", sgs_prove=").append(sgs_prove);
        sb.append(", sgs_name=").append(sgs_name);
        sb.append(", sgs_idcard=").append(sgs_idcard);
        sb.append(", sgs_photo=").append(sgs_photo);
        sb.append(", occupation_id=").append(occupation_id);
        sb.append(", degree_id=").append(degree_id);
        sb.append(", career_id=").append(career_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", sgs_time=").append(sgs_time);
        sb.append(", sgs_result=").append(sgs_result);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}