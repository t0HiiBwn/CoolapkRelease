package com.coolapk.market.view.feedv8.article;

import com.coolapk.market.view.feedv8.ArticleCard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/feedv8/ArticleCard;", "Lkotlin/internal/NoInfer;", "invoke", "com/coolapk/market/view/feedv8/article/ArticleViewModel$removeEntityByUrl$1$count$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleViewModel.kt */
final class ArticleViewModel$removeEntityByUrl$$inlined$let$lambda$1 extends Lambda implements Function1<ArticleCard, Boolean> {
    final /* synthetic */ String $url$inlined;
    final /* synthetic */ ArticleViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleViewModel$removeEntityByUrl$$inlined$let$lambda$1(ArticleViewModel articleViewModel, String str) {
        super(1);
        this.this$0 = articleViewModel;
        this.$url$inlined = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ArticleCard articleCard) {
        return Boolean.valueOf(invoke(articleCard));
    }

    public final boolean invoke(ArticleCard articleCard) {
        Intrinsics.checkNotNullParameter(articleCard, "it");
        return Intrinsics.areEqual(articleCard.getUrlKey(), this.$url$inlined);
    }
}
