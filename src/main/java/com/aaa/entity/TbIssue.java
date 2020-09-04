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

    private String issue_date;;

    private Integer issue_count;

    private Integer count;

    /*private TbIssueUser tbIssueUser;*/

    private static final long serialVersionUID = 1L;

    private TbUser tbUser;
/*
    public TbIssueUser getTbIssueUser() {
        return tbIssueUser;
    }

    public void setTbIssueUser(TbIssueUser tbIssueUser) {
        this.tbIssueUser = tbIssueUser;
    }*/

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public Integer getIssue_count() {
        return issue_count;
    }

    public void setIssue_count(Integer issue_count) {
        this.issue_count = issue_count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
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

    @Override
    public String toString() {
        return "TbIssue{" +
                "issue_id=" + issue_id +
                ", issue_title='" + issue_title + '\'' +
                ", issue_content='" + issue_content + '\'' +
                ", user_id=" + user_id +
                ", issue_date='" + issue_date + '\'' +
                ", issue_count=" + issue_count +
                ", count=" + count +
                ", tbUser=" + tbUser +
                '}';
    }
}