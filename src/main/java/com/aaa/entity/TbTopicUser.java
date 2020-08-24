package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_topic_user")
public class TbTopicUser {
    @Column(name = "topic_id")
    private Integer topicId;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return topic_id
     */
    public Integer getTopicId() {
        return topicId;
    }

    /**
     * @param topicId
     */
    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
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