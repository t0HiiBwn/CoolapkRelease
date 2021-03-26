package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class SubscribeReq implements IMessageEntity {
    @Packed
    private String operation;
    @Packed
    private String packageName;
    @Packed
    private String token;
    @Packed
    private String topic;

    public SubscribeReq() {
    }

    public SubscribeReq(String str, String str2, String str3) {
        this.packageName = str;
        this.operation = str2;
        this.topic = str3;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "SubscribeReq{packageName='" + this.packageName + "', operation='" + this.operation + "'}";
    }
}
