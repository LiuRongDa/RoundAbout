package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_career")
public class TbCareer {
    @Id
    @Column(name = "career_id")
    private Integer careerId;

    @Column(name = "career_name")
    private String careerName;

    @Column(name = "degree_id")
    private Integer degreeId;

    /**
     * @return career_id
     */
    public Integer getCareerId() {
        return careerId;
    }

    /**
     * @param careerId
     */
    public void setCareerId(Integer careerId) {
        this.careerId = careerId;
    }

    /**
     * @return career_name
     */
    public String getCareerName() {
        return careerName;
    }

    /**
     * @param careerName
     */
    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    /**
     * @return degree_id
     */
    public Integer getDegreeId() {
        return degreeId;
    }

    /**
     * @param degreeId
     */
    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }
}