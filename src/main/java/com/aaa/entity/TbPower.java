package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_power")
public class TbPower implements Serializable {
    @Id
    private Integer power_id;

    private String power_name;

    private String power_url;

    private static final long serialVersionUID = 1L;

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

    /**
     * @return power_name
     */
    public String getPower_name() {
        return power_name;
    }

    /**
     * @param power_name
     */
    public void setPower_name(String power_name) {
        this.power_name = power_name;
    }

    /**
     * @return power_url
     */
    public String getPower_url() {
        return power_url;
    }

    /**
     * @param power_url
     */
    public void setPower_url(String power_url) {
        this.power_url = power_url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", power_id=").append(power_id);
        sb.append(", power_name=").append(power_name);
        sb.append(", power_url=").append(power_url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}