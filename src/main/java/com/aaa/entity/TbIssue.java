package com.aaa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_issue")
public class TbIssue implements Serializable {
    @Id
    private Integer issue_id;

    private String issue_title;

    private String issue_content;

    private Integer user_id;

    private static final long serialVersionUID = 1L;

    private List<TbArticle> tbArticles;

    @Override
    public String toString() {
        return "TbIssue{" +
                "issue_id=" + issue_id +
                ", issue_title='" + issue_title + '\'' +
                ", issue_content='" + issue_content + '\'' +
                ", user_id=" + user_id +
                ", tbArticles=" + tbArticles +
                '}';
    }

    public List<TbArticle> getTbArticles() {
        return tbArticles;
    }

    public void setTbArticles(List<TbArticle> tbArticles) {
        this.tbArticles = tbArticles;
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
     * @return issue_title
     */
    public String getIssue_title() {
        return issue_title;
    }

    /**
     * @param issue_title
     */
    public void setIssue_title(String issue_title) {
        this.issue_title = issue_title;
    }

    /**
     * @return issue_content
     */
    public String getIssue_content() {
        return issue_content;
    }

    /**
     * @param issue_content
     */
    public void setIssue_content(String issue_content) {
        this.issue_content = issue_content;
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

}