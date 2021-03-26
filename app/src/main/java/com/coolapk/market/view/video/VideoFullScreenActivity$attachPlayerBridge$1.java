package com.coolapk.market.view.video;

import android.transition.Transition;
import android.view.Window;
import com.coolapk.market.animation.TransitionListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/video/VideoFullScreenActivity$attachPlayerBridge$1", "Lcom/coolapk/market/animation/TransitionListenerAdapter;", "onTransitionEnd", "", "transition", "Landroid/transition/Transition;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoFullScreenActivity.kt */
public final class VideoFullScreenActivity$attachPlayerBridge$1 extends TransitionListenerAdapter {
    final /* synthetic */ VideoFullScreenActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    VideoFullScreenActivity$attachPlayerBridge$1(VideoFullScreenActivity videoFullScreenActivity) {
        this.this$0 = videoFullScreenActivity;
    }

    @Override // com.coolapk.market.animation.TransitionListenerAdapter, android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        super.onTransitionEnd(transition);
        VideoFullScreenActivity.access$getPlayer$p(this.this$0).attachPlayerBridge(this.this$0);
        VideoFullScreenActivity.access$getPlayer$p(this.this$0).resume();
        Window window = this.this$0.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        window.getSharedElementEnterTransition().removeListener(this);
    }
}
