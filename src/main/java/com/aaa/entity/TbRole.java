package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_role")
public class TbRole implements Serializable {
    @Id
    private Integer role_id;

    private String role_name;

    private static final long serialVersionUID = 1L;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", role_id=").append(role_id);
        sb.append(", role_name=").append(role_name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}