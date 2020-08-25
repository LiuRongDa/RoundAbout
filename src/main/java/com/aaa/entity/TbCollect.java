package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_collect")
public class TbCollect implements Serializable {
    @Id
    private Integer collect_id;

    private String collect_title;

    private String collect_describe;

    private Integer collect_state;

    private Integer user_id;

    private static final long serialVersionUID = 1L;

    /**
     * @return collect_id
     */
    public Integer getCollect_id() {
        return collect_id;
    }

    /**
     * @param collect_id
     */
    public void setCollect_id(Integer collect_id) {
        this.collect_id = collect_id;
    }

    /**
     * @return collect_title
     */
    public String getCollect_title() {
        return collect_title;
    }

    /**
     * @param collect_title
     */
    public void setCollect_title(String collect_title) {
        this.collect_title = collect_title;
    }

    /**
     * @return collect_describe
     */
    public String getCollect_describe() {
        return collect_describe;
    }

    /**
     * @param collect_describe
     */
    public void setCollect_describe(String collect_describe) {
        this.collect_describe = collect_describe;
    }

    /**
     * @return collect_state
     */
    public Integer getCollect_state() {
        return collect_state;
    }

    /**
     * @param collect_state
     */
    public void setCollect_state(Integer collect_state) {
        this.collect_state = collect_state;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collect_id=").append(collect_id);
        sb.append(", collect_title=").append(collect_title);
        sb.append(", collect_describe=").append(collect_describe);
        sb.append(", collect_state=").append(collect_state);
        sb.append(", user_id=").append(user_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}