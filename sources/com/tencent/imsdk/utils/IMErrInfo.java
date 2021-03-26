package com.tencent.imsdk.utils;

public class IMErrInfo {
    int code;
    String msg = "";

    public IMErrInfo(int i, String str) {
        this.code = i;
        if (!str.isEmpty()) {
            this.msg = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        if (!str.isEmpty()) {
            this.msg = str;
        }
    }
}
