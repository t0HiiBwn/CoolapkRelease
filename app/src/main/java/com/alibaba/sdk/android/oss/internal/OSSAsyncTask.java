package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OSSAsyncTask<T extends OSSResult> {
    private volatile boolean canceled;
    private ExecutionContext context;
    private Future<T> future;

    public static OSSAsyncTask wrapRequestTask(Future future2, ExecutionContext executionContext) {
        OSSAsyncTask oSSAsyncTask = new OSSAsyncTask();
        oSSAsyncTask.future = future2;
        oSSAsyncTask.context = executionContext;
        return oSSAsyncTask;
    }

    public void cancel() {
        this.canceled = true;
        ExecutionContext executionContext = this.context;
        if (executionContext != null) {
            executionContext.getCancellationHandler().cancel();
        }
    }

    public boolean isCompleted() {
        return this.future.isDone();
    }

    public T getResult() throws ClientException, ServiceException {
        try {
            return this.future.get();
        } catch (InterruptedException e) {
            throw new ClientException(" InterruptedException and message : " + e.getMessage(), e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof ClientException) {
                throw ((ClientException) cause);
            } else if (cause instanceof ServiceException) {
                throw ((ServiceException) cause);
            } else {
                cause.printStackTrace();
                throw new ClientException("Unexpected exception!" + cause.getMessage());
            }
        }
    }

    public void waitUntilFinished() {
        try {
            this.future.get();
        } catch (Exception unused) {
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }
}
