package com.ali.auth.third.core.model;

public enum SNSPlatform {
    PLATFORM_ALIPAY3("Alipay3");
    
    private String platform;

    private SNSPlatform(String str) {
        this.platform = str;
    }

    public String getPlatform() {
        return this.platform;
    }
}
