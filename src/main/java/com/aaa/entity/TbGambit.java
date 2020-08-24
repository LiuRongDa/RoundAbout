package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_gambit")
public class TbGambit {
    @Id
    @Column(name = "gambit_id")
    private Integer gambitId;

    @Column(name = "gambit_name")
    private String gambitName;

    /**
     * @return gambit_id
     */
    public Integer getGambitId() {
        return gambitId;
    }

    /**
     * @param gambitId
     */
    public void setGambitId(Integer gambitId) {
        this.gambitId = gambitId;
    }

    /**
     * @return gambit_name
     */
    public String getGambitName() {
        return gambitName;
    }

    /**
     * @param gambitName
     */
    public void setGambitName(String gambitName) {
        this.gambitName = gambitName;
    }
}