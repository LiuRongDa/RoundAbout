package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_issue_gambit")
public class TbIssueGambit implements Serializable {
    private Integer gambit_id;

    private Integer issue_id;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gambit_id=").append(gambit_id);
        sb.append(", issue_id=").append(issue_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}