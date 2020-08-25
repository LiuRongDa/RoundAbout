package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_article")
public class TbArticle implements Serializable {
    @Id
    private Integer article_id;

    private String article_title;

    private String article_content;

    private Integer user_id;

    private String article_photo;

    private Integer article_state;

    private static final long serialVersionUID = 1L;

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
     * @return article_title
     */
    public String getArticle_title() {
        return article_title;
    }

    /**
     * @param article_title
     */
    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    /**
     * @return article_content
     */
    public String getArticle_content() {
        return article_content;
    }

    /**
     * @param article_content
     */
    public void setArticle_content(String article_content) {
        this.article_content = article_content;
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
     * @return article_photo
     */
    public String getArticle_photo() {
        return article_photo;
    }

    /**
     * @param article_photo
     */
    public void setArticle_photo(String article_photo) {
        this.article_photo = article_photo;
    }

    /**
     * @return article_state
     */
    public Integer getArticle_state() {
        return article_state;
    }

    /**
     * @param article_state
     */
    public void setArticle_state(Integer article_state) {
        this.article_state = article_state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", article_id=").append(article_id);
        sb.append(", article_title=").append(article_title);
        sb.append(", article_content=").append(article_content);
        sb.append(", user_id=").append(user_id);
        sb.append(", article_photo=").append(article_photo);
        sb.append(", article_state=").append(article_state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}