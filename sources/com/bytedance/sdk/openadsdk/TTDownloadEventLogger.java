package com.bytedance.sdk.openadsdk;

import com.ss.android.a.a.c.d;

public interface TTDownloadEventLogger {
    void onEvent(d dVar);

    void onV3Event(d dVar);

    boolean shouldFilterOpenSdkLog();
}
