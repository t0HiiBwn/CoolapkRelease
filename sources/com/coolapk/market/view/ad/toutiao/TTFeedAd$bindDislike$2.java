package com.coolapk.market.view.ad.toutiao;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.coolapk.market.view.ad.OnAdEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/ad/toutiao/TTFeedAd$bindDislike$2", "Lcom/bytedance/sdk/openadsdk/TTAdDislike$DislikeInteractionCallback;", "onCancel", "", "onRefuse", "onSelected", "position", "", "value", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TTFeedAd.kt */
public final class TTFeedAd$bindDislike$2 implements TTAdDislike.DislikeInteractionCallback {
    final /* synthetic */ TTNativeExpressAd $ad;
    final /* synthetic */ TTFeedAd this$0;

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
    }

    TTFeedAd$bindDislike$2(TTFeedAd tTFeedAd, TTNativeExpressAd tTNativeExpressAd) {
        this.this$0 = tTFeedAd;
        this.$ad = tTNativeExpressAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        OnAdEventListener onAdEventListener = this.this$0.eventListener;
        if (onAdEventListener != null) {
            View expressAdView = this.$ad.getExpressAdView();
            Intrinsics.checkNotNullExpressionValue(expressAdView, "ad.expressAdView");
            onAdEventListener.onAdClose(expressAdView, this.$ad);
        }
    }
}
