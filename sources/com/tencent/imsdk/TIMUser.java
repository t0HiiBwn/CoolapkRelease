package com.tencent.imsdk;

public class TIMUser {
    private String appIdAt3rd = "";
    private String identifier = "";
    private long sdkAppid = 0;
    private long tinyId = 0;

    public TIMUser() {
    }

    public TIMUser(TIMUser tIMUser) {
        this.sdkAppid = tIMUser.sdkAppid;
        this.appIdAt3rd = tIMUser.appIdAt3rd;
        this.identifier = tIMUser.identifier;
        this.tinyId = tIMUser.tinyId;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TIMUser)) {
            return false;
        }
        return toString().equals(((TIMUser) obj).toString());
    }

    public String toString() {
        return this.sdkAppid + ":" + this.identifier + ":" + this.appIdAt3rd;
    }

    public void parseFromString(String str) {
        if (str != null) {
            String[] split = str.split(":");
            this.sdkAppid = (long) Integer.parseInt(split[0]);
            this.identifier = split[1];
            this.appIdAt3rd = split[2];
        }
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public void setTinyId(long j) {
        this.tinyId = j;
    }

    @Deprecated
    public String getAppIdAt3rd() {
        return this.appIdAt3rd;
    }

    @Deprecated
    public void setAppIdAt3rd(String str) {
        this.appIdAt3rd = str;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public long getSdkAppid() {
        return this.sdkAppid;
    }

    public void setSdkAppid(long j) {
        this.sdkAppid = j;
    }
}
