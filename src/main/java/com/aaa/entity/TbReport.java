package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_report")
public class TbReport implements Serializable {
    @Id
    private Integer report_id;

    private Integer user_id;

    private Date report_data;

    private String report_content;

    private Integer issue_id;

    private Integer article_id;

    private Integer comment_id;

    private Integer reply_id;

    private Integer bereport_user_id;

    private TbUser tbUser;

    //问题表
    private TbIssue tbIssue;

    //文章
    private TbArticle tbArticle;

    //评论
    private TbComment tbComment;

    //回复
    private TbReply tbReply;

    private static final long serialVersionUID = 1L;

    /**
     * @return report_id
     */
    public Integer getReport_id() {
        return report_id;
    }

    /**
     * @param report_id
     */
    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
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

    /**
     * @return report_data
     */
    public Date getReport_data() {
        return report_data;
    }

    /**
     * @param report_data
     */
    public void setReport_data(Date report_data) {
        this.report_data = report_data;
    }

    /**
     * @return report_content
     */
    public String getReport_content() {
        return report_content;
    }

    /**
     * @param report_content
     */
    public void setReport_content(String report_content) {
        this.report_content = report_content;
    }

    /**
     * @return issue_id
     */
    public Integer getIssue_id() {
        return issue_id;
    }

    /**
     * @param issue_id
     */
    public void setIssue_id(Integer issue_id) {
        this.issue_id = issue_id;
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

    /**
     * @return comment_id
     */
    public Integer getComment_id() {
        return comment_id;
    }

    /**
     * @param comment_id
     */
    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    /**
     * @return reply_id
     */
    public Integer getReply_id() {
        return reply_id;
    }

    /**
     * @param reply_id
     */
    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public TbIssue getTbIssue() {
        return tbIssue;
    }

    public void setTbIssue(TbIssue tbIssue) {
        this.tbIssue = tbIssue;
    }

    public TbArticle getTbArticle() {
        return tbArticle;
    }

    public void setTbArticle(TbArticle tbArticle) {
        this.tbArticle = tbArticle;
    }

    public TbComment getTbComment() {
        return tbComment;
    }

    public void setTbComment(TbComment tbComment) {
        this.tbComment = tbComment;
    }

    public TbReply getTbReply() {
        return tbReply;
    }

    public void setTbReply(TbReply tbReply) {
        this.tbReply = tbReply;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public Integer getBereport_user_id() {
        return bereport_user_id;
    }

    public void setBereport_user_id(Integer bereport_user_id) {
        this.bereport_user_id = bereport_user_id;
    }

    @Override
    public String toString() {
        return "TbReport{" +
                "report_id=" + report_id +
                ", user_id=" + user_id +
                ", report_data=" + report_data +
                ", report_content='" + report_content + '\'' +
                ", issue_id=" + issue_id +
                ", article_id=" + article_id +
                ", comment_id=" + comment_id +
                ", reply_id=" + reply_id +
                ", bereport_user_id=" + bereport_user_id +
                ", tbUser=" + tbUser +
                ", tbIssue=" + tbIssue +
                ", tbArticle=" + tbArticle +
                ", tbComment=" + tbComment +
                ", tbReply=" + tbReply +
                '}';
    }
}