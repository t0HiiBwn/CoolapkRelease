package com.coolapk.market.view.ad.tencent;

import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.OnAdLoadListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/ad/tencent/GDTFeedSelfDrawAD$ensureAdManager$adManager$1", "Lcom/qq/e/ads/nativ/NativeADUnifiedListener;", "onADLoaded", "", "adList", "", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "onNoAD", "error", "Lcom/qq/e/comm/util/AdError;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GDTFeedSelfDrawAD.kt */
public final class GDTFeedSelfDrawAD$ensureAdManager$adManager$1 implements NativeADUnifiedListener {
    final /* synthetic */ GDTFeedSelfDrawAD this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    GDTFeedSelfDrawAD$ensureAdManager$adManager$1(GDTFeedSelfDrawAD gDTFeedSelfDrawAD) {
        this.this$0 = gDTFeedSelfDrawAD;
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

    @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
    public void onADLoaded(List<NativeUnifiedADData> list) {
        List<NativeUnifiedADData> list2 = list;
        if (list2 == null || list2.isEmpty()) {
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
