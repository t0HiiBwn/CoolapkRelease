package com.coolapk.market.view.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/ad/EntityAdHelperKt$SIMPLE_TT_NATIVE_AD_LISTENER$1", "Lcom/bytedance/sdk/openadsdk/TTNativeAd$AdInteractionListener;", "onAdClicked", "", "view", "Landroid/view/View;", "ad", "Lcom/bytedance/sdk/openadsdk/TTNativeAd;", "onAdCreativeClick", "onAdShow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelperKt$SIMPLE_TT_NATIVE_AD_LISTENER$1 implements TTNativeAd.AdInteractionListener {
    EntityAdHelperKt$SIMPLE_TT_NATIVE_AD_LISTENER$1() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (tTNativeAd != null) {
            LogUtils.d("广告" + tTNativeAd.getTitle() + "被点击", new Object[0]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (tTNativeAd != null) {
            LogUtils.d("广告" + tTNativeAd.getTitle() + "被创意按钮被点击", new Object[0]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        if (tTNativeAd != null) {
            LogUtils.d("广告: " + tTNativeAd.getTitle() + " 展示成功", new Object[0]);
        }
    }
}
