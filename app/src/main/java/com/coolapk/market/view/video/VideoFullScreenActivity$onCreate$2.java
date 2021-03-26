package com.coolapk.market.view.video;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoFullScreenActivity.kt */
final class VideoFullScreenActivity$onCreate$2 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ VideoFullScreenActivity this$0;

    VideoFullScreenActivity$onCreate$2(VideoFullScreenActivity videoFullScreenActivity) {
        this.this$0 = videoFullScreenActivity;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        if (this.this$0.isLandScape) {
            LinearLayout linearLayout = VideoFullScreenActivity.access$getBinding$p(this.this$0).videoContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(linearLayout);
            if (marginParams != null) {
                marginParams.leftMargin = rect.left;
            }
            VideoFullScreenActivity.access$getBinding$p(this.this$0).videoContainer.requestLayout();
            return;
        }
        LinearLayout linearLayout2 = VideoFullScreenActivity.access$getBinding$p(this.this$0).videoContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.videoContainer");
        ViewGroup.MarginLayoutParams marginParams2 = ViewExtendsKt.getMarginParams(linearLayout2);
        if (marginParams2 != null) {
            marginParams2.leftMargin = 0;
        }
        VideoFullScreenActivity.access$getBinding$p(this.this$0).videoContainer.requestLayout();
    }
}
