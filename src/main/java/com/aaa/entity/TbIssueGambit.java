package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_issue_gambit")
public class TbIssueGambit implements Serializable {
    private Integer gambit_id;

    private Integer issue_id;

    private TbIssue tbIssue;

    @Override
    public String toString() {
        return "TbIssueGambit{" +
                "gambit_id=" + gambit_id +
                ", issue_id=" + issue_id +
                ", tbIssue=" + tbIssue +
                '}';
    }

    public TbIssue getTbIssue() {
        return tbIssue;
    }

    public void setTbIssue(TbIssue tbIssue) {
        this.tbIssue = tbIssue;
    }

    private static final long serialVersionUID = 1L;

    /**
     * @return gambit_id
     */
    public Integer getGambit_id() {
        return gambit_id;
    }

    /**
     * @param gambit_id
     */
    public void setGambit_id(Integer gambit_id) {
        this.gambit_id = gambit_id;
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

}