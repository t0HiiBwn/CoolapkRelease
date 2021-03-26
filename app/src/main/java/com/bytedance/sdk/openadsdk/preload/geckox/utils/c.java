package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.bytedance.sdk.openadsdk.preload.geckox.h.b;

/* compiled from: ExceptionUtils */
public class c {
    public static void a(Throwable th) {
        if (!e.a()) {
            b.a("gecko-debug-tag", "throwIfDebug:", th);
        } else {
            b.b("gecko-debug-tag", "throwIfDebug:", th);
            throw new RuntimeException(th);
        }
    }
}
