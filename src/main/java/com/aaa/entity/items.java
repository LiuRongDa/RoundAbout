package com.aaa.entity;

import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/27 21:54
 */
public class items {
    private String icon;
    private String index;
    private String title;
    private List<items> subs;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<items> getSubs() {
        return subs;
    }

    public void setSubs(List<items> subs) {
        this.subs = subs;
    }

    @Override
    public String toString() {
        return "items{" +
                "icon='" + icon + '\'' +
                ", index='" + index + '\'' +
                ", title='" + title + '\'' +
                ", subs=" + subs +
                '}';
    }
}
