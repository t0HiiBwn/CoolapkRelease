package com.tencent.tpns.reflecttools;

public class ReflectException extends RuntimeException {
    private static final long serialVersionUID = -6213149635297151442L;

    public ReflectException() {
    }

    public ReflectException(String str) {
        super(str);
    }

    public ReflectException(String str, Throwable th) {
        super(str, th);
    }

    public ReflectException(Throwable th) {
        super(th);
    }
}
