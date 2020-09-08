package com.aaa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_role")
public class TbRole implements Serializable {
    @Id
    private Integer role_id;

    private String role_name;

    private String role_admin_name;

    private static final long serialVersionUID = 1L;

    public String getRole_admin_name() {
        return role_admin_name;
    }

    public void setRole_admin_name(String role_admin_name) {
        this.role_admin_name = role_admin_name;
    }

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
        return "TbRole{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_admin_name='" + role_admin_name + '\'' +
                '}';
    }
}