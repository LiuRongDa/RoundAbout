package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_attention")
public class TbAttention {
    @Id
    @Column(name = "attention_id")
    private Integer attentionId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_idl")
    private Integer userIdl;

    /**
     * @return attention_id
     */
    public Integer getAttentionId() {
        return attentionId;
    }

    /**
     * @param attentionId
     */
    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
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
}