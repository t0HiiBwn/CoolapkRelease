package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.l;

/* compiled from: TTNativeExpressMiddleVideoAdImpl */
public class n extends o {
    public n(Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, l lVar, AdSlot adSlot) {
        this.d = "feed_video_middle_page";
        if (lVar == null || lVar.R() == null) {
            this.a = new NativeExpressView(context, lVar, adSlot, this.d);
        } else {
            this.a = new NativeExpressVideoView(context, lVar, adSlot, this.d);
        }
        a(this.a, this.c);
        this.a.setBackupListener(new c() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.n.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                return false;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        if (this.a != null && (this.a instanceof NativeExpressVideoView)) {
            ((NativeExpressVideoView) this.a).setCanInterruptVideoPlay(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k, com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.a;
    }
}
