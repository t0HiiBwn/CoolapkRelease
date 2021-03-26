package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.multipro.b;

@Deprecated
public class TTAdManagerFactory {
    private static final TTAdManager a = new v();

    private TTAdManagerFactory() {
    }

    public static TTAdManager getInstance(Context context) {
        return getInstance(context, false);
    }

    public static TTAdManager getInstance(Context context, boolean z) {
        if (z) {
            b.a();
        }
        m.a(context);
        return a;
    }

    static TTAdManager a() {
        return a;
    }
}
