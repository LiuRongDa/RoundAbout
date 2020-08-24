package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_article_gambit")
public class TbArticleGambit {
    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "gambit_id")
    private Integer gambitId;

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

    /**
     * @return gambit_id
     */
    public Integer getGambitId() {
        return gambitId;
    }

    /**
     * @param gambitId
     */
    public void setGambitId(Integer gambitId) {
        this.gambitId = gambitId;
    }
}