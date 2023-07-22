package com.example.roadresolver;

public class Road {
    String title;
    String desc;

    public Road(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public Road() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
