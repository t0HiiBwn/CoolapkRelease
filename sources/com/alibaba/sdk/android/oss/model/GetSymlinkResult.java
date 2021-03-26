package com.alibaba.sdk.android.oss.model;

public class GetSymlinkResult extends OSSResult {
    private String targetObjectName;

    public String getTargetObjectName() {
        return this.targetObjectName;
    }

    public void setTargetObjectName(String str) {
        this.targetObjectName = str;
    }
}
