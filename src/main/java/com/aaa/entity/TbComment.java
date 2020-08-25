package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_comment")
public class TbComment implements Serializable {
    @Id
    private Integer comment_id;

    private String comment_content;

    private Integer user_id;

    private Date comment_date;

    private Integer article_id;

    private static final long serialVersionUID = 1L;

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
     * @return comment_content
     */
    public String getComment_content() {
        return comment_content;
    }

    /**
     * @param comment_content
     */
    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
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
     * @return comment_date
     */
    public Date getComment_date() {
        return comment_date;
    }

    /**
     * @param comment_date
     */
    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    /**
     * @return article_id
     */
    public Integer getArticle_id() {
        return article_id;
    }

    /**
     * @param article_id
     */
    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", comment_id=").append(comment_id);
        sb.append(", comment_content=").append(comment_content);
        sb.append(", user_id=").append(user_id);
        sb.append(", comment_date=").append(comment_date);
        sb.append(", article_id=").append(article_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}