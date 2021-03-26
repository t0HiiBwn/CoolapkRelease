package com.alibaba.sdk.android.oss.exception;

import java.io.IOException;

public class InconsistentException extends IOException {
    private Long clientChecksum;
    private String requestId;
    private Long serverChecksum;

    public InconsistentException(Long l2, Long l3, String str) {
        this.clientChecksum = l2;
        this.serverChecksum = l3;
        this.requestId = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "InconsistentException: inconsistent object\n[RequestId]: " + this.requestId + "\n[ClientChecksum]: " + this.clientChecksum + "\n[ServerChecksum]: " + this.serverChecksum;
    }
}
