package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.multipro.b.a;

/* compiled from: TTNativeExpressVideoAdImpl */
public class o extends k {
    public o(Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, l lVar, AdSlot adSlot) {
        this.a = new NativeExpressVideoView(context, lVar, adSlot, "embeded_ad");
        a(this.a, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        if (this.a != null) {
            this.a.setVideoAdListener(expressVideoAdListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public a getVideoModel() {
        if (this.a != null) {
            return ((NativeExpressVideoView) this.a).getVideoModel();
        }
        return null;
    }
}
