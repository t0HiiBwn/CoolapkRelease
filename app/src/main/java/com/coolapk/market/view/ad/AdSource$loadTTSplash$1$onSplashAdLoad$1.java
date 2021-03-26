package com.coolapk.market.view.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/ad/AdSource$loadTTSplash$1$onSplashAdLoad$1", "Lcom/bytedance/sdk/openadsdk/TTSplashAd$AdInteractionListener;", "onAdClicked", "", "view", "Landroid/view/View;", "type", "", "onAdShow", "onAdSkip", "onAdTimeOver", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AdSource.kt */
public final class AdSource$loadTTSplash$1$onSplashAdLoad$1 implements TTSplashAd.AdInteractionListener {
    final /* synthetic */ TTSplashAd $ad;
    final /* synthetic */ AdSource$loadTTSplash$1 this$0;

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdSkip() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdTimeOver() {
    }

    AdSource$loadTTSplash$1$onSplashAdLoad$1(AdSource$loadTTSplash$1 adSource$loadTTSplash$1, TTSplashAd tTSplashAd) {
        this.this$0 = adSource$loadTTSplash$1;
        this.$ad = tTSplashAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        LogUtils.d("广告点击", new Object[0]);
        OnAdEventListener onAdEventListener = this.this$0.this$0.eventListener;
        if (onAdEventListener != null) {
            onAdEventListener.onAdClick(view, this.$ad);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        LogUtils.d("广告展示", new Object[0]);
        this.this$0.this$0.isSplashShow = true;
        OnAdEventListener onAdEventListener = this.this$0.this$0.eventListener;
        if (onAdEventListener != null) {
            onAdEventListener.onAdShow(this.$ad);
        }
    }
}
