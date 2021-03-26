package com.coolapk.market.network;

import android.text.TextUtils;

public class Result<T> {
    public static final String ERR_REQUEST_CAPTCHA = "err_request_captcha";
    public static final String ERR_REQUEST_MOBILE = "err_request_mobile";
    private T data;
    private String forwardUrl;
    private String message;
    private String messageExtra;
    private String messageStatus;
    private Integer status;

    public Integer getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageStatus() {
        return this.messageStatus;
    }

    public T getData() {
        return this.data;
    }

    public Result() {
    }

    public Result(Integer num, String str) {
        this.status = num;
        this.message = str;
    }

    public Result(Integer num, String str, String str2, T t) {
        this(num, str);
        this.data = t;
        this.forwardUrl = str2;
    }

    public <CHILD extends T> Result(Result<CHILD> result) {
        this(result.status, result.message, result.forwardUrl, result.messageStatus, result.messageExtra, result.data);
    }

    public Result(Integer num, String str, String str2, String str3, String str4, T t) {
        this(num, str, str2, t);
        this.messageExtra = str4;
        this.messageStatus = str3;
    }

    public boolean isSuccess() {
        Integer num = this.status;
        return num == null || num.intValue() == 1;
    }

    public int getStatusCode() {
        Integer num = this.status;
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public String getForwardUrl() {
        return this.forwardUrl;
    }

    public String getMessageExtra() {
        return this.messageExtra;
    }

    public ClientException checkResult() {
        if (!isSuccess()) {
            if (TextUtils.isEmpty(this.message)) {
                this.message = "Empty error message";
            }
            return new ClientException(this);
        } else if (TextUtils.equals(this.messageStatus, "err_request_captcha") || TextUtils.equals(this.messageStatus, "err_request_mobile")) {
            return new ClientException(this);
        } else {
            return null;
        }
    }
}
