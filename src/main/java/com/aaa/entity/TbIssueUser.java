package com.aaa.entity;

import javax.persistence.*;

@Table(name = "roundabout..tb_issue_user")
public class TbIssueUser {
    @Column(name = "issue_id")
    private Integer issueId;

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