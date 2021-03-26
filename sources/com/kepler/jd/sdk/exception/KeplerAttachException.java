package com.kepler.jd.sdk.exception;

public class KeplerAttachException extends Exception {
    private static final long serialVersionUID = 1;

    public KeplerAttachException() {
    }

    public KeplerAttachException(String str, Throwable th) {
        super(str, th);
    }

    public KeplerAttachException(String str) {
        super(str);
    }

    public KeplerAttachException(Throwable th) {
        super(th);
    }
}
