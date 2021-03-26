package com.coolapk.market.view.ad;

import com.coolapk.market.util.LogUtils;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.comm.util.AdError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/ad/EntityAdHelperKt$SIMPLE_NATIVE_AD_LISTENER$1", "Lcom/qq/e/ads/nativ/NativeADEventListener;", "onADClicked", "", "onADError", "error", "Lcom/qq/e/comm/util/AdError;", "onADExposed", "onADStatusChanged", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelperKt$SIMPLE_NATIVE_AD_LISTENER$1 implements NativeADEventListener {
    EntityAdHelperKt$SIMPLE_NATIVE_AD_LISTENER$1() {
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        LogUtils.d("广告曝光", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        LogUtils.d("广告被点击", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        LogUtils.d("错误回调 error code :" + String.valueOf(adError.getErrorCode()) + "  error msg: " + adError.getErrorMsg(), new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
        LogUtils.d("广告状态变化", new Object[0]);
    }
}
