package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.support.api.client.Result;

public class OdidResult extends Result {
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
