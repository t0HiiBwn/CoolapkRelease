package com.qq.e.comm.managers.status;

public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    
    private int a;
    private int b;
    private String c;

    private NetworkType(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public final int getConnValue() {
        return this.a;
    }

    public final String getNameValue() {
        return this.c;
    }

    public final int getPermValue() {
        return this.b;
    }
}
