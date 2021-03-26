package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMGroupAtInfo;
import java.io.Serializable;

public class V2TIMGroupAtInfo implements Serializable {
    public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
    public static final int TIM_AT_ALL = 2;
    public static final int TIM_AT_ALL_AT_ME = 3;
    public static final int TIM_AT_ME = 1;
    public static final int TIM_AT_UNKNOWN = 0;
    private TIMGroupAtInfo timGroupAtInfo;

    public long getSeq() {
        TIMGroupAtInfo tIMGroupAtInfo = this.timGroupAtInfo;
        if (tIMGroupAtInfo == null) {
            return -1;
        }
        return tIMGroupAtInfo.getSeq();
    }

    public int getAtType() {
        TIMGroupAtInfo tIMGroupAtInfo = this.timGroupAtInfo;
        if (tIMGroupAtInfo == null) {
            return 0;
        }
        return tIMGroupAtInfo.getAtType();
    }

    protected void setTimGroupAtInfo(TIMGroupAtInfo tIMGroupAtInfo) {
        this.timGroupAtInfo = tIMGroupAtInfo;
    }
}
