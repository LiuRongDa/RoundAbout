package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_idea")
public class TbIdea implements Serializable {
    @Id
    private Integer idea_id;

    private String idea_content;

    private Integer user_id;

    private Date idea_date;

    private TbUser tbUser;

    private static final long serialVersionUID = 1L;

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    /**
     * @return idea_id
     */
    public Integer getIdea_id() {
        return idea_id;
    }

    /**
     * @param idea_id
     */
    public void setIdea_id(Integer idea_id) {
        this.idea_id = idea_id;
    }

    /**
     * @return idea_content
     */
    public String getIdea_content() {
        return idea_content;
    }

    /**
     * @param idea_content
     */
    public void setIdea_content(String idea_content) {
        this.idea_content = idea_content;
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

    /**
     * @return idea_date
     */
    public Date getIdea_date() {
        return idea_date;
    }

    /**
     * @param idea_date
     */
    public void setIdea_date(Date idea_date) {
        this.idea_date = idea_date;
    }

    @Override
    public String toString() {
        return "TbIdea{" +
                "idea_id=" + idea_id +
                ", idea_content='" + idea_content + '\'' +
                ", user_id=" + user_id +
                ", idea_date=" + idea_date +
                ", tbUser=" + tbUser +
                '}';
    }
}