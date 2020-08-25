package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_reward")
public class TbReward implements Serializable {
    @Id
    private Integer reward_id;

    private Integer user_id;

    private Integer user_idl;

    private Double reward_money;

    private Date reward_date;

    private static final long serialVersionUID = 1L;

    /**
     * @return reward_id
     */
    public Integer getReward_id() {
        return reward_id;
    }

    /**
     * @param reward_id
     */
    public void setReward_id(Integer reward_id) {
        this.reward_id = reward_id;
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

    /**
     * @return user_idl
     */
    public Integer getUser_idl() {
        return user_idl;
    }

    /**
     * @param user_idl
     */
    public void setUser_idl(Integer user_idl) {
        this.user_idl = user_idl;
    }

    /**
     * @return reward_money
     */
    public Double getReward_money() {
        return reward_money;
    }

    /**
     * @param reward_money
     */
    public void setReward_money(Double reward_money) {
        this.reward_money = reward_money;
    }

    /**
     * @return reward_date
     */
    public Date getReward_date() {
        return reward_date;
    }

    /**
     * @param reward_date
     */
    public void setReward_date(Date reward_date) {
        this.reward_date = reward_date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reward_id=").append(reward_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", user_idl=").append(user_idl);
        sb.append(", reward_money=").append(reward_money);
        sb.append(", reward_date=").append(reward_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}