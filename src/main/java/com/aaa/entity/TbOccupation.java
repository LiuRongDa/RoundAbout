package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_occupation")
public class TbOccupation implements Serializable {
    @Id
    private Integer occupation_id;

    private String occupation_name;

    private static final long serialVersionUID = 1L;

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
     * @return occupation_name
     */
    public String getOccupation_name() {
        return occupation_name;
    }

    /**
     * @param occupation_name
     */
    public void setOccupation_name(String occupation_name) {
        this.occupation_name = occupation_name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", occupation_id=").append(occupation_id);
        sb.append(", occupation_name=").append(occupation_name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}