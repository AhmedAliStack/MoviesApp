package com.ahmedraafat.moviestask.model;

public class CateModel {
    public String title;
    public boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public CateModel(String title) {
        this.title = title;
    }

    public CateModel(String title, boolean expanded) {
        this.title = title;
        this.expanded = expanded;
    }
}
