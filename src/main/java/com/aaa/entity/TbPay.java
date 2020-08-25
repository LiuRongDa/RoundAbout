package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_pay")
public class TbPay implements Serializable {
    @Id
    private Integer pay_id;

    private Double pay_money;

    private Date pay_data;

    private Integer user_id;

    private Integer pay_state;

    private static final long serialVersionUID = 1L;

    /**
     * @return pay_id
     */
    public Integer getPay_id() {
        return pay_id;
    }

    /**
     * @param pay_id
     */
    public void setPay_id(Integer pay_id) {
        this.pay_id = pay_id;
    }

    /**
     * @return pay_money
     */
    public Double getPay_money() {
        return pay_money;
    }

    /**
     * @param pay_money
     */
    public void setPay_money(Double pay_money) {
        this.pay_money = pay_money;
    }

    /**
     * @return pay_data
     */
    public Date getPay_data() {
        return pay_data;
    }

    /**
     * @param pay_data
     */
    public void setPay_data(Date pay_data) {
        this.pay_data = pay_data;
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
     * @return pay_state
     */
    public Integer getPay_state() {
        return pay_state;
    }

    /**
     * @param pay_state
     */
    public void setPay_state(Integer pay_state) {
        this.pay_state = pay_state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pay_id=").append(pay_id);
        sb.append(", pay_money=").append(pay_money);
        sb.append(", pay_data=").append(pay_data);
        sb.append(", user_id=").append(user_id);
        sb.append(", pay_state=").append(pay_state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}