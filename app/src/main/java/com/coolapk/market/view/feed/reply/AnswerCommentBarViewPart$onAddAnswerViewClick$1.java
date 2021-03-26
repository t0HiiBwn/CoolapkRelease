package com.coolapk.market.view.feed.reply;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.coolapk.market.databinding.FeedAnswerViewPartBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: AnswerCommentBarViewPart.kt */
final class AnswerCommentBarViewPart$onAddAnswerViewClick$1 implements Action0 {
    final /* synthetic */ AnswerCommentBarViewPart this$0;

    AnswerCommentBarViewPart$onAddAnswerViewClick$1(AnswerCommentBarViewPart answerCommentBarViewPart) {
        this.this$0 = answerCommentBarViewPart;
    }

    @Override // rx.functions.Action0
    public final void call() {
        AnswerCommentBarViewPart.access$setCheckAnswerCount$p(this.this$0, false);
        LinearLayout linearLayout = ((FeedAnswerViewPartBinding) this.this$0.getBinding()).addAnswerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addAnswerView");
        linearLayout.setClickable(true);
        ImageView imageView = ((FeedAnswerViewPartBinding) this.this$0.getBinding()).addAnswerImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.addAnswerImage");
        imageView.setVisibility(0);
        TextView textView = ((FeedAnswerViewPartBinding) this.this$0.getBinding()).addAnswerText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.addAnswerText");
        textView.setVisibility(0);
        ProgressBar progressBar = ((FeedAnswerViewPartBinding) this.this$0.getBinding()).addAnswerProgress;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.addAnswerProgress");
        progressBar.setVisibility(8);
    }
}
