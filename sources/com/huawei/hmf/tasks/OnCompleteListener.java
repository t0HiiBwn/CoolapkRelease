package com.huawei.hmf.tasks;

public interface OnCompleteListener<TResult> {
    void onComplete(Task<TResult> task);
}
