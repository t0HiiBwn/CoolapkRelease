package com.huawei.hmf.tasks;

public interface ExecuteResult<TResult> {
    void cancel();

    void onComplete(Task<TResult> task);
}
