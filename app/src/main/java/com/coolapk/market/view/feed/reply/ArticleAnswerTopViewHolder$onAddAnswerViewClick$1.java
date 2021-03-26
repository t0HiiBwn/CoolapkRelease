package com.coolapk.market.view.feed.reply;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemArticleDetailAnswerTopBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleAnswerTopViewHolder.kt */
final class ArticleAnswerTopViewHolder$onAddAnswerViewClick$1 implements Action0 {
    final /* synthetic */ ArticleAnswerTopViewHolder this$0;

    ArticleAnswerTopViewHolder$onAddAnswerViewClick$1(ArticleAnswerTopViewHolder articleAnswerTopViewHolder) {
        this.this$0 = articleAnswerTopViewHolder;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.this$0.isCheckAnswerCount = false;
        LinearLayout linearLayout = ((ItemArticleDetailAnswerTopBinding) this.this$0.getBinding()).addAnswerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addAnswerView");
        linearLayout.setClickable(true);
        ImageView imageView = ((ItemArticleDetailAnswerTopBinding) this.this$0.getBinding()).addAnswerImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.addAnswerImage");
        imageView.setVisibility(0);
        TextView textView = ((ItemArticleDetailAnswerTopBinding) this.this$0.getBinding()).addAnswerText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.addAnswerText");
        textView.setVisibility(0);
        ProgressBar progressBar = ((ItemArticleDetailAnswerTopBinding) this.this$0.getBinding()).addAnswerProgress;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.addAnswerProgress");
        progressBar.setVisibility(8);
    }
}
