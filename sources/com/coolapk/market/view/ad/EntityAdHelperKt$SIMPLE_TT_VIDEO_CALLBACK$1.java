package com.coolapk.market.view.ad;

import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0012"}, d2 = {"com/coolapk/market/view/ad/EntityAdHelperKt$SIMPLE_TT_VIDEO_CALLBACK$1", "Lcom/bytedance/sdk/openadsdk/TTFeedAd$VideoAdListener;", "onProgressUpdate", "", "current", "", "duration", "onVideoAdComplete", "ad", "Lcom/bytedance/sdk/openadsdk/TTFeedAd;", "onVideoAdContinuePlay", "onVideoAdPaused", "onVideoAdStartPlay", "onVideoError", "errorCode", "", "extraCode", "onVideoLoad", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelperKt$SIMPLE_TT_VIDEO_CALLBACK$1 implements TTFeedAd.VideoAdListener {
    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    EntityAdHelperKt$SIMPLE_TT_VIDEO_CALLBACK$1() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoLoad(TTFeedAd tTFeedAd) {
        Intrinsics.checkNotNullParameter(tTFeedAd, "ad");
        LogUtils.d("onVideoLoad: ", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoError(int i, int i2) {
        LogUtils.d("onVideoError: " + i, new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
        Intrinsics.checkNotNullParameter(tTFeedAd, "ad");
        LogUtils.d("onVideoAdStartPlay: ", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdPaused(TTFeedAd tTFeedAd) {
        Intrinsics.checkNotNullParameter(tTFeedAd, "ad");
        LogUtils.d("onVideoAdPaused: ", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
        Intrinsics.checkNotNullParameter(tTFeedAd, "ad");
        LogUtils.d("onVideoAdContinuePlay: ", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdComplete(TTFeedAd tTFeedAd) {
        Intrinsics.checkNotNullParameter(tTFeedAd, "ad");
        LogUtils.d("onVideoAdComplete: ", new Object[0]);
    }
}
