package com.aaa.entity;

import javax.persistence.*;

@Table(name = "roundabout..tb_praise")
public class TbPraise {
    @Id
    @Column(name = "praise_id")
    private Integer praiseId;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "issue_id")
    private Integer issueId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "reply_id")
    private Integer replyId;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return praise_id
     */
    public Integer getPraiseId() {
        return praiseId;
    }

    /**
     * @param praiseId
     */
    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
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
     * @return comment_id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * @return reply_id
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * @param replyId
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
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
}