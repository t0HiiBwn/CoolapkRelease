package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenResp implements IMessageEntity {
    @Packed
    private String belongId;
    @Packed
    private int retCode = 0;
    @Packed
    private String token = "";
    @Packed
    private String tokenSin;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public void setRetCode(int i) {
        this.retCode = i;
    }

    public String getBelongId() {
        return this.belongId;
    }

    public void setBelongId(String str) {
        this.belongId = str;
    }

    public String getTokenSin() {
        return this.tokenSin;
    }

    public void setTokenSin(String str) {
        this.tokenSin = str;
    }
}
