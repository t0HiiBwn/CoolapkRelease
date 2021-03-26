package com.tencent.imsdk.v2;

public interface V2TIMSendCallback<T> extends V2TIMValueCallback<T> {
    void onProgress(int i);
}
