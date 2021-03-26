package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.multipro.b.a;

/* compiled from: TTBannerExpressVideoAdImpl */
public class c extends b {
    public c(Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.b
    public void a(Context context, l lVar, AdSlot adSlot) {
        this.a = new BannerExpressVideoView(context, lVar, adSlot);
        a(this.a.getCurView(), this.c);
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
            return ((BannerExpressVideoView) this.a).getVideoModel();
        }
        return null;
    }
}
