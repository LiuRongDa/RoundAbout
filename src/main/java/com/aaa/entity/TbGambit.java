package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_gambit")
public class TbGambit implements Serializable {
    @Id
    private Integer gambit_id;

    private String gambit_name;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gambit_id=").append(gambit_id);
        sb.append(", gambit_name=").append(gambit_name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}