package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_trade")
public class TbTrade implements Serializable {
    @Id
    private Integer trade_id;

    private String trade_name;

    private static final long serialVersionUID = 1L;

    /**
     * @return trade_id
     */
    public Integer getTrade_id() {
        return trade_id;
    }

    /**
     * @param trade_id
     */
    public void setTrade_id(Integer trade_id) {
        this.trade_id = trade_id;
    }

    /**
     * @return trade_name
     */
    public String getTrade_name() {
        return trade_name;
    }

    /**
     * @param trade_name
     */
    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", trade_id=").append(trade_id);
        sb.append(", trade_name=").append(trade_name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}