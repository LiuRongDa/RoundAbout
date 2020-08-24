package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "roundabout..tb_reply")
public class TbReply {
    @Id
    @Column(name = "reply_id")
    private Integer replyId;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "reply_idto")
    private Integer replyIdto;

    @Column(name = "reply_date")
    private Date replyDate;

    /**
     * @return reply_id
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * @param replyId
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    /**
     * @return reply_content
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * @param replyContent
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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
     * @return comment_id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * @return reply_idto
     */
    public Integer getReplyIdto() {
        return replyIdto;
    }

    /**
     * @param replyIdto
     */
    public void setReplyIdto(Integer replyIdto) {
        this.replyIdto = replyIdto;
    }

    /**
     * @return reply_date
     */
    public Date getReplyDate() {
        return replyDate;
    }

    /**
     * @param replyDate
     */
    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }
}