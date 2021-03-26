package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.splash.b;
import com.bytedance.sdk.openadsdk.component.splash.c;

public class TTC2Proxy {
    private TTC2Proxy() {
    }

    public static void load(Context context, AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i) {
        b.a(context).a(adSlot, splashAdListener, i);
    }

    public static void a(Context context) {
        c.a(context);
    }
}
