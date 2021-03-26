package com.bytedance.sdk.openadsdk.playable;

/* compiled from: NetType */
public enum b {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_UNKNOWN("mobile");
    
    private String g;

    private b(String str) {
        this.g = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.g;
    }
}
