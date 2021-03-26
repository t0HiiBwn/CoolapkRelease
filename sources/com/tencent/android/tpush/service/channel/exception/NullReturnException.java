package com.tencent.android.tpush.service.channel.exception;

/* compiled from: ProGuard */
public class NullReturnException extends Exception {
    private static final long serialVersionUID = -2623309261327598087L;
    private int statusCode = -1;

    public NullReturnException(String str) {
        super(str);
    }

    public NullReturnException(Exception exc) {
        super(exc);
    }

    public NullReturnException(String str, int i) {
        super(str);
        this.statusCode = i;
    }

    public NullReturnException(String str, Exception exc) {
        super(str, exc);
    }

    public NullReturnException(String str, Exception exc, int i) {
        super(str, exc);
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
