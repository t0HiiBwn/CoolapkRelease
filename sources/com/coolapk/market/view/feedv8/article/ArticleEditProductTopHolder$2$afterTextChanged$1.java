package com.coolapk.market.view.feedv8.article;

import android.text.Editable;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleNative;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "it", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleEditProductTopHolder.kt */
final class ArticleEditProductTopHolder$2$afterTextChanged$1 extends Lambda implements Function1<ArticleModel, ArticleModel> {
    final /* synthetic */ Editable $s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleEditProductTopHolder$2$afterTextChanged$1(Editable editable) {
        super(1);
        this.$s = editable;
    }

    public final ArticleModel invoke(ArticleModel articleModel) {
        Intrinsics.checkNotNullParameter(articleModel, "it");
        return ArticleNative.copy$default((ArticleNative) articleModel, null, null, this.$s.toString(), 3, null);
    }
}
