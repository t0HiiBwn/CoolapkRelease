package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;

public class EmptyPendingResult<R extends Result> extends PendingResult<R> {
    private R a;

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void cancel() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
    }

    public R getResult() {
        return this.a;
    }

    public void setResult(R r) {
        this.a = r;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await() {
        return this.a;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, TimeUnit timeUnit) {
        return this.a;
    }
}
