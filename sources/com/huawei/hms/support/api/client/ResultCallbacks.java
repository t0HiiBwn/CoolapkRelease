package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

@Deprecated
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    public abstract void onSuccess(R r);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.huawei.hms.support.api.client.ResultCallbacks<R extends com.huawei.hms.support.api.client.Result> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.support.api.client.ResultCallback
    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult((ResultCallbacks<R>) ((Result) obj));
    }

    public final void onResult(R r) {
        try {
            Status status = r.getStatus();
            if (status.isSuccess()) {
                onSuccess(r);
                return;
            }
            onFailure(status);
            if (r instanceof Releasable) {
                ((Releasable) r).release();
            }
        } catch (Exception e) {
            HMSLog.w("ResultCallbacks", "Failed to release " + r + ", reason: " + e);
        }
    }
}
