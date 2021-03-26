package com.ali.auth.third.core.task;

import android.os.AsyncTask;

public class CoordinatorWrapper<Params> {
    public void execute(AsyncTask asyncTask, Params... paramsArr) {
        if (asyncTask != null) {
            try {
                asyncTask.execute(paramsArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            Coordinator.execute(runnable);
        }
    }
}
