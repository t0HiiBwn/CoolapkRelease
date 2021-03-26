package com.coolapk.market.view.ad.toutiao;

import android.view.View;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.coolapk.market.view.ad.OnAdEventListener;
import com.coolapk.market.view.ad.toutiao.DislikeDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/ad/toutiao/TTFeedAd$bindDislike$1", "Lcom/coolapk/market/view/ad/toutiao/DislikeDialog$OnDislikeItemClick;", "onItemClick", "", "filterWord", "Lcom/bytedance/sdk/openadsdk/FilterWord;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TTFeedAd.kt */
public final class TTFeedAd$bindDislike$1 implements DislikeDialog.OnDislikeItemClick {
    final /* synthetic */ TTNativeExpressAd $ad;
    final /* synthetic */ TTFeedAd this$0;

    TTFeedAd$bindDislike$1(TTFeedAd tTFeedAd, TTNativeExpressAd tTNativeExpressAd) {
        this.this$0 = tTFeedAd;
        this.$ad = tTNativeExpressAd;
    }

    @Override // com.coolapk.market.view.ad.toutiao.DislikeDialog.OnDislikeItemClick
    public void onItemClick(FilterWord filterWord) {
        Intrinsics.checkNotNullParameter(filterWord, "filterWord");
        OnAdEventListener onAdEventListener = this.this$0.eventListener;
        if (onAdEventListener != null) {
            View expressAdView = this.$ad.getExpressAdView();
            Intrinsics.checkNotNullExpressionValue(expressAdView, "ad.expressAdView");
            onAdEventListener.onAdClose(expressAdView, this.$ad);
        }
    }
}
