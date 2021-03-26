package com.kepler.jd.sdk.exception;

public class KeplerNoThisCategoryException extends Exception {
    private static final long serialVersionUID = 1;

    public KeplerNoThisCategoryException() {
    }

    public KeplerNoThisCategoryException(String str, Throwable th) {
        super(str, th);
    }

    public KeplerNoThisCategoryException(String str) {
        super(str);
    }

    public KeplerNoThisCategoryException(Throwable th) {
        super(th);
    }
}
