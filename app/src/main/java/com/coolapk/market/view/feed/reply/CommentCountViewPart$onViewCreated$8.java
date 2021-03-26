package com.coolapk.market.view.feed.reply;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: CommentCountViewPart.kt */
final class CommentCountViewPart$onViewCreated$8 implements View.OnClickListener {
    final /* synthetic */ FeedReplyViewModel $viewModel;
    final /* synthetic */ CommentCountViewPart this$0;

    CommentCountViewPart$onViewCreated$8(CommentCountViewPart commentCountViewPart, FeedReplyViewModel feedReplyViewModel) {
        this.this$0 = commentCountViewPart;
        this.$viewModel = feedReplyViewModel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer value = this.$viewModel.getLoadDataType().getValue();
        if (value != null && value.intValue() == 1) {
            CommentCountViewPart commentCountViewPart = this.this$0;
            Intrinsics.checkNotNullExpressionValue(view, "it");
            commentCountViewPart.showFilterPopMenu(view);
            return;
        }
        this.this$0.getPresenter().switchDataType(1);
    }
}
