package com.coolapk.market.view.feed.reply;

import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.FeedCommentCountViewPartBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: CommentCountViewPart.kt */
final class CommentCountViewPart$onViewCreated$5<T> implements Observer<Integer> {
    final /* synthetic */ CommentCountViewPart this$0;

    CommentCountViewPart$onViewCreated$5(CommentCountViewPart commentCountViewPart) {
        this.this$0 = commentCountViewPart;
    }

    public final void onChanged(Integer num) {
        AppTheme appTheme = AppHolder.getAppTheme();
        if (num != null && num.intValue() == 1) {
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).forwardView.setTextColor(appTheme.getTextColorSecondary());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).likeView.setTextColor(appTheme.getTextColorSecondary());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterTextView.setTextColor(appTheme.getColorAccent());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterImageView.setColorFilter(appTheme.getColorAccent());
            ImageView imageView = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.filterImageView");
            imageView.setVisibility(0);
        } else if (num != null && num.intValue() == 2) {
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).forwardView.setTextColor(appTheme.getColorAccent());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).likeView.setTextColor(appTheme.getTextColorSecondary());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterTextView.setTextColor(appTheme.getTextColorSecondary());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterImageView.setColorFilter(appTheme.getTextColorSecondary());
            ImageView imageView2 = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterImageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.filterImageView");
            imageView2.setVisibility(8);
        } else if (num != null && num.intValue() == 0) {
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).forwardView.setTextColor(appTheme.getTextColorSecondary());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).likeView.setTextColor(appTheme.getColorAccent());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterTextView.setTextColor(appTheme.getTextColorSecondary());
            ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterImageView.setColorFilter(appTheme.getTextColorSecondary());
            ImageView imageView3 = ((FeedCommentCountViewPartBinding) this.this$0.getBinding()).filterImageView;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.filterImageView");
            imageView3.setVisibility(8);
        }
        this.this$0.checkIndicatorOffset();
    }
}
