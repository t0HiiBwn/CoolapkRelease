package com.coolapk.market.view.feed.reply;

import android.view.View;
import com.coolapk.market.databinding.ItemArticleDetailTopBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedTopViewHolder.kt */
final class ArticleFeedTopViewHolder$doCoverAnim$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ArticleFeedTopViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFeedTopViewHolder$doCoverAnim$2(ArticleFeedTopViewHolder articleFeedTopViewHolder) {
        super(0);
        this.this$0 = articleFeedTopViewHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        View view = ((ItemArticleDetailTopBinding) this.this$0.getBinding()).coverViewMask;
        Intrinsics.checkNotNullExpressionValue(view, "binding.coverViewMask");
        view.setVisibility(8);
    }
}
