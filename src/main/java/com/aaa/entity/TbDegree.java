package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_degree")
public class TbDegree implements Serializable {
    @Id
    private Integer degree_id;

    private String degree_name;

    private Integer occupation_id;

    private static final long serialVersionUID = 1L;

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
     * @return degree_name
     */
    public String getDegree_name() {
        return degree_name;
    }

    /**
     * @param degree_name
     */
    public void setDegree_name(String degree_name) {
        this.degree_name = degree_name;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", degree_id=").append(degree_id);
        sb.append(", degree_name=").append(degree_name);
        sb.append(", occupation_id=").append(occupation_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}