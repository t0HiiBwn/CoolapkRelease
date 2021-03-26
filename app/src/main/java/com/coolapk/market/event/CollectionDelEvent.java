package com.coolapk.market.event;

public class CollectionDelEvent {
    private String colId;

    public CollectionDelEvent(String str) {
        this.colId = str;
    }

    public String getColId() {
        return this.colId;
    }
}
