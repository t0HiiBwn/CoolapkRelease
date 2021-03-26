package com.tencent.beacon.upload;

public class TunnelInfo {
    public String appKey;
    public String channel;
    public String version;

    public TunnelInfo(String str, String str2, String str3) {
        this.appKey = str;
        this.version = str2;
        this.channel = str3;
    }

    public TunnelInfo(String str) {
        this.appKey = str;
    }
}
