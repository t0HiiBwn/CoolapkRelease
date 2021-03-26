package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.content.Context;

/* compiled from: LibLoader */
public class g {
    private static Context a;

    public static void a(Context context) {
        if (context != null) {
            a = context;
        }
    }

    public static void a(String str) {
        System.loadLibrary(str);
    }
}
