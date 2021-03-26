package com.coolapk.market.view.feed.article;

import com.coolapk.market.view.feedv8.ArticleModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFragmentPresenter.kt */
final class ArticleFragmentPresenter$articleModelList$2 extends Lambda implements Function0<List<? extends ArticleModel>> {
    final /* synthetic */ ArticleFragmentPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFragmentPresenter$articleModelList$2(ArticleFragmentPresenter articleFragmentPresenter) {
        super(0);
        this.this$0 = articleFragmentPresenter;
    }

    /* Return type fixed from 'java.util.List<com.coolapk.market.view.feedv8.ArticleModel>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends ArticleModel> invoke() {
        ArticleModel.Companion companion = ArticleModel.Companion;
        String messageRawOutput = this.this$0.getFeed().getMessageRawOutput();
        if (messageRawOutput == null) {
            messageRawOutput = "";
        }
        return companion.fromJson(messageRawOutput);
    }
}
