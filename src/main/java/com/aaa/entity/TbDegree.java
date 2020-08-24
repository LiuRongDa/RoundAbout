package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_degree")
public class TbDegree {
    @Id
    @Column(name = "degree_id")
    private Integer degreeId;

    @Column(name = "degree_name")
    private String degreeName;

    @Column(name = "occupation_id")
    private Integer occupationId;

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

    /**
     * @return degree_name
     */
    public String getDegreeName() {
        return degreeName;
    }

    /**
     * @param degreeName
     */
    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

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
}