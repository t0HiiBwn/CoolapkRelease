package com.tencent.imsdk.v2;

import com.tencent.imsdk.ext.group.TIMGroupDetailInfoResult;

public class V2TIMGroupInfoResult {
    private TIMGroupDetailInfoResult timGroupDetailInfoResult;
    private V2TIMGroupInfo v2TIMGroupInfo;

    void setTimGroupDetailInfoResult(TIMGroupDetailInfoResult tIMGroupDetailInfoResult) {
        this.timGroupDetailInfoResult = tIMGroupDetailInfoResult;
        V2TIMGroupInfo v2TIMGroupInfo2 = new V2TIMGroupInfo();
        this.v2TIMGroupInfo = v2TIMGroupInfo2;
        v2TIMGroupInfo2.setTIMGroupDetailInfo(tIMGroupDetailInfoResult);
    }

    public int getResultCode() {
        TIMGroupDetailInfoResult tIMGroupDetailInfoResult = this.timGroupDetailInfoResult;
        if (tIMGroupDetailInfoResult != null) {
            return tIMGroupDetailInfoResult.getResultCode();
        }
        return 6017;
    }

    public String getResultMessage() {
        TIMGroupDetailInfoResult tIMGroupDetailInfoResult = this.timGroupDetailInfoResult;
        return tIMGroupDetailInfoResult != null ? tIMGroupDetailInfoResult.getResultInfo() : "";
    }

    public V2TIMGroupInfo getGroupInfo() {
        return this.v2TIMGroupInfo;
    }
}
