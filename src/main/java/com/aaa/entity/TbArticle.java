package com.aaa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_article")
public class TbArticle implements Serializable {
    @Id
    private Integer article_id;

    private String article_title;

    private String article_content;

    private Integer user_id;

    private String article_photo;

    private Integer article_state;

    private Integer article_count;

    private TbUser tbUser;

    private Integer count;

    private String article_date;

    public List<TbComment> tbComments;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "TbArticle{" +
                "article_id=" + article_id +
                ", article_title='" + article_title + '\'' +
                ", article_content='" + article_content + '\'' +
                ", user_id=" + user_id +
                ", article_photo='" + article_photo + '\'' +
                ", article_state=" + article_state +
                ", article_count=" + article_count +
                ", tbUser=" + tbUser +
                ", count=" + count +
                ", article_date='" + article_date + '\'' +
                ", tbComments=" + tbComments +
                '}';
    }

    public List<TbComment> getTbComments() {
        return tbComments;
    }

    public void setTbComments(List<TbComment> tbComments) {
        this.tbComments = tbComments;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getArticle_photo() {
        return article_photo;
    }

    public void setArticle_photo(String article_photo) {
        this.article_photo = article_photo;
    }

    public Integer getArticle_state() {
        return article_state;
    }

    public void setArticle_state(Integer article_state) {
        this.article_state = article_state;
    }

    public Integer getArticle_count() {
        return article_count;
    }

    public void setArticle_count(Integer article_count) {
        this.article_count = article_count;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getArticle_date() {
        return article_date;
    }

    public void setArticle_date(String article_date) {
        this.article_date = article_date;
    }
}