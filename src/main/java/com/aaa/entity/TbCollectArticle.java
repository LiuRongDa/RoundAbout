package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_collect_article")
public class TbCollectArticle implements Serializable {
    private Integer collect_id;

    private Integer article_id;

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
        sb.append(", collect_id=").append(collect_id);
        sb.append(", article_id=").append(article_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}