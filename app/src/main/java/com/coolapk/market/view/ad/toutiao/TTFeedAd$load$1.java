package com.coolapk.market.view.ad.toutiao;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.OnAdLoadListener;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/view/ad/toutiao/TTFeedAd$load$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$NativeExpressAdListener;", "onError", "", "code", "", "message", "", "onNativeExpressAdLoad", "ads", "", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TTFeedAd.kt */
public final class TTFeedAd$load$1 implements TTAdNative.NativeExpressAdListener {
    final /* synthetic */ TTFeedAd this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    TTFeedAd$load$1(TTFeedAd tTFeedAd) {
        this.this$0 = tTFeedAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
    public void onError(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        LogUtils.e("广告加载失败, " + i + ':' + str, new Object[0]);
        this.this$0.state = 3;
        OnAdLoadListener onAdLoadListener = this.this$0.adLoadListener;
        if (onAdLoadListener != null) {
            onAdLoadListener.onLoadError(new Exception(i + ": " + str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<? extends TTNativeExpressAd> list) {
        List<? extends TTNativeExpressAd> list2 = list;
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
        this.this$0.processAdData();
        OnAdLoadListener onAdLoadListener2 = this.this$0.adLoadListener;
        if (onAdLoadListener2 != null) {
            onAdLoadListener2.onLoadSuccess(list);
        }
    }
}
