package com.coolapk.market.view.ad;

import android.view.ViewGroup;
import com.coolapk.market.util.LogUtils;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/coolapk/market/view/ad/AdSource$loadGDTSplash$splashAD$1", "Lcom/qq/e/ads/splash/SplashADListener;", "onADClicked", "", "onADDismissed", "onADExposure", "onADLoaded", "expireTimestamp", "", "onADPresent", "onADTick", "millisUntilFinished", "onNoAD", "error", "Lcom/qq/e/comm/util/AdError;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AdSource.kt */
public final class AdSource$loadGDTSplash$splashAD$1 implements SplashADListener {
    final /* synthetic */ OnAdLoadListener $listener;
    final /* synthetic */ AdSource this$0;

    AdSource$loadGDTSplash$splashAD$1(AdSource adSource, OnAdLoadListener onAdLoadListener) {
        this.this$0 = adSource;
        this.$listener = onAdLoadListener;
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        LogUtils.d("广告曝光", new Object[0]);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        LogUtils.d("广告消失", new Object[0]);
        OnAdEventListener access$getEventListener$p = AdSource.access$getEventListener$p(this.this$0);
        if (access$getEventListener$p != null) {
            access$getEventListener$p.shouldGoMainActivity("Ad dismissed");
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
        LogUtils.d("广告展示", new Object[0]);
        AdSource.access$setLoaded$p(this.this$0, true);
        this.$listener.onLoadSuccess(AdSource.access$getData$p(this.this$0));
        AdSource.access$setSplashShow$p(this.this$0, true);
        OnAdEventListener access$getEventListener$p = AdSource.access$getEventListener$p(this.this$0);
        if (access$getEventListener$p != null) {
            access$getEventListener$p.onAdShow(AdSource.access$getData$p(this.this$0));
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        LogUtils.d("广告已加载", new Object[0]);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        LogUtils.e("广告加载失败", adError);
        AdSource.access$setLoaded$p(this.this$0, true);
        OnAdLoadListener onAdLoadListener = this.$listener;
        onAdLoadListener.onLoadError(new Exception(adError.getErrorCode() + ": " + adError.getErrorMsg()));
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        OnAdEventListener access$getEventListener$p = AdSource.access$getEventListener$p(this.this$0);
        if (access$getEventListener$p != null) {
            ViewGroup access$getAdContainer$p = AdSource.access$getAdContainer$p(this.this$0);
            Intrinsics.checkNotNull(access$getAdContainer$p);
            access$getEventListener$p.onAdClick(access$getAdContainer$p, AdSource.access$getData$p(this.this$0));
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
        LogUtils.d("倒计时 " + MathKt.roundToInt(((float) j) / 1000.0f), new Object[0]);
    }
}
