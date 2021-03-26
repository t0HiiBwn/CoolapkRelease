package com.coolapk.market.event;

public class PageChangeEvent {
    private int index;

    public PageChangeEvent(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }
}
