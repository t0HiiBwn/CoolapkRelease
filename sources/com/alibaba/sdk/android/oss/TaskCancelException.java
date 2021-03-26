package com.alibaba.sdk.android.oss;

public class TaskCancelException extends Exception {
    public TaskCancelException() {
    }

    public TaskCancelException(String str) {
        super("[ErrorMessage]: " + str);
    }

    public TaskCancelException(Throwable th) {
        super(th);
    }
}
