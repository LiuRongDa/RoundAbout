package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "roundabout..tb_idea")
public class TbIdea {
    @Id
    @Column(name = "idea_id")
    private Integer ideaId;

    @Column(name = "idea_content")
    private String ideaContent;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "idea_date")
    private Date ideaDate;

    /**
     * @return idea_id
     */
    public Integer getIdeaId() {
        return ideaId;
    }

    /**
     * @param ideaId
     */
    public void setIdeaId(Integer ideaId) {
        this.ideaId = ideaId;
    }

    /**
     * @return idea_content
     */
    public String getIdeaContent() {
        return ideaContent;
    }

    /**
     * @param ideaContent
     */
    public void setIdeaContent(String ideaContent) {
        this.ideaContent = ideaContent;
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
     * @return idea_date
     */
    public Date getIdeaDate() {
        return ideaDate;
    }

    /**
     * @param ideaDate
     */
    public void setIdeaDate(Date ideaDate) {
        this.ideaDate = ideaDate;
    }
}