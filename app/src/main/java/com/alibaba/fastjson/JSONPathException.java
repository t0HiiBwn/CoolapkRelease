package com.alibaba.fastjson;

public class JSONPathException extends JSONException {
    public JSONPathException(String str) {
        super(str);
    }

    public JSONPathException(String str, Throwable th) {
        super(str, th);
    }
}
