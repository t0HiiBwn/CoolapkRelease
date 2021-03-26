package com.tencent.imsdk.ext.group;

public enum TIMGroupPendencyGetType {
    APPLY_BY_SELF(0),
    INVITED_BY_OTHER(1),
    BOTH_SELFAPPLY_AND_INVITED(2);
    
    private int value = 0;

    private TIMGroupPendencyGetType(int i) {
        this.value = i;
    }

    public long getValue() {
        return (long) this.value;
    }
}
