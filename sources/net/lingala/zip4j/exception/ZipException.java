package net.lingala.zip4j.exception;

import java.io.IOException;

public class ZipException extends IOException {
    private static final long serialVersionUID = 1;
    private Type type = Type.UNKNOWN;

    public enum Type {
        WRONG_PASSWORD,
        TASK_CANCELLED_EXCEPTION,
        CHECKSUM_MISMATCH,
        UNKNOWN_COMPRESSION_METHOD,
        FILE_NOT_FOUND,
        UNKNOWN
    }

    public ZipException(String str) {
        super(str);
    }

    public ZipException(Exception exc) {
        super(exc);
    }

    public ZipException(String str, Exception exc) {
        super(str, exc);
    }

    public ZipException(String str, Type type2) {
        super(str);
        this.type = type2;
    }

    public ZipException(String str, Throwable th, Type type2) {
        super(str, th);
        this.type = type2;
    }

    public Type getType() {
        return this.type;
    }
}
