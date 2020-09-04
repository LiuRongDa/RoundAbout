package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_comment")
public class TbComment implements Serializable {
    @Id
    private Integer comment_id;

    private String comment_content;

    private Integer user_id;

    private String comment_date;

    private Integer article_id;

    private TbUser tbUser;

    private List<TbReply> tbReplies;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "TbComment{" +
                "comment_id=" + comment_id +
                ", comment_content='" + comment_content + '\'' +
                ", user_id=" + user_id +
                ", comment_date='" + comment_date + '\'' +
                ", article_id=" + article_id +
                ", tbUser=" + tbUser +
                ", tbReplies=" + tbReplies +
                '}';
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public List<TbReply> getTbReplies() {
        return tbReplies;
    }

    public void setTbReplies(List<TbReply> tbReplies) {
        this.tbReplies = tbReplies;
    }
}