package com.ali.auth.third.core.task;

import android.os.AsyncTask;

public abstract class AbsAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    protected abstract Result asyncExecute(Params... paramsArr);

    protected abstract void doFinally();

    /* JADX INFO: finally extract failed */
    @Override // android.os.AsyncTask
    protected Result doInBackground(Params... paramsArr) {
        try {
            Result asyncExecute = asyncExecute(paramsArr);
            doFinally();
            return asyncExecute;
        } catch (Throwable th) {
            doFinally();
            throw th;
        }
    }

    protected abstract void doWhenException(Throwable th);
}
