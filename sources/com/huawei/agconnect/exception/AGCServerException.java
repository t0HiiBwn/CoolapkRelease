package com.huawei.agconnect.exception;

public class AGCServerException extends AGCException {
    public static final int AUTHENTICATION_FAILED = 403;
    public static final int AUTHENTICATION_INVALID = 400;
    public static final int OK = 200;
    public static final int SERVER_NOT_AVAILABLE = 503;
    public static final int SERVER_RSP_INVALID = 2;
    public static final int TOKEN_INVALID = 401;
    public static final int UNKNOW_EXCEPTION = 500;

    public AGCServerException(String str, int i) {
        super(str, i);
    }
}
