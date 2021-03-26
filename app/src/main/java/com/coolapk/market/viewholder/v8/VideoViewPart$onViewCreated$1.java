package com.coolapk.market.viewholder.v8;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/viewholder/v8/VideoViewPart$onViewCreated$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoViewPart.kt */
public final class VideoViewPart$onViewCreated$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ VideoViewPart this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    VideoViewPart$onViewCreated$1(VideoViewPart videoViewPart) {
        this.this$0 = videoViewPart;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (!this.this$0.getWillFixTop()) {
            this.this$0.checkStateForAutoPlay(true);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if ((activityNullable != null ? activityNullable.isFinishing() : false) || !this.this$0.getWillFixTop()) {
            this.this$0.checkStateForAutoPlay(false);
            this.this$0.detachVideoIfPlaying();
        }
    }
}
