package com.tencent.imsdk.v2;

public interface V2TIMValueCallback<T> {
    void onError(int i, String str);

    void onSuccess(T t);
}
