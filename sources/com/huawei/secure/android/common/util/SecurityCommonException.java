package com.huawei.secure.android.common.util;

public class SecurityCommonException extends Exception {
    private static final long serialVersionUID = 1;
    private String t;
    private String u;

    public SecurityCommonException() {
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.u = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.t = str;
        this.u = str2;
    }

    public String getRetCd() {
        return this.t;
    }

    public String getMsgDes() {
        return this.u;
    }
}
