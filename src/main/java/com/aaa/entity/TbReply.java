package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_reply")
public class TbReply implements Serializable {
    @Id
    private Integer reply_id;

    private String reply_content;

    private Integer user_id;

    private Integer comment_id;

    private Integer reply_idto;

    private Date reply_date;

    private static final long serialVersionUID = 1L;

    /**
     * @return reply_id
     */
    public Integer getReply_id() {
        return reply_id;
    }

    /**
     * @param reply_id
     */
    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    /**
     * @return reply_content
     */
    public String getReply_content() {
        return reply_content;
    }

    /**
     * @param reply_content
     */
    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
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
     * @return comment_id
     */
    public Integer getComment_id() {
        return comment_id;
    }

    /**
     * @param comment_id
     */
    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    /**
     * @return reply_idto
     */
    public Integer getReply_idto() {
        return reply_idto;
    }

    /**
     * @param reply_idto
     */
    public void setReply_idto(Integer reply_idto) {
        this.reply_idto = reply_idto;
    }

    /**
     * @return reply_date
     */
    public Date getReply_date() {
        return reply_date;
    }

    /**
     * @param reply_date
     */
    public void setReply_date(Date reply_date) {
        this.reply_date = reply_date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reply_id=").append(reply_id);
        sb.append(", reply_content=").append(reply_content);
        sb.append(", user_id=").append(user_id);
        sb.append(", comment_id=").append(comment_id);
        sb.append(", reply_idto=").append(reply_idto);
        sb.append(", reply_date=").append(reply_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}