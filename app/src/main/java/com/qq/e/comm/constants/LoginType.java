package com.qq.e.comm.constants;

public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);
    
    private int a;

    private LoginType(int i) {
        this.a = i;
        ordinal();
    }

    public final int getValue() {
        return this.a;
    }
}
