package com.tencent.imsdk;

public interface TIMValueCallBack<T> {
    void onError(int i, String str);

    void onSuccess(T t);
}
