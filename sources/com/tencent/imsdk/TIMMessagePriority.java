package com.tencent.imsdk;

public enum TIMMessagePriority {
    High(1),
    Normal(2),
    Low(3),
    Lowest(4);
    
    private int opt;

    private TIMMessagePriority(int i) {
        this.opt = i;
    }

    int getValue() {
        return this.opt;
    }
}
