package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_collect")
public class TbCollect {
    @Id
    @Column(name = "collect_id")
    private Integer collectId;

    @Column(name = "collect_title")
    private String collectTitle;

    @Column(name = "collect_describe")
    private String collectDescribe;

    @Column(name = "collect_state")
    private Integer collectState;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return collect_id
     */
    public Integer getCollectId() {
        return collectId;
    }

    /**
     * @param collectId
     */
    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    /**
     * @return collect_title
     */
    public String getCollectTitle() {
        return collectTitle;
    }

    /**
     * @param collectTitle
     */
    public void setCollectTitle(String collectTitle) {
        this.collectTitle = collectTitle;
    }

    /**
     * @return collect_describe
     */
    public String getCollectDescribe() {
        return collectDescribe;
    }

    /**
     * @param collectDescribe
     */
    public void setCollectDescribe(String collectDescribe) {
        this.collectDescribe = collectDescribe;
    }

    /**
     * @return collect_state
     */
    public Integer getCollectState() {
        return collectState;
    }

    /**
     * @param collectState
     */
    public void setCollectState(Integer collectState) {
        this.collectState = collectState;
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