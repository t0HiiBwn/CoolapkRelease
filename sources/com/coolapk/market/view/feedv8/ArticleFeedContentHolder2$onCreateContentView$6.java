package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.FeedGoods;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedContentHolder2.kt */
final class ArticleFeedContentHolder2$onCreateContentView$6 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ ArticleFeedContentHolder2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFeedContentHolder2$onCreateContentView$6(ArticleFeedContentHolder2 articleFeedContentHolder2) {
        super(1);
        this.this$0 = articleFeedContentHolder2;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        return (!(obj instanceof ArticleCard) || !(this.this$0.getArticleViewModel().getUrlEntityMap().get(((ArticleCard) obj).getUrlKey()) instanceof FeedGoods)) ? null : 1;
    }
}
