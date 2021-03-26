package com.coolapk.market.view.feedv8;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import com.coolapk.market.widget.SimpleDiffCallback;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedBaseContentHolder.kt */
final class ArticleFeedBaseContentHolder$onCreateContentView$2<T> implements Observer<List<ArticleModel>> {
    final /* synthetic */ ArticleFeedBaseContentHolder this$0;

    ArticleFeedBaseContentHolder$onCreateContentView$2(ArticleFeedBaseContentHolder articleFeedBaseContentHolder) {
        this.this$0 = articleFeedBaseContentHolder;
    }

    public final void onChanged(List<ArticleModel> list) {
        List mutableList = CollectionsKt.toMutableList((Collection) ArticleFeedBaseContentHolder.access$getDataList$p(this.this$0));
        ArticleFeedBaseContentHolder.access$getDataList$p(this.this$0).clear();
        List access$getDataList$p = ArticleFeedBaseContentHolder.access$getDataList$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(list, "it");
        access$getDataList$p.addAll(list);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SimpleDiffCallback(mutableList, list), true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(S…back(tempList, it), true)");
        calculateDiff.dispatchUpdatesTo(this.this$0.getAdapter());
    }
}
