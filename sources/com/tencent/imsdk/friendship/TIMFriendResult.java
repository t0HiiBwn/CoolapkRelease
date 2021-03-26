package com.tencent.imsdk.friendship;

public class TIMFriendResult {
    private String identifier = "";
    private int resultCode;
    private String resultInfo = "";

    public String getIdentifier() {
        return this.identifier;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" TIMFriendResult::::::::identifier=");
        stringBuffer.append(this.identifier);
        stringBuffer.append(";resultCode=");
        stringBuffer.append(this.resultCode);
        stringBuffer.append(";resultInfo=");
        stringBuffer.append(this.resultInfo);
        return stringBuffer.toString();
    }
}
