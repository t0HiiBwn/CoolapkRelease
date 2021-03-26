package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {
    private final String a;
    private final String b;
    private Parcelable c;
    private String d;
    private CancellationToken e;
    private int f = 1;

    protected abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = null;
        this.d = null;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = null;
        this.d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i) {
        this.a = str;
        this.b = str2;
        this.c = null;
        this.d = str3;
        this.f = i;
    }

    public CancellationToken getToken() {
        return this.e;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.e = cancellationToken;
    }

    public String getUri() {
        return this.a;
    }

    public String getTransactionId() {
        return this.d;
    }

    public void setTransactionId(String str) {
        this.d = str;
    }

    public String getRequestJson() {
        return this.b;
    }

    public Parcelable getParcelable() {
        return this.c;
    }

    public void setParcelable(Parcelable parcelable) {
        this.c = parcelable;
    }

    public int getApiLevel() {
        return this.f;
    }

    public void setApiLevel(int i) {
        this.f = i;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.e;
        if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
            doExecute(clientt, responseErrorCode, str, taskCompletionSource);
            return;
        }
        HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.a + ", transactionId:" + this.d);
    }
}
