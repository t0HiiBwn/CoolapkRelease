package com.coolapk.market.view.ad.tencent;

import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.OnAdEventListener;
import com.coolapk.market.view.ad.OnAdLoadListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"com/coolapk/market/view/ad/tencent/GDTFeedAd$ensureAdManager$adManager$1", "Lcom/qq/e/ads/nativ/NativeExpressAD$NativeExpressADListener;", "onADClicked", "", "adView", "Lcom/qq/e/ads/nativ/NativeExpressADView;", "onADCloseOverlay", "onADClosed", "onADExposure", "onADLeftApplication", "onADLoaded", "adList", "", "onADOpenOverlay", "onNoAD", "error", "Lcom/qq/e/comm/util/AdError;", "onRenderFail", "onRenderSuccess", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GDTFeedAd.kt */
public final class GDTFeedAd$ensureAdManager$adManager$1 implements NativeExpressAD.NativeExpressADListener {
    final /* synthetic */ GDTFeedAd this$0;

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClicked(NativeExpressADView nativeExpressADView) {
        Intrinsics.checkNotNullParameter(nativeExpressADView, "adView");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
        Intrinsics.checkNotNullParameter(nativeExpressADView, "adView");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        Intrinsics.checkNotNullParameter(nativeExpressADView, "adView");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
        Intrinsics.checkNotNullParameter(nativeExpressADView, "adView");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderFail(NativeExpressADView nativeExpressADView) {
        Intrinsics.checkNotNullParameter(nativeExpressADView, "adView");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        Intrinsics.checkNotNullParameter(nativeExpressADView, "adView");
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    GDTFeedAd$ensureAdManager$adManager$1(GDTFeedAd gDTFeedAd) {
        this.this$0 = gDTFeedAd;
    }

    @Override // com.qq.e.ads.AbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        LogUtils.e("广告加载失败, " + adError.getErrorCode() + ':' + adError.getErrorMsg(), new Object[0]);
        this.this$0.state = 3;
        OnAdLoadListener onAdLoadListener = this.this$0.adLoadListener;
        if (onAdLoadListener != null) {
            onAdLoadListener.onLoadError(new Exception(adError.getErrorCode() + ": " + adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClosed(NativeExpressADView nativeExpressADView) {
        Intrinsics.checkNotNullParameter(nativeExpressADView, "adView");
        OnAdEventListener onAdEventListener = this.this$0.eventListener;
        if (onAdEventListener != null) {
            onAdEventListener.onAdClose(nativeExpressADView, this.this$0.adDataList);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADExposure(NativeExpressADView nativeExpressADView) {
        Intrinsics.checkNotNullParameter(nativeExpressADView, "adView");
        OnAdEventListener onAdEventListener = this.this$0.eventListener;
        if (onAdEventListener != null) {
            onAdEventListener.onAdShow(this.this$0.adDataList);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLoaded(List<NativeExpressADView> list) {
        Intrinsics.checkNotNullParameter(list, "adList");
        List<NativeExpressADView> list2 = list;
        if (list2.isEmpty()) {
            LogUtils.w("广告加载失败, 没有数据", new Object[0]);
            this.this$0.state = 3;
            OnAdLoadListener onAdLoadListener = this.this$0.adLoadListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onLoadError(new Exception("Ads is null on feed ad loaded"));
                return;
            }
            return;
        }
        LogUtils.i("广告加载成功，有" + list.size() + "条数据", new Object[0]);
        this.this$0.state = 2;
        if (this.this$0.isRelease) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().destroy();
            }
            return;
        }
        this.this$0.adDataList.addAll(list2);
        OnAdLoadListener onAdLoadListener2 = this.this$0.adLoadListener;
        if (onAdLoadListener2 != null) {
            onAdLoadListener2.onLoadSuccess(list);
        }
    }
}
