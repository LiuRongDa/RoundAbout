package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_topic_user")
public class TbTopicUser implements Serializable {
    private Integer topic_id;

    private Integer user_id;

    private static final long serialVersionUID = 1L;

    /**
     * @return topic_id
     */
    public Integer getTopic_id() {
        return topic_id;
    }

    /**
     * @param topic_id
     */
    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
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
        sb.append(", topic_id=").append(topic_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}