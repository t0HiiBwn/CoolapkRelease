package com.alibaba.baichuan.trade.common.adapter.ut.performance;

public class AlibcDimension {
    protected String a;
    protected String b;

    public AlibcDimension() {
        this.b = "null";
    }

    public AlibcDimension(String str) {
        this(str, null);
    }

    public AlibcDimension(String str, String str2) {
        this.b = "null";
        this.a = str;
        this.b = str2 == null ? "null" : str2;
    }

    public String getConstantValue() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    public void setConstantValue(String str) {
        this.b = str;
    }

    public void setName(String str) {
        this.a = str;
    }
}
