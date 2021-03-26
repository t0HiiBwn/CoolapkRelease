package com.coolapk.market.extend;

import com.coolapk.market.view.feedv8.ArticleImage;
import com.coolapk.market.view.feedv8.ArticleModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityExtends.kt */
final class EntityExtendsKt$getHtmlPicArray$result$2 extends Lambda implements Function1<ArticleModel, String> {
    public static final EntityExtendsKt$getHtmlPicArray$result$2 INSTANCE = new EntityExtendsKt$getHtmlPicArray$result$2();

    EntityExtendsKt$getHtmlPicArray$result$2() {
        super(1);
    }

    public final String invoke(ArticleModel articleModel) {
        Intrinsics.checkNotNullParameter(articleModel, "it");
        return ((ArticleImage) articleModel).getImageUrl();
    }
}
