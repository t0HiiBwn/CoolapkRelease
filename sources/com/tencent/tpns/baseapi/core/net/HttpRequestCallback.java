package com.tencent.tpns.baseapi.core.net;

/* compiled from: ProGuard */
public interface HttpRequestCallback {
    void onFailure(int i, String str);

    void onSuccess(String str);
}
