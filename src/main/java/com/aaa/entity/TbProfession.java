package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_profession")
public class TbProfession {
    @Id
    @Column(name = "profession_id")
    private Integer professionId;

    @Column(name = "profession_company")
    private String professionCompany;

    @Column(name = "profession_position")
    private String professionPosition;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "profession_start")
    private Date professionStart;

    @Column(name = "profession_end")
    private Date professionEnd;

    /**
     * @return profession_id
     */
    public Integer getProfessionId() {
        return professionId;
    }

    /**
     * @param professionId
     */
    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    /**
     * @return profession_company
     */
    public String getProfessionCompany() {
        return professionCompany;
    }

    /**
     * @param professionCompany
     */
    public void setProfessionCompany(String professionCompany) {
        this.professionCompany = professionCompany;
    }

    /**
     * @return profession_position
     */
    public String getProfessionPosition() {
        return professionPosition;
    }

    /**
     * @param professionPosition
     */
    public void setProfessionPosition(String professionPosition) {
        this.professionPosition = professionPosition;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return profession_start
     */
    public Date getProfessionStart() {
        return professionStart;
    }

    /**
     * @param professionStart
     */
    public void setProfessionStart(Date professionStart) {
        this.professionStart = professionStart;
    }

    /**
     * @return profession_end
     */
    public Date getProfessionEnd() {
        return professionEnd;
    }

    /**
     * @param professionEnd
     */
    public void setProfessionEnd(Date professionEnd) {
        this.professionEnd = professionEnd;
    }
}