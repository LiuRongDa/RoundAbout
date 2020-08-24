package com.aaa.entity;

import javax.persistence.*;

@Table(name = "tb_issue_gambit")
public class TbIssueGambit {
    @Column(name = "gambit_id")
    private Integer gambitId;

    @Column(name = "issue_id")
    private Integer issueId;

    /**
     * @return gambit_id
     */
    public Integer getGambitId() {
        return gambitId;
    }

    /**
     * @param gambitId
     */
    public void setGambitId(Integer gambitId) {
        this.gambitId = gambitId;
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
}