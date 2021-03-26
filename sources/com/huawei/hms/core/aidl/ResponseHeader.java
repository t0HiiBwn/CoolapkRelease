package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;

public class ResponseHeader implements IMessageEntity {
    @Packed
    protected int statusCode;

    public ResponseHeader() {
    }

    public ResponseHeader(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
