package com.coolapk.market.view.video;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ActivityUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoDetailListActivity.kt */
final class VideoDetailListActivity$startOpenAnimation$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VideoDetailListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoDetailListActivity$startOpenAnimation$2(VideoDetailListActivity videoDetailListActivity) {
        super(0);
        this.this$0 = videoDetailListActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        VideoDetailListActivity.access$getDetailViewPart$p(this.this$0).onAnimationEvent(true, false);
        VideoDetailListActivity videoDetailListActivity = this.this$0;
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = VideoDetailListActivity.access$getBinding$p(videoDetailListActivity).contentView;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.contentView");
        Rect lastInsetsRect = drawSystemBarFrameLayout.getLastInsetsRect();
        Intrinsics.checkNotNullExpressionValue(lastInsetsRect, "binding.contentView.lastInsetsRect");
        videoDetailListActivity.applyWindowsInset(lastInsetsRect);
        ActivityUtils activityUtils = ActivityUtils.INSTANCE;
        BaseActivity activity = this.this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        activityUtils.convertActivityFromTranslucent(activity);
        this.this$0.isAnimating = false;
        LinearLayout linearLayout = VideoDetailListActivity.access$getBinding$p(this.this$0).videoContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(linearLayout);
        if (marginParams != null) {
            marginParams.width = -1;
            marginParams.height = -1;
            marginParams.topMargin = 0;
            marginParams.leftMargin = 0;
        }
        this.this$0.setSlidrEnable(true);
    }
}
