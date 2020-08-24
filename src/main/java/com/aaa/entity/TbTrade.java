package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_trade")
public class TbTrade {
    @Id
    @Column(name = "trade_id")
    private Integer tradeId;

    @Column(name = "trade_name")
    private String tradeName;

    /**
     * @return trade_id
     */
    public Integer getTradeId() {
        return tradeId;
    }

    /**
     * @param tradeId
     */
    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    /**
     * @return trade_name
     */
    public String getTradeName() {
        return tradeName;
    }

    /**
     * @param tradeName
     */
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }
}