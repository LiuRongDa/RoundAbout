package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_liveness")
public class TbLiveness {
    @Id
    @Column(name = "liveness_id")
    private Integer livenessId;

    @Column(name = "liveness_endtime")
    private Date livenessEndtime;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return liveness_id
     */
    public Integer getLivenessId() {
        return livenessId;
    }

    /**
     * @param livenessId
     */
    public void setLivenessId(Integer livenessId) {
        this.livenessId = livenessId;
    }

    /**
     * @return liveness_endtime
     */
    public Date getLivenessEndtime() {
        return livenessEndtime;
    }

    /**
     * @param livenessEndtime
     */
    public void setLivenessEndtime(Date livenessEndtime) {
        this.livenessEndtime = livenessEndtime;
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
}