package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_article_topic")
public class TbArticleTopic implements Serializable {
    private Integer topic_id;

    private Integer article_id;

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
     * @return article_id
     */
    public Integer getArticle_id() {
        return article_id;
    }

    /**
     * @param article_id
     */
    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", topic_id=").append(topic_id);
        sb.append(", article_id=").append(article_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}