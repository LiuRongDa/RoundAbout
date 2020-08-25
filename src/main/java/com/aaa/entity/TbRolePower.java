package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_role_power")
public class TbRolePower implements Serializable {
    private Integer role_id;

    private Integer power_id;

    private static final long serialVersionUID = 1L;

    /**
     * @return role_id
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * @param role_id
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * @return power_id
     */
    public Integer getPower_id() {
        return power_id;
    }

    /**
     * @param power_id
     */
    public void setPower_id(Integer power_id) {
        this.power_id = power_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", role_id=").append(role_id);
        sb.append(", power_id=").append(power_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}