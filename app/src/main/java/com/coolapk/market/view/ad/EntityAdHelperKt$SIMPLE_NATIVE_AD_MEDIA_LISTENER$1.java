package com.coolapk.market.view.ad;

import com.coolapk.market.util.LogUtils;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.comm.util.AdError;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, d2 = {"com/coolapk/market/view/ad/EntityAdHelperKt$SIMPLE_NATIVE_AD_MEDIA_LISTENER$1", "Lcom/qq/e/ads/nativ/NativeADMediaListener;", "onVideoClicked", "", "onVideoCompleted", "onVideoError", "error", "Lcom/qq/e/comm/util/AdError;", "onVideoInit", "onVideoLoaded", "videoDuration", "", "onVideoLoading", "onVideoPause", "onVideoReady", "onVideoResume", "onVideoStart", "onVideoStop", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelperKt$SIMPLE_NATIVE_AD_MEDIA_LISTENER$1 implements NativeADMediaListener {
    EntityAdHelperKt$SIMPLE_NATIVE_AD_MEDIA_LISTENER$1() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoInit() {
        LogUtils.d("onVideoInit: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoading() {
        LogUtils.d("onVideoLoading: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoReady() {
        LogUtils.d("onVideoReady: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoaded(int i) {
        LogUtils.d("onVideoLoaded: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStart() {
        LogUtils.d("onVideoStart: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoPause() {
        LogUtils.d("onVideoPause: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoResume() {
        LogUtils.d("onVideoResume: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoCompleted() {
        LogUtils.d("onVideoCompleted: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoError(AdError adError) {
        LogUtils.d("onVideoError: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStop() {
        LogUtils.d("onVideoStop: ", new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoClicked() {
        LogUtils.d("onVideoClicked: ", new Object[0]);
    }
}
