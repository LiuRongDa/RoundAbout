package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_collect_article")
public class TbCollectArticle {
    @Column(name = "collect_id")
    private Integer collectId;

    @Column(name = "article_id")
    private Integer articleId;

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