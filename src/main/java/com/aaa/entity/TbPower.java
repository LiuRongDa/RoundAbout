package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_power")
public class TbPower implements Serializable {
    @Id
    private Integer power_id;

    private String power_name;

    private String power_url;

    private Integer fid;

    private String icon;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
        return "TbPower{" +
                "power_id=" + power_id +
                ", power_name='" + power_name + '\'' +
                ", power_url='" + power_url + '\'' +
                ", fid=" + fid +
                ", icon='" + icon + '\'' +
                '}';
    }
}