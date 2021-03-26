package com.tencent.imsdk.ext.group;

public enum TIMGroupPendencyOperationType {
    REFUSE(0),
    ACCEPT(1);
    
    private int value = 1;

    private TIMGroupPendencyOperationType(int i) {
        this.value = i;
    }

    public long getValue() {
        return (long) this.value;
    }
}
