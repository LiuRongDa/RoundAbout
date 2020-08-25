package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_liveness")
public class TbLiveness implements Serializable {
    @Id
    private Integer liveness_id;

    private Date liveness_endtime;

    private Integer user_id;

    private static final long serialVersionUID = 1L;

    /**
     * @return liveness_id
     */
    public Integer getLiveness_id() {
        return liveness_id;
    }

    /**
     * @param liveness_id
     */
    public void setLiveness_id(Integer liveness_id) {
        this.liveness_id = liveness_id;
    }

    /**
     * @return liveness_endtime
     */
    public Date getLiveness_endtime() {
        return liveness_endtime;
    }

    /**
     * @param liveness_endtime
     */
    public void setLiveness_endtime(Date liveness_endtime) {
        this.liveness_endtime = liveness_endtime;
    }

    /**
     * @return user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", liveness_id=").append(liveness_id);
        sb.append(", liveness_endtime=").append(liveness_endtime);
        sb.append(", user_id=").append(user_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}