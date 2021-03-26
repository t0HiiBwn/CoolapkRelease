package com.huawei.hms.push;

public class BaseException extends Exception {
    private final int a;
    private final a b;

    public BaseException(int i) {
        a a2 = a.a(i);
        this.b = a2;
        this.a = a2.b();
    }

    public int getErrorCode() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b.c();
    }
}
