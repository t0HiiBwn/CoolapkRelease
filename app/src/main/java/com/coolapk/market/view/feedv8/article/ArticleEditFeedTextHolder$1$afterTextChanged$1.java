package com.coolapk.market.view.feedv8.article;

import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleText;
import com.coolapk.market.view.feedv8.article.ArticleEditFeedTextHolder;
import com.coolapk.market.view.feedv8.util.ArticleEditText;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "it", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleEditFeedTextHolder.kt */
final class ArticleEditFeedTextHolder$1$afterTextChanged$1 extends Lambda implements Function1<ArticleModel, ArticleModel> {
    final /* synthetic */ ArticleEditFeedTextHolder.AnonymousClass1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleEditFeedTextHolder$1$afterTextChanged$1(ArticleEditFeedTextHolder.AnonymousClass1 r1) {
        super(1);
        this.this$0 = r1;
    }

    public final ArticleModel invoke(ArticleModel articleModel) {
        Intrinsics.checkNotNullParameter(articleModel, "it");
        ArticleEditText articleEditText = r4.etTitle;
        Intrinsics.checkNotNullExpressionValue(articleEditText, "binding.etTitle");
        return ((ArticleText) articleModel).copy(String.valueOf(articleEditText.getText()));
    }
}
