package com.coolapk.market.view.feedv8.article;

import android.view.View;
import com.coolapk.market.view.feedv8.ArticleCard;
import com.coolapk.market.view.feedv8.ArticleModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleEditGoodsCardViewHolder.kt */
final class ArticleEditGoodsCardViewHolder$bindTo$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ArticleCard $card;
    final /* synthetic */ ArticleEditGoodsCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleEditGoodsCardViewHolder$bindTo$1(ArticleEditGoodsCardViewHolder articleEditGoodsCardViewHolder, ArticleCard articleCard) {
        super(1);
        this.this$0 = articleEditGoodsCardViewHolder;
        this.$card = articleCard;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.this$0.getViewModel().getUrlEntityMap().remove(this.$card.getUrlKey());
        ArticleViewModel.updateDataList$default(this.this$0.getViewModel(), false, false, new Function1<List<ArticleModel>, Unit>(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditGoodsCardViewHolder$bindTo$1.AnonymousClass1 */
            final /* synthetic */ ArticleEditGoodsCardViewHolder$bindTo$1 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<ArticleModel> list) {
                invoke(list);
                return Unit.INSTANCE;
            }

            public final void invoke(List<ArticleModel> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                if (Intrinsics.areEqual((ArticleModel) CollectionsKt.getOrNull(list, this.this$0.this$0.getAdapterPosition()), this.this$0.$card)) {
                    list.remove(this.this$0.this$0.getAdapterPosition());
                }
            }
        }, 3, null);
    }
}
