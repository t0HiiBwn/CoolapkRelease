package com.coolapk.market.view.feed.reply;

import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedCommentCountViewPartBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/feed/reply/CommentCountViewPart$onViewCreated$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CommentCountViewPart.kt */
public final class CommentCountViewPart$onViewCreated$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ CommentCountViewPart this$0;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CommentCountViewPart$onViewCreated$1(CommentCountViewPart commentCountViewPart) {
        this.this$0 = commentCountViewPart;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        FrameLayout frameLayout = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).fixTopView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fixTopView");
        if (Intrinsics.areEqual(frameLayout.getParent(), ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).cardView)) {
            View view2 = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).dividerView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.dividerView");
            view2.setAlpha(0.0f);
            FrameLayout frameLayout2 = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).fixTopView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.fixTopView");
            frameLayout2.setBackground(null);
            return;
        }
        View view3 = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).dividerView;
        Intrinsics.checkNotNullExpressionValue(view3, "binding.dividerView");
        view3.setAlpha(1.0f);
        ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).fixTopView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
    }
}
