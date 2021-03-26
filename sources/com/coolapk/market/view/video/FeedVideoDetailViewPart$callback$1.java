package com.coolapk.market.view.video;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import com.coolapk.market.databinding.ItemFeedVideoDetailViewPartBinding;
import com.coolapk.market.view.video.VideoDetailReplyListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/video/FeedVideoDetailViewPart$callback$1", "Lcom/coolapk/market/view/video/VideoDetailReplyListFragment$Callback;", "requestExitCommentView", "", "requestRestoreCommentView", "setDropOffset", "offset", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVideoDetailViewPart.kt */
public final class FeedVideoDetailViewPart$callback$1 implements VideoDetailReplyListFragment.Callback {
    final /* synthetic */ FeedVideoDetailViewPart this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedVideoDetailViewPart$callback$1(FeedVideoDetailViewPart feedVideoDetailViewPart) {
        this.this$0 = feedVideoDetailViewPart;
    }

    @Override // com.coolapk.market.view.video.VideoDetailReplyListFragment.Callback
    public void requestExitCommentView() {
        FeedVideoDetailViewPart.access$requestExitCommentView(this.this$0);
    }

    @Override // com.coolapk.market.view.video.VideoDetailReplyListFragment.Callback
    public void requestRestoreCommentView() {
        FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) this.this$0.getBinding()).commentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentContainer");
        float translationY = frameLayout.getTranslationY();
        FrameLayout frameLayout2 = ((ItemFeedVideoDetailViewPartBinding) this.this$0.getBinding()).commentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.commentContainer");
        float height = translationY / ((float) frameLayout2.getHeight());
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(((float) 1) - height, 1.0f);
        valueAnimator.addUpdateListener(new FeedVideoDetailViewPart$callback$1$requestRestoreCommentView$$inlined$apply$lambda$1(this, height));
        valueAnimator.start();
    }

    @Override // com.coolapk.market.view.video.VideoDetailReplyListFragment.Callback
    public void setDropOffset(int i) {
        FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) this.this$0.getBinding()).commentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentContainer");
        FeedVideoDetailViewPart.access$setCommentViewFraction(this.this$0, ((float) 1) - (((float) i) / ((float) frameLayout.getHeight())));
    }
}
