package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_reply")
public class TbReply implements Serializable {
    @Id
    private Integer reply_id;

    private String reply_content;

    private Integer user_id;

    private Integer comment_id;

    private Integer reply_idto;

    private String reply_date;

    private TbReply tbReplies;

    private TbUser tbUser;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "TbReply{" +
                "reply_id=" + reply_id +
                ", reply_content='" + reply_content + '\'' +
                ", user_id=" + user_id +
                ", comment_id=" + comment_id +
                ", reply_idto=" + reply_idto +
                ", reply_date=" + reply_date +
                ", tbReplies=" + tbReplies +
                ", tbUser=" + tbUser +
                '}';
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getReply_idto() {
        return reply_idto;
    }

    public void setReply_idto(Integer reply_idto) {
        this.reply_idto = reply_idto;
    }

    public String getReply_date() {
        return reply_date;
    }

    public void setReply_date(String reply_date) {
        this.reply_date = reply_date;
    }

    public TbReply getTbReplies() {
        return tbReplies;
    }

    public void setTbReplies(TbReply tbReplies) {
        this.tbReplies = tbReplies;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }
}