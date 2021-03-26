package com.tencent.imsdk;

public class TIMOfflinePushToken {
    private long bussid;
    private String token;

    public TIMOfflinePushToken(long j, String str) {
        this.bussid = j;
        this.token = str;
    }

    public String getToken() {
        return this.token;
    }

    public TIMOfflinePushToken setToken(String str) {
        this.token = str;
        return this;
    }

    public long getBussid() {
        return this.bussid;
    }

    public TIMOfflinePushToken setBussid(long j) {
        this.bussid = j;
        return this;
    }
}
