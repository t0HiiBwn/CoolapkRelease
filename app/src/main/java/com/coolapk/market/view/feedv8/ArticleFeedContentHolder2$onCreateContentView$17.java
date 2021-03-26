package com.coolapk.market.view.feedv8;

import androidx.lifecycle.Observer;
import com.coolapk.market.view.feedv8.ArticleFeedContentHolder2;
import com.coolapk.market.view.feedv8.article.ArticleViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/feedv8/article/ArticleViewModel$ActionType;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedContentHolder2.kt */
final class ArticleFeedContentHolder2$onCreateContentView$17<T> implements Observer<ArticleViewModel.ActionType> {
    final /* synthetic */ ArticleFeedContentHolder2 this$0;

    ArticleFeedContentHolder2$onCreateContentView$17(ArticleFeedContentHolder2 articleFeedContentHolder2) {
        this.this$0 = articleFeedContentHolder2;
    }

    public final void onChanged(ArticleViewModel.ActionType actionType) {
        if (actionType != null) {
            int i = ArticleFeedContentHolder2.WhenMappings.$EnumSwitchMapping$0[actionType.ordinal()];
            if (i == 1) {
                this.this$0.requestCheckSubmittable$presentation_coolapkAppRelease();
            } else if (i == 2) {
                this.this$0.onTextContentChanged();
            } else if (i == 3) {
                this.this$0.requestPickContacts$presentation_coolapkAppRelease();
            } else if (i == 4) {
                List<ArticleModel> value = this.this$0.getArticleViewModel().getDataList().getValue();
                Intrinsics.checkNotNull(value);
                Intrinsics.checkNotNullExpressionValue(value, "articleViewModel.dataList.value!!");
                int i2 = 0;
                Iterator<ArticleModel> it2 = value.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (it2.next() instanceof ArticleText) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    this.this$0.getAdapter().notifyItemChanged(i2, 1);
                }
            }
        }
    }
}
