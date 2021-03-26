package com.coolapk.market.view.feed.reply;

import android.view.ViewTreeObserver;
import com.coolapk.market.databinding.FeedCommentCountViewPartBinding;
import com.coolapk.market.widget.view.SimpleIndicatorView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/feed/reply/CommentCountViewPart$onBindToContent$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CommentCountViewPart.kt */
public final class CommentCountViewPart$onBindToContent$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ CommentCountViewPart this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CommentCountViewPart$onBindToContent$1(CommentCountViewPart commentCountViewPart) {
        this.this$0 = commentCountViewPart;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        SimpleIndicatorView simpleIndicatorView = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).indicatorView;
        Intrinsics.checkNotNullExpressionValue(simpleIndicatorView, "binding.indicatorView");
        simpleIndicatorView.getViewTreeObserver().removeOnPreDrawListener(this);
        CommentCountViewPart.access$checkIndicatorOffset(this.this$0);
        return true;
    }
}
