package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_occupation")
public class TbOccupation {
    @Id
    @Column(name = "occupation_id")
    private Integer occupationId;

    @Column(name = "occupation_name")
    private String occupationName;

    /**
     * @return occupation_id
     */
    public Integer getOccupationId() {
        return occupationId;
    }

    /**
     * @param occupationId
     */
    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    /**
     * @return occupation_name
     */
    public String getOccupationName() {
        return occupationName;
    }

    /**
     * @param occupationName
     */
    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }
}