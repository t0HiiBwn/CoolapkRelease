package com.coolapk.market.view.video;

import android.animation.ValueAnimator;
import com.coolapk.market.widget.video.VideoPlayerBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"com/coolapk/market/view/video/VideoDetailListActivity$startCloseAnimation$3", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "callShowPause", "", "getCallShowPause", "()Z", "setCallShowPause", "(Z)V", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoDetailListActivity.kt */
public final class VideoDetailListActivity$startCloseAnimation$3 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ VideoPlayerBridge $targetBridge;
    private boolean callShowPause;

    VideoDetailListActivity$startCloseAnimation$3(VideoPlayerBridge videoPlayerBridge) {
        this.$targetBridge = videoPlayerBridge;
    }

    public final boolean getCallShowPause() {
        return this.callShowPause;
    }

    public final void setCallShowPause(boolean z) {
        this.callShowPause = z;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        if (valueAnimator.getAnimatedFraction() > 0.98f && !this.callShowPause) {
            this.callShowPause = true;
            VideoPlayerBridge videoPlayerBridge = this.$targetBridge;
            if (videoPlayerBridge != null) {
                VideoPlayerBridge.DefaultImpls.onAction$default(videoPlayerBridge, "show_pause_cover", null, 2, null);
            }
        }
    }
}
