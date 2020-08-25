package com.aaa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_attention")
public class TbAttention implements Serializable {
    @Id
    private Integer attention_id;

    private Integer user_id;

    private Integer user_idl;

    private static final long serialVersionUID = 1L;

    /**
     * @return attention_id
     */
    public Integer getAttention_id() {
        return attention_id;
    }

    /**
     * @param attention_id
     */
    public void setAttention_id(Integer attention_id) {
        this.attention_id = attention_id;
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
     * @return user_idl
     */
    public Integer getUser_idl() {
        return user_idl;
    }

    /**
     * @param user_idl
     */
    public void setUser_idl(Integer user_idl) {
        this.user_idl = user_idl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attention_id=").append(attention_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", user_idl=").append(user_idl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}