package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class DeleteTokenReq implements IMessageEntity {
    @Packed
    private String appId;
    @Packed
    private String pkgName;
    @Packed
    private String scope;
    @Packed
    private String token;

    public String getPkgName() {
        return this.pkgName;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public String toString() {
        return getClass().getName() + "{ pkgName: " + this.pkgName + " scope: " + this.scope + " appId: " + this.appId + "}";
    }
}
