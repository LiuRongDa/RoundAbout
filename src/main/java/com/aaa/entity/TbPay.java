package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_pay")
public class TbPay {
    @Id
    @Column(name = "pay_id")
    private Integer payId;

    @Column(name = "pay_money")
    private Double payMoney;

    @Column(name = "pay_data")
    private Date payData;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "pay_state")
    private Integer payState;

    /**
     * @return pay_id
     */
    public Integer getPayId() {
        return payId;
    }

    /**
     * @param payId
     */
    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    /**
     * @return pay_money
     */
    public Double getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney
     */
    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * @return pay_data
     */
    public Date getPayData() {
        return payData;
    }

    /**
     * @param payData
     */
    public void setPayData(Date payData) {
        this.payData = payData;
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
     * @return pay_state
     */
    public Integer getPayState() {
        return payState;
    }

    /**
     * @param payState
     */
    public void setPayState(Integer payState) {
        this.payState = payState;
    }
}