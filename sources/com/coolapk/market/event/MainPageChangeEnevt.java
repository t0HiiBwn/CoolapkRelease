package com.coolapk.market.event;

public class MainPageChangeEnevt {
    private int childIndex;
    private int index;

    public MainPageChangeEnevt(int i, int i2) {
        this.index = i;
        this.childIndex = i2;
    }

    public int getIndex() {
        return this.index;
    }

    public int getChildIndex() {
        return this.childIndex;
    }
}
