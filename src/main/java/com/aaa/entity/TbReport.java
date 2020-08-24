package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_report")
public class TbReport {
    @Id
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "report_data")
    private Date reportData;

    @Column(name = "report_content")
    private String reportContent;

    @Column(name = "issue_id")
    private Integer issueId;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "reply_id")
    private Integer replyId;

    /**
     * @return report_id
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * @param reportId
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
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
     * @return report_data
     */
    public Date getReportData() {
        return reportData;
    }

    /**
     * @param reportData
     */
    public void setReportData(Date reportData) {
        this.reportData = reportData;
    }

    /**
     * @return report_content
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * @param reportContent
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
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
}