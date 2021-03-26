package com.alibaba.sdk.android.oss.network;

import android.content.Context;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.callback.OSSRetryCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import okhttp3.OkHttpClient;

public class ExecutionContext<Request extends OSSRequest, Result extends OSSResult> {
    private Context applicationContext;
    private CancellationHandler cancellationHandler;
    private OkHttpClient client;
    private OSSCompletedCallback completedCallback;
    private OSSProgressCallback progressCallback;
    private Request request;
    private OSSRetryCallback retryCallback;

    public ExecutionContext(OkHttpClient okHttpClient, Request request2) {
        this(okHttpClient, request2, null);
    }

    public ExecutionContext(OkHttpClient okHttpClient, Request request2, Context context) {
        this.cancellationHandler = new CancellationHandler();
        setClient(okHttpClient);
        setRequest(request2);
        this.applicationContext = context;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }

    public OkHttpClient getClient() {
        return this.client;
    }

    public void setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public CancellationHandler getCancellationHandler() {
        return this.cancellationHandler;
    }

    public OSSCompletedCallback<Request, Result> getCompletedCallback() {
        return this.completedCallback;
    }

    public void setCompletedCallback(OSSCompletedCallback<Request, Result> oSSCompletedCallback) {
        this.completedCallback = oSSCompletedCallback;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public OSSRetryCallback getRetryCallback() {
        return this.retryCallback;
    }

    public void setRetryCallback(OSSRetryCallback oSSRetryCallback) {
        this.retryCallback = oSSRetryCallback;
    }
}
