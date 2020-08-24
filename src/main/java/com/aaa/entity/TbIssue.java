package com.aaa.entity;

import javax.persistence.*;

@Table(name = "roundabout..tb_issue")
public class TbIssue {
    @Id
    @Column(name = "issue_id")
    private Integer issueId;

    @Column(name = "issue_title")
    private String issueTitle;

    @Column(name = "issue_content")
    private String issueContent;

    @Column(name = "user_id")
    private Integer userId;

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
     * @return issue_title
     */
    public String getIssueTitle() {
        return issueTitle;
    }

    /**
     * @param issueTitle
     */
    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    /**
     * @return issue_content
     */
    public String getIssueContent() {
        return issueContent;
    }

    /**
     * @param issueContent
     */
    public void setIssueContent(String issueContent) {
        this.issueContent = issueContent;
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