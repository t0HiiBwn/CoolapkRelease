package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

public class RequestHeader implements IMessageEntity {
    @Packed
    private int apiLevel;
    @Packed
    private List<String> apiNameList;
    @Packed
    private String appId;
    @Packed
    private String packageName;
    @Packed
    private int sdkVersion;
    @Packed
    private String sessionId;

    public RequestHeader() {
    }

    public RequestHeader(String str, String str2, int i, String str3) {
        this.appId = str;
        this.packageName = str2;
        this.sdkVersion = i;
        this.sessionId = str3;
    }

    public String getAppID() {
        return this.appId;
    }

    public void setAppID(String str) {
        this.appId = str;
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(int i) {
        this.sdkVersion = i;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public List<String> getApiNameList() {
        return this.apiNameList;
    }

    public void setApiNameList(List<String> list) {
        this.apiNameList = list;
    }
}
