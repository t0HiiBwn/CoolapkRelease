package com.bytedance.sdk.openadsdk.core.c;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.multipro.b.a;

/* compiled from: TTInteractionExpressVideoAdImpl */
public class c extends b {
    public c(Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.c.b
    protected void a(Context context, l lVar, AdSlot adSlot, String str) {
        this.a = new NativeExpressVideoView(context, lVar, adSlot, str);
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
