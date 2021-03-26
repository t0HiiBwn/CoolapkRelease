package com.tencent.imsdk.ext.group;

public class TIMGroupMemberResult {
    private long result;
    private String user;

    public long getResult() {
        return this.result;
    }

    void setResult(long j) {
        this.result = j;
    }

    public String getUser() {
        return this.user;
    }

    void setUser(String str) {
        this.user = str;
    }

    public String toString() {
        return "TIMGroupMemberResult::user=" + this.user + ",result=" + this.result;
    }
}
