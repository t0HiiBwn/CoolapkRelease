package com.tencent.imsdk;

public class TIMGroupTipsElemMemberInfo {
    private String identifier;
    private long shutupTime;

    public String getIdentifier() {
        return this.identifier;
    }

    void setIdentifier(String str) {
        this.identifier = str;
    }

    public long getShutupTime() {
        return this.shutupTime;
    }

    void setShutupTime(long j) {
        this.shutupTime = j;
    }
}
