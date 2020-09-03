package com.wasisoft.sofittesttask.model;

public class PaymentHistory {
    private int desc;
    private String image;

    public PaymentHistory(int desc, String image) {
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
