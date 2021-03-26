package com.alibaba.sdk.android.oss.model;

import java.util.Map;

public class OSSResult {
    private Long clientCRC;
    private String requestId;
    private Map<String, String> responseHeader;
    private Long serverCRC;
    private int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public Map<String, String> getResponseHeader() {
        return this.responseHeader;
    }

    public void setResponseHeader(Map<String, String> map) {
        this.responseHeader = map;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public Long getClientCRC() {
        return this.clientCRC;
    }

    public void setClientCRC(Long l2) {
        if (l2 != null && l2.longValue() != 0) {
            this.clientCRC = l2;
        }
    }

    public Long getServerCRC() {
        return this.serverCRC;
    }

    public void setServerCRC(Long l2) {
        if (l2 != null && l2.longValue() != 0) {
            this.serverCRC = l2;
        }
    }

    public String toString() {
        return String.format("OSSResult<%s>: \nstatusCode:%d,\nresponseHeader:%s,\nrequestId:%s", super.toString(), Integer.valueOf(this.statusCode), this.responseHeader.toString(), this.requestId);
    }
}
