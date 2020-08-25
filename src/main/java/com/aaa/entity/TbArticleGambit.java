package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_article_gambit")
public class TbArticleGambit implements Serializable {
    private Integer article_id;

    private Integer gambit_id;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", article_id=").append(article_id);
        sb.append(", gambit_id=").append(gambit_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}