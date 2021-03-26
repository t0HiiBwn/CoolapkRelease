package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.l;

/* compiled from: TTNativeExpressDrawVideoAdImpl */
public class m extends o {
    public m(Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, l lVar, AdSlot adSlot) {
        this.d = "draw_ad";
        this.a = new NativeExpressVideoView(context, lVar, adSlot, "draw_ad");
        a(this.a, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        if (this.a != null) {
            ((NativeExpressVideoView) this.a).setCanInterruptVideoPlay(z);
        }
    }
}
