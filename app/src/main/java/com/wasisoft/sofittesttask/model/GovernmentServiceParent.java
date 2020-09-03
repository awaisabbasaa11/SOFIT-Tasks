package com.wasisoft.sofittesttask.model;

import java.util.List;

public class GovernmentServiceParent {
    private List<GovernmentServiceChild> singleServiceChildList;

    public List<GovernmentServiceChild> getSingleServiceChildList() {
        return singleServiceChildList;
    }

    public void setSingleServiceChildList(List<GovernmentServiceChild> singleServiceChildList) {
        this.singleServiceChildList = singleServiceChildList;
    }

    public GovernmentServiceParent(List<GovernmentServiceChild> singleServiceChildList) {
        this.singleServiceChildList = singleServiceChildList;
    }
}
