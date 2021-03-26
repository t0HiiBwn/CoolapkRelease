package com.coolapk.market.event;

import com.coolapk.market.model.DyhModel;

public class DyhHandleEvent {
    private DyhModel dyhModel;
    private String id;

    public DyhHandleEvent(String str) {
        this.id = str;
    }

    public DyhHandleEvent(DyhModel dyhModel2) {
        this.dyhModel = dyhModel2;
    }

    public String getId() {
        return this.id;
    }

    public DyhModel getDyhModel() {
        return this.dyhModel;
    }
}
