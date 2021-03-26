package com.tencent.imsdk;

public enum TIMConversationType {
    Invalid(0),
    C2C(1),
    Group(2),
    System(3);
    
    private int type = 0;

    private TIMConversationType(int i) {
        this.type = i;
    }

    public int value() {
        return this.type;
    }
}
