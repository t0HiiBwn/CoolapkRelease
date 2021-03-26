package com.coolapk.market.view.feedv8.article;

import android.widget.RatingBar;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/RatingBar;", "kotlin.jvm.PlatformType", "rating", "", "fromUser", "", "onRatingChanged", "com/coolapk/market/view/feedv8/article/ArticleEditProductTopHolder$5$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleEditProductTopHolder.kt */
final class ArticleEditProductTopHolder$$special$$inlined$apply$lambda$1 implements RatingBar.OnRatingBarChangeListener {
    final /* synthetic */ ArticleEditProductTopHolder this$0;

    ArticleEditProductTopHolder$$special$$inlined$apply$lambda$1(ArticleEditProductTopHolder articleEditProductTopHolder) {
        this.this$0 = articleEditProductTopHolder;
    }

    @Override // android.widget.RatingBar.OnRatingBarChangeListener
    public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        this.this$0.updateRatingScore((int) f);
    }
}
