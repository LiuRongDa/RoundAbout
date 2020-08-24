package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_article")
public class TbArticle {
    @Id
    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "article_title")
    private String articleTitle;

    @Column(name = "article_content")
    private String articleContent;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "article_photo")
    private String articlePhoto;

    @Column(name = "article_state")
    private Integer articleState;

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
     * @return article_title
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * @param articleTitle
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * @return article_content
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * @param articleContent
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return article_photo
     */
    public String getArticlePhoto() {
        return articlePhoto;
    }

    /**
     * @param articlePhoto
     */
    public void setArticlePhoto(String articlePhoto) {
        this.articlePhoto = articlePhoto;
    }

    /**
     * @return article_state
     */
    public Integer getArticleState() {
        return articleState;
    }

    /**
     * @param articleState
     */
    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }
}