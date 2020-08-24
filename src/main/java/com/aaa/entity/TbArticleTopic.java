package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_article_topic")
public class TbArticleTopic {
    @Column(name = "topic_id")
    private Integer topicId;

    @Column(name = "article_id")
    private Integer articleId;

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
     * @return article_id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}