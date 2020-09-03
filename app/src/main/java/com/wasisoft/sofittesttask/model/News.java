package com.wasisoft.sofittesttask.model;

public class News {
    private int desc;
    private String image;

    public News(int desc, String image) {
        this.desc = desc;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}
