package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMOfflinePushToken;

public class V2TIMOfflinePushConfig {
    private TIMOfflinePushToken timOfflinePushToken;

    public V2TIMOfflinePushConfig(long j, String str) {
        this.timOfflinePushToken = new TIMOfflinePushToken(j, str);
    }

    TIMOfflinePushToken getTIMOfflinePushToken() {
        return this.timOfflinePushToken;
    }
}
