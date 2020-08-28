package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_article_gambit")
public class TbArticleGambit implements Serializable {
    private Integer article_id;

    private Integer gambit_id;

    private static final long serialVersionUID = 1L;

    private TbArticle tbArticle;

    private TbGambit tbGambit;

    @Override
    public String toString() {
        return "TbArticleGambit{" +
                "article_id=" + article_id +
                ", gambit_id=" + gambit_id +
                ", tbArticle=" + tbArticle +
                ", tbGambit=" + tbGambit +
                '}';
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getGambit_id() {
        return gambit_id;
    }

    public void setGambit_id(Integer gambit_id) {
        this.gambit_id = gambit_id;
    }

    public TbArticle getTbArticle() {
        return tbArticle;
    }

    public void setTbArticle(TbArticle tbArticle) {
        this.tbArticle = tbArticle;
    }

    public TbGambit getTbGambit() {
        return tbGambit;
    }

    public void setTbGambit(TbGambit tbGambit) {
        this.tbGambit = tbGambit;
    }
}