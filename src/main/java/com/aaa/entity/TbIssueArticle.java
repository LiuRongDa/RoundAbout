package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_issue_article")
public class TbIssueArticle implements Serializable {
    private Integer issue_id;

    private Integer article_id;

    private TbArticle tbArticle;

    private TbIssue tbIssue;

    public TbArticle getTbArticle() {
        return tbArticle;
    }

    public void setTbArticle(TbArticle tbArticle) {
        this.tbArticle = tbArticle;
    }

    public TbIssue getTbIssue() {
        return tbIssue;
    }

    public void setTbIssue(TbIssue tbIssue) {
        this.tbIssue = tbIssue;
    }

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        return "TbIssueArticle{" +
                "issue_id=" + issue_id +
                ", article_id=" + article_id +
                ", " + tbArticle +
                ", " + tbIssue +
                '}';
    }
}