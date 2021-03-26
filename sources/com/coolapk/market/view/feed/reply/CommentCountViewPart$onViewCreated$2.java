package com.coolapk.market.view.feed.reply;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.coolapk.market.databinding.FeedCommentCountViewPartBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: CommentCountViewPart.kt */
final class CommentCountViewPart$onViewCreated$2<T> implements Observer<Integer> {
    final /* synthetic */ CommentCountViewPart this$0;

    CommentCountViewPart$onViewCreated$2(CommentCountViewPart commentCountViewPart) {
        this.this$0 = commentCountViewPart;
    }

    public final void onChanged(Integer num) {
        TextView textView = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).forwardView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.forwardView");
        CommentCountViewPart commentCountViewPart = this.this$0;
        String string = commentCountViewPart.getContext().getString(2131886851);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.str_feed_item_forward)");
        Intrinsics.checkNotNullExpressionValue(num, "it");
        textView.setText(commentCountViewPart.getLabelTitle(string, num.intValue()));
    }
}
