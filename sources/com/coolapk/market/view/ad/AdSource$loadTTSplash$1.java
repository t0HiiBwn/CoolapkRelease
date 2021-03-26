package com.coolapk.market.view.ad;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J\b\u0010\u000b\u001a\u00020\u0003H\u0017¨\u0006\f"}, d2 = {"com/coolapk/market/view/ad/AdSource$loadTTSplash$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;", "onError", "", "code", "", "message", "", "onSplashAdLoad", "ad", "Lcom/bytedance/sdk/openadsdk/TTSplashAd;", "onTimeout", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AdSource.kt */
public final class AdSource$loadTTSplash$1 implements TTAdNative.SplashAdListener {
    final /* synthetic */ OnAdLoadListener $listener;
    final /* synthetic */ AdSource this$0;

    AdSource$loadTTSplash$1(AdSource adSource, OnAdLoadListener onAdLoadListener) {
        this.this$0 = adSource;
        this.$listener = onAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.a.b
    public void onError(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        LogUtils.e("广告加载出错: " + i + ' ' + str, new Object[0]);
        AdSource.access$setLoaded$p(this.this$0, true);
        OnAdLoadListener onAdLoadListener = this.$listener;
        onAdLoadListener.onLoadError(new Exception(i + ": " + str));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
    public void onTimeout() {
        LogUtils.w("广告加载超时", new Object[0]);
        AdSource.access$setLoaded$p(this.this$0, true);
        OnAdEventListener access$getEventListener$p = AdSource.access$getEventListener$p(this.this$0);
        if (access$getEventListener$p != null) {
            access$getEventListener$p.shouldGoMainActivity("Ad load timeout");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
    public void onSplashAdLoad(TTSplashAd tTSplashAd) {
        LogUtils.i("广告加载成功", new Object[0]);
        AdSource.access$setLoaded$p(this.this$0, true);
        if (tTSplashAd != null) {
            AdSource.access$setData$p(this.this$0, tTSplashAd);
            tTSplashAd.setNotAllowSdkCountdown();
            tTSplashAd.setSplashInteractionListener(new AdSource$loadTTSplash$1$onSplashAdLoad$1(this, tTSplashAd));
            this.$listener.onLoadSuccess(tTSplashAd);
            return;
        }
        this.$listener.onLoadError(new Exception("Ad is null on splash ad loaded"));
    }
}
