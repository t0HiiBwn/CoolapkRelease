package com.qq.e.ads;

public enum ContentAdType {
    AD,
    INFORMATION;

    public static ContentAdType fromString(String str) {
        if ("ad".equals(str)) {
            return AD;
        }
        if ("information".equals(str)) {
            return INFORMATION;
        }
        return null;
    }
}
