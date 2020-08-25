package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_profession")
public class TbProfession implements Serializable {
    @Id
    private Integer profession_id;

    private String profession_company;

    private String profession_position;

    private Integer user_id;

    private Date profession_start;

    private Date profession_end;

    private static final long serialVersionUID = 1L;

    /**
     * @return profession_id
     */
    public Integer getProfession_id() {
        return profession_id;
    }

    /**
     * @param profession_id
     */
    public void setProfession_id(Integer profession_id) {
        this.profession_id = profession_id;
    }

    /**
     * @return profession_company
     */
    public String getProfession_company() {
        return profession_company;
    }

    /**
     * @param profession_company
     */
    public void setProfession_company(String profession_company) {
        this.profession_company = profession_company;
    }

    /**
     * @return profession_position
     */
    public String getProfession_position() {
        return profession_position;
    }

    /**
     * @param profession_position
     */
    public void setProfession_position(String profession_position) {
        this.profession_position = profession_position;
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
     * @return profession_start
     */
    public Date getProfession_start() {
        return profession_start;
    }

    /**
     * @param profession_start
     */
    public void setProfession_start(Date profession_start) {
        this.profession_start = profession_start;
    }

    /**
     * @return profession_end
     */
    public Date getProfession_end() {
        return profession_end;
    }

    /**
     * @param profession_end
     */
    public void setProfession_end(Date profession_end) {
        this.profession_end = profession_end;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", profession_id=").append(profession_id);
        sb.append(", profession_company=").append(profession_company);
        sb.append(", profession_position=").append(profession_position);
        sb.append(", user_id=").append(user_id);
        sb.append(", profession_start=").append(profession_start);
        sb.append(", profession_end=").append(profession_end);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}