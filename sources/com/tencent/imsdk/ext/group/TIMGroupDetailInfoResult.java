package com.tencent.imsdk.ext.group;

public class TIMGroupDetailInfoResult extends TIMGroupDetailInfo {
    private int resultCode = 0;
    private String resultInfo = "";

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }
}
