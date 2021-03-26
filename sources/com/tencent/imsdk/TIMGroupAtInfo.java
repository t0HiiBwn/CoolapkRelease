package com.tencent.imsdk;

import java.io.Serializable;

public class TIMGroupAtInfo implements Serializable {
    public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
    public static final int TIM_AT_ALL = 2;
    public static final int TIM_AT_ALL_AT_ME = 3;
    public static final int TIM_AT_ME = 1;
    public static final int TIM_AT_UNKNOWN = 0;
    private int atType;
    private long seq;

    public long getSeq() {
        return this.seq;
    }

    public void setSeq(long j) {
        this.seq = j;
    }

    public int getAtType() {
        int i = this.atType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    public void setAtType(int i) {
        this.atType = i;
    }
}
