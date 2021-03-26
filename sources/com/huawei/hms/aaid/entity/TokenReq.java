package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenReq implements IMessageEntity {
    @Packed
    private String aaid;
    @Packed
    private String appId;
    @Packed
    private boolean firstTime;
    @Packed
    private String packageName;
    @Packed
    private String scope;

    public boolean isFirstTime() {
        return this.firstTime;
    }

    public void setFirstTime(boolean z) {
        this.firstTime = z;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getAaid() {
        return this.aaid;
    }

    public void setAaid(String str) {
        this.aaid = str;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public String toString() {
        return getClass().getName() + "{ pkgName: " + this.packageName + " isFirstTime: " + this.firstTime + " scope: " + this.scope + " appId: " + this.appId + "}";
    }
}
