package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ak;

public class BannerExpressVideoView extends a {
    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        super.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        super.setVideoAdListener(expressVideoAdListener);
    }

    public BannerExpressVideoView(Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    protected void a() {
        this.b = new NativeExpressVideoView(this.a, this.d, this.e, this.j);
        addView(this.b, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public void a(l lVar, AdSlot adSlot) {
        this.c = new NativeExpressVideoView(this.a, lVar, adSlot, this.j);
        this.c.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() {
            /* class com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (BannerExpressVideoView.this.f != null) {
                    BannerExpressVideoView.this.f.onAdClicked(BannerExpressVideoView.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                BannerExpressVideoView.this.a(f, f2);
                BannerExpressVideoView.this.f();
            }
        });
        ak.a((View) this.c, 8);
        addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    }

    public a getVideoModel() {
        if (this.b != null) {
            return ((NativeExpressVideoView) this.b).getVideoModel();
        }
        return null;
    }
}
