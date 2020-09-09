package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_issue_user")
public class TbIssueUser implements Serializable {
    private Integer issue_id;

    private Integer user_id;

    private TbIssue tbIssue;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "TbIssueUser{" +
                "issue_id=" + issue_id +
                ", user_id=" + user_id +
                ", tbIssue=" + tbIssue +
                '}';
    }

    public TbIssue getTbIssue() {
        return tbIssue;
    }

    public void setTbIssue(TbIssue tbIssue) {
        this.tbIssue = tbIssue;
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