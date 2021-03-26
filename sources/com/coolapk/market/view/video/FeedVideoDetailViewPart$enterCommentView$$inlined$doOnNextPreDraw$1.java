package com.coolapk.market.view.video;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.coolapk.market.databinding.ItemFeedVideoDetailViewPartBinding;
import com.coolapk.market.extend.ExtraExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$doOnNextPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ VideoDetailReplyListFragment $fragment$inlined;
    final /* synthetic */ View $this_doOnNextPreDraw;
    final /* synthetic */ FeedVideoDetailViewPart this$0;

    public FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1(View view, FeedVideoDetailViewPart feedVideoDetailViewPart, VideoDetailReplyListFragment videoDetailReplyListFragment) {
        this.$this_doOnNextPreDraw = view;
        this.this$0 = feedVideoDetailViewPart;
        this.$fragment$inlined = videoDetailReplyListFragment;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.$this_doOnNextPreDraw.getViewTreeObserver().removeOnPreDrawListener(this);
        FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) this.this$0.getBinding()).commentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentContainer");
        FrameLayout frameLayout2 = ((ItemFeedVideoDetailViewPartBinding) this.this$0.getBinding()).commentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.commentContainer");
        frameLayout.setTranslationY((float) frameLayout2.getHeight());
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setDuration(200L);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1$lambda$1(this));
        ExtraExtendsKt.addListeners$default(valueAnimator, null, new FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1$lambda$2(this), 1, null);
        valueAnimator.start();
        return false;
    }
}
