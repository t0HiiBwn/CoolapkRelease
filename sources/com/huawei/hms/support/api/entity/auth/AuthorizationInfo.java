package com.huawei.hms.support.api.entity.auth;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

public class AuthorizationInfo implements IMessageEntity {
    @Packed
    private String accessToken;
    @Packed
    private String appID;
    @Packed
    private String clientID;
    @Packed
    private String clientSecret;
    @Packed
    private long expiredTime;
    @Packed
    private String openID;
    @Packed
    private String refreshToken;
    @Packed
    private List<String> scopeList;

    public boolean isValid() {
        return TextUtils.isEmpty(this.appID);
    }

    public boolean isTokenExpire() {
        return System.currentTimeMillis() > this.expiredTime;
    }

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public String getClientID() {
        return this.clientID;
    }

    public void setClientID(String str) {
        this.clientID = str;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public void setClientSecret(String str) {
        this.clientSecret = str;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public void setExpiredTime(long j) {
        this.expiredTime = j;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public List<String> getScopeList() {
        return this.scopeList;
    }

    public void setScopeList(List<String> list) {
        this.scopeList = list;
    }

    public String getOpenId() {
        return this.openID;
    }

    public void setOpenID(String str) {
        this.openID = str;
    }

    public String toString() {
        return "appID:" + this.appID + ", expiredTime:" + this.expiredTime;
    }
}
