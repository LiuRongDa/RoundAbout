package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_power")
public class TbPower {
    @Id
    @Column(name = "power_id")
    private Integer powerId;

    @Column(name = "power_name")
    private String powerName;

    @Column(name = "power_url")
    private String powerUrl;

    /**
     * @return power_id
     */
    public Integer getPowerId() {
        return powerId;
    }

    /**
     * @param powerId
     */
    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    /**
     * @return power_name
     */
    public String getPowerName() {
        return powerName;
    }

    /**
     * @param powerName
     */
    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    /**
     * @return power_url
     */
    public String getPowerUrl() {
        return powerUrl;
    }

    /**
     * @param powerUrl
     */
    public void setPowerUrl(String powerUrl) {
        this.powerUrl = powerUrl;
    }
}