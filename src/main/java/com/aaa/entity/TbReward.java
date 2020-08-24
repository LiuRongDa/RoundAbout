package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "roundabout..tb_reward")
public class TbReward {
    @Id
    @Column(name = "reward_id")
    private Integer rewardId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_idl")
    private Integer userIdl;

    @Column(name = "reward_money")
    private Double rewardMoney;

    @Column(name = "reward_date")
    private Date rewardDate;

    /**
     * @return reward_id
     */
    public Integer getRewardId() {
        return rewardId;
    }

    /**
     * @param rewardId
     */
    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
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
     * @return user_idl
     */
    public Integer getUserIdl() {
        return userIdl;
    }

    /**
     * @param userIdl
     */
    public void setUserIdl(Integer userIdl) {
        this.userIdl = userIdl;
    }

    /**
     * @return reward_money
     */
    public Double getRewardMoney() {
        return rewardMoney;
    }

    /**
     * @param rewardMoney
     */
    public void setRewardMoney(Double rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    /**
     * @return reward_date
     */
    public Date getRewardDate() {
        return rewardDate;
    }

    /**
     * @param rewardDate
     */
    public void setRewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
    }
}