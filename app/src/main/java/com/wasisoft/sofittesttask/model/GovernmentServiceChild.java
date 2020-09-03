package com.wasisoft.sofittesttask.model;

public class GovernmentServiceChild {
    private int title;
    private String image;

    public GovernmentServiceChild(int title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }
}
