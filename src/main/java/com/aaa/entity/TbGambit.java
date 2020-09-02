package com.aaa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_gambit")
public class TbGambit implements Serializable {
    @Id
    private Integer gambit_id;

    private String gambit_name;

    private List<TbArticleGambit> tbArticleGambit;

    private List<TbArticle> tbArticle;

    private static final long serialVersionUID = 1L;

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

    /**
     * @return gambit_name
     */
    public String getGambit_name() {
        return gambit_name;
    }

    /**
     * @param gambit_name
     */
    public void setGambit_name(String gambit_name) {
        this.gambit_name = gambit_name;
    }

    public List<TbArticleGambit> getTbArticleGambit() {
        return tbArticleGambit;
    }

    public void setTbArticleGambit(List<TbArticleGambit> tbArticleGambit) {
        this.tbArticleGambit = tbArticleGambit;
    }

    public List<TbArticle> getTbArticle() {
        return tbArticle;
    }

    public void setTbArticle(List<TbArticle> tbArticle) {
        this.tbArticle = tbArticle;
    }

    @Override
    public String toString() {
        return "TbGambit{" +
                "gambit_id=" + gambit_id +
                ", gambit_name='" + gambit_name + '\'' +
                ", tbArticleGambit=" + tbArticleGambit +
                ", tbArticle=" + tbArticle +
                '}';
    }
}