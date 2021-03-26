package com.huawei.hms.push.ups.entity;

public class CodeResult {
    private int a;
    private String b;

    public CodeResult() {
    }

    public CodeResult(int i) {
        this.a = i;
    }

    public CodeResult(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int getReturnCode() {
        return this.a;
    }

    public void setReturnCode(int i) {
        this.a = i;
    }

    public String getReason() {
        return this.b;
    }

    public void setReason(String str) {
        this.b = str;
    }
}
