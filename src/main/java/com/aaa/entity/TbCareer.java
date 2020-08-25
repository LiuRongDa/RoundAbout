package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_career")
public class TbCareer implements Serializable {
    @Id
    private Integer career_id;

    private String career_name;

    private Integer degree_id;

    private static final long serialVersionUID = 1L;

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
     * @return career_name
     */
    public String getCareer_name() {
        return career_name;
    }

    /**
     * @param career_name
     */
    public void setCareer_name(String career_name) {
        this.career_name = career_name;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", career_id=").append(career_id);
        sb.append(", career_name=").append(career_name);
        sb.append(", degree_id=").append(degree_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}