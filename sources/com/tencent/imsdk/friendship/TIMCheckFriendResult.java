package com.tencent.imsdk.friendship;

public class TIMCheckFriendResult {
    private String identifier = "";
    private int resultCode;
    private String resultInfo = "";
    private int resultType;

    public String getIdentifier() {
        return this.identifier;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }

    public int getResultType() {
        return this.resultType;
    }
}
