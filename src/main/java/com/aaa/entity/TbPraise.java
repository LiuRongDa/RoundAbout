package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_praise")
public class TbPraise implements Serializable {
    @Id
    private Integer praise_id;

    private Integer article_id;

    private Integer issue_id;

    private Integer comment_id;

    private Integer reply_id;

    private Integer user_id;

    private static final long serialVersionUID = 1L;

    /**
     * @return praise_id
     */
    public Integer getPraise_id() {
        return praise_id;
    }

    /**
     * @param praise_id
     */
    public void setPraise_id(Integer praise_id) {
        this.praise_id = praise_id;
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
        sb.append(", praise_id=").append(praise_id);
        sb.append(", article_id=").append(article_id);
        sb.append(", issue_id=").append(issue_id);
        sb.append(", comment_id=").append(comment_id);
        sb.append(", reply_id=").append(reply_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}