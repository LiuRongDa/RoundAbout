package com.aaa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_topic")
public class TbTopic implements Serializable {
    @Id
    private Integer topic_id;

    private String topic_name;

    private Integer user_id;

    private String topic_date;

    private Integer topic_count;

    private Integer count;

    private List<TbUser> tbUser;

    private List<TbTopicUser> tbTopicUser;

    private TbArticleTopic tbArticleTopic;

    private List<TbArticle> tbArticle;

    private static final long serialVersionUID = 1L;

    public String getTopic_date() {
        return topic_date;
    }

    public void setTopic_date(String topic_date) {
        this.topic_date = topic_date;
    }

    public Integer getTopic_count() {
        return topic_count;
    }

    public void setTopic_count(Integer topic_count) {
        this.topic_count = topic_count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<TbArticle> getTbArticle() {
        return tbArticle;
    }

    public void setTbArticle(List<TbArticle> tbArticle) {
        this.tbArticle = tbArticle;
    }


    public TbArticleTopic getTbArticleTopic() {
        return tbArticleTopic;
    }

    public void setTbArticleTopic(TbArticleTopic tbArticleTopic) {
        this.tbArticleTopic = tbArticleTopic;
    }

    public List<TbTopicUser> getTbTopicUser() {
        return tbTopicUser;
    }

    public void setTbTopicUser(List<TbTopicUser> tbTopicUser) {
        this.tbTopicUser = tbTopicUser;
    }

    public List<TbUser> getTbUser() {
        return tbUser;
    }

    public void setTbUser(List<TbUser> tbUser) {
        this.tbUser = tbUser;
    }

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
     * @return topic_name
     */
    public String getTopic_name() {
        return topic_name;
    }

    /**
     * @param topic_name
     */
    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
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

  /*  @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", topic_id=").append(topic_id);
        sb.append(", topic_name=").append(topic_name);
        sb.append(", user_id=").append(user_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }*/

    @Override
    public String toString() {
        return "TbTopic{" +
                "topic_id=" + topic_id +
                ", topic_name='" + topic_name + '\'' +
                ", user_id=" + user_id +
                ", topic_date='" + topic_date + '\'' +
                ", topic_count=" + topic_count +
                ", count=" + count +
                ", tbUser=" + tbUser +
                ", tbTopicUser=" + tbTopicUser +
                ", tbArticleTopic=" + tbArticleTopic +
                ", tbArticle=" + tbArticle +
                '}';
    }
}