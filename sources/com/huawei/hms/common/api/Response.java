package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

public class Response<T extends Result> {
    protected T result;

    public Response() {
    }

    protected Response(T t) {
        this.result = t;
    }

    protected T getResult() {
        return this.result;
    }

    public void setResult(T t) {
        this.result = t;
    }
}
