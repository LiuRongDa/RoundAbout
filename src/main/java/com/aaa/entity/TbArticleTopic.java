package com.aaa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_article_topic")
public class TbArticleTopic implements Serializable {
    private Integer topic_id;

    private Integer article_id;

    private TbArticle tbArticle;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "TbArticleTopic{" +
                "topic_id=" + topic_id +
                ", article_id=" + article_id +
                ", tbArticle=" + tbArticle +
                '}';
    }

    public TbArticle getTbArticle() {
        return tbArticle;
    }

    public void setTbArticle(TbArticle tbArticle) {
        this.tbArticle = tbArticle;
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

}