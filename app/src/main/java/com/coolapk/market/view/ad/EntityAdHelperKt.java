package com.coolapk.market.view.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\n\u0010\u0014\u001a\u00020\u0010*\u00020\u0011\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"SIMPLE_NATIVE_AD_LISTENER", "Lcom/qq/e/ads/nativ/NativeADEventListener;", "getSIMPLE_NATIVE_AD_LISTENER", "()Lcom/qq/e/ads/nativ/NativeADEventListener;", "SIMPLE_NATIVE_AD_MEDIA_LISTENER", "com/coolapk/market/view/ad/EntityAdHelperKt$SIMPLE_NATIVE_AD_MEDIA_LISTENER$1", "Lcom/coolapk/market/view/ad/EntityAdHelperKt$SIMPLE_NATIVE_AD_MEDIA_LISTENER$1;", "SIMPLE_TT_NATIVE_AD_LISTENER", "Lcom/bytedance/sdk/openadsdk/TTNativeAd$AdInteractionListener;", "getSIMPLE_TT_NATIVE_AD_LISTENER", "()Lcom/bytedance/sdk/openadsdk/TTNativeAd$AdInteractionListener;", "SIMPLE_TT_VIDEO_CALLBACK", "Lcom/bytedance/sdk/openadsdk/TTFeedAd$VideoAdListener;", "getSIMPLE_TT_VIDEO_CALLBACK", "()Lcom/bytedance/sdk/openadsdk/TTFeedAd$VideoAdListener;", "makeADVideoDelayAutoPlay", "", "Lcom/qq/e/ads/nativ/MediaView;", "adData", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "removeLastDelayAutoPlayListener", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelperKt {
    private static final NativeADEventListener SIMPLE_NATIVE_AD_LISTENER = new EntityAdHelperKt$SIMPLE_NATIVE_AD_LISTENER$1();
    private static final EntityAdHelperKt$SIMPLE_NATIVE_AD_MEDIA_LISTENER$1 SIMPLE_NATIVE_AD_MEDIA_LISTENER = new EntityAdHelperKt$SIMPLE_NATIVE_AD_MEDIA_LISTENER$1();
    private static final TTNativeAd.AdInteractionListener SIMPLE_TT_NATIVE_AD_LISTENER = new EntityAdHelperKt$SIMPLE_TT_NATIVE_AD_LISTENER$1();
    private static final TTFeedAd.VideoAdListener SIMPLE_TT_VIDEO_CALLBACK = new EntityAdHelperKt$SIMPLE_TT_VIDEO_CALLBACK$1();

    public static final void removeLastDelayAutoPlayListener(MediaView mediaView) {
        Intrinsics.checkNotNullParameter(mediaView, "$this$removeLastDelayAutoPlayListener");
        Object tag = mediaView.getTag(2131363492);
        if (!(tag instanceof View.OnAttachStateChangeListener)) {
            tag = null;
        }
        View.OnAttachStateChangeListener onAttachStateChangeListener = (View.OnAttachStateChangeListener) tag;
        if (onAttachStateChangeListener != null) {
            mediaView.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public static final void makeADVideoDelayAutoPlay(MediaView mediaView, NativeUnifiedADData nativeUnifiedADData) {
        Intrinsics.checkNotNullParameter(mediaView, "$this$makeADVideoDelayAutoPlay");
        Intrinsics.checkNotNullParameter(nativeUnifiedADData, "adData");
        removeLastDelayAutoPlayListener(mediaView);
        boolean z = true;
        nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(2).setAutoPlayMuted(true).setDetailPageMuted(false).build(), SIMPLE_NATIVE_AD_MEDIA_LISTENER);
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "it");
        if (!appSetting.isAutoLoadVideoWhenWifi() || !appSetting.isWifiAvailable()) {
            z = false;
        }
        if (z) {
            EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1 entityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1 = new EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1(nativeUnifiedADData, mediaView);
            mediaView.setTag(2131363492, entityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1);
            mediaView.addOnAttachStateChangeListener(entityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1);
        }
    }

    public static final NativeADEventListener getSIMPLE_NATIVE_AD_LISTENER() {
        return SIMPLE_NATIVE_AD_LISTENER;
    }

    public static final TTNativeAd.AdInteractionListener getSIMPLE_TT_NATIVE_AD_LISTENER() {
        return SIMPLE_TT_NATIVE_AD_LISTENER;
    }

    public static final TTFeedAd.VideoAdListener getSIMPLE_TT_VIDEO_CALLBACK() {
        return SIMPLE_TT_VIDEO_CALLBACK;
    }
}
