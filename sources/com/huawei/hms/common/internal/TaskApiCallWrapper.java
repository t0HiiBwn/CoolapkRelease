package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

public class TaskApiCallWrapper<TResult> extends a {
    private final TaskApiCall<? extends AnyClient, TResult> a;
    private final TaskCompletionSource<TResult> b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.a = taskApiCall;
        this.b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.b;
    }
}
