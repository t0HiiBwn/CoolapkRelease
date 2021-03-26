package com.coolapk.market.view.feed.question;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: QuestionDetailViewHolder.kt */
final class QuestionDetailViewHolder$bindToContent$1 implements View.OnClickListener {
    final /* synthetic */ QuestionDetailViewHolder this$0;

    QuestionDetailViewHolder$bindToContent$1(QuestionDetailViewHolder questionDetailViewHolder) {
        this.this$0 = questionDetailViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        QuestionDetailViewHolder questionDetailViewHolder = this.this$0;
        questionDetailViewHolder.showMaxWords = !questionDetailViewHolder.showMaxWords;
        this.this$0.setContentMessage();
    }
}
