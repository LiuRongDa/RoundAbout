package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_issue_article")
public class TbIssueArticle {
    @Column(name = "issue_id")
    private Integer issueId;

    @Column(name = "article_id")
    private Integer articleId;

    /**
     * @return issue_id
     */
    public Integer getIssueId() {
        return issueId;
    }

    /**
     * @param issueId
     */
    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
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