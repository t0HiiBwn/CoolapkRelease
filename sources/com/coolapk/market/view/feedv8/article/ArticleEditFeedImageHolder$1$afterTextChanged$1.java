package com.coolapk.market.view.feedv8.article;

import android.widget.EditText;
import com.coolapk.market.view.feedv8.ArticleImage;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.article.ArticleEditFeedImageHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "it", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleEditFeedImageHolder.kt */
final class ArticleEditFeedImageHolder$1$afterTextChanged$1 extends Lambda implements Function1<ArticleModel, ArticleModel> {
    final /* synthetic */ ArticleEditFeedImageHolder.AnonymousClass1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleEditFeedImageHolder$1$afterTextChanged$1(ArticleEditFeedImageHolder.AnonymousClass1 r1) {
        super(1);
        this.this$0 = r1;
    }

    public final ArticleModel invoke(ArticleModel articleModel) {
        Intrinsics.checkNotNullParameter(articleModel, "it");
        EditText editText = r3.descriptionView;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.descriptionView");
        return ArticleImage.copy$default((ArticleImage) articleModel, null, editText.getText().toString(), 1, null);
    }
}
