package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.ImageUrl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/ImageUrl;", "it", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedContentHolder2.kt */
final class ArticleFeedContentHolder2$prepareMultiFeed$imageList$1 extends Lambda implements Function1<ArticleModel, ImageUrl> {
    public static final ArticleFeedContentHolder2$prepareMultiFeed$imageList$1 INSTANCE = new ArticleFeedContentHolder2$prepareMultiFeed$imageList$1();

    ArticleFeedContentHolder2$prepareMultiFeed$imageList$1() {
        super(1);
    }

    public final ImageUrl invoke(ArticleModel articleModel) {
        Intrinsics.checkNotNullParameter(articleModel, "it");
        boolean z = true;
        if (articleModel instanceof ArticleNative) {
            ArticleNative articleNative = (ArticleNative) articleModel;
            if (articleNative.getImageUrl().length() > 0) {
                return ImageUrl.create(articleNative.getImageUrl(), articleNative.getImageUrl(), "feed_cover");
            }
        }
        if (articleModel instanceof ArticleImage) {
            ArticleImage articleImage = (ArticleImage) articleModel;
            if (articleImage.getImageUrl().length() <= 0) {
                z = false;
            }
            if (z) {
                return ImageUrl.create(articleImage.getImageUrl(), articleImage.getImageUrl());
            }
        }
        return null;
    }
}
