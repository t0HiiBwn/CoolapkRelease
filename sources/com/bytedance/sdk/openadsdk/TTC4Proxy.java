package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.interaction.a;

public class TTC4Proxy {
    private TTC4Proxy() {
    }

    public static void load(Context context, AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
        a.a().a(context, adSlot, interactionAdListener);
    }
}
