package com.coolapk.market.view.feedv8;

import androidx.lifecycle.Observer;
import com.coolapk.market.view.feedv8.article.ArticleViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/feedv8/article/ArticleViewModel$ActionType;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedBaseContentHolder.kt */
final class ArticleFeedBaseContentHolder$onCreateContentView$3<T> implements Observer<ArticleViewModel.ActionType> {
    final /* synthetic */ ArticleFeedBaseContentHolder this$0;

    ArticleFeedBaseContentHolder$onCreateContentView$3(ArticleFeedBaseContentHolder articleFeedBaseContentHolder) {
        this.this$0 = articleFeedBaseContentHolder;
    }

    public final void onChanged(ArticleViewModel.ActionType actionType) {
        if (actionType == ArticleViewModel.ActionType.UpdateListSilently) {
            ArticleFeedBaseContentHolder.access$getDataList$p(this.this$0).clear();
            List access$getDataList$p = ArticleFeedBaseContentHolder.access$getDataList$p(this.this$0);
            List<ArticleModel> value = this.this$0.getArticleViewModel().getDataList().getValue();
            Intrinsics.checkNotNull(value);
            Intrinsics.checkNotNullExpressionValue(value, "articleViewModel.dataList.value!!");
            access$getDataList$p.addAll(value);
        }
    }
}
