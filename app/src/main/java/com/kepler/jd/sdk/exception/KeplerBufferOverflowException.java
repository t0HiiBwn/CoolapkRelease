package com.kepler.jd.sdk.exception;

public class KeplerBufferOverflowException extends Exception {
    private static final long serialVersionUID = 1;

    public KeplerBufferOverflowException() {
    }

    public KeplerBufferOverflowException(String str, Throwable th) {
        super(str, th);
    }

    public KeplerBufferOverflowException(String str) {
        super(str);
    }

    public KeplerBufferOverflowException(Throwable th) {
        super(th);
    }
}
