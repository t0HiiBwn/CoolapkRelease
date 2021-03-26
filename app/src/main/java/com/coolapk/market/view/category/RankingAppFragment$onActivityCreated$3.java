package com.coolapk.market.view.category;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.category.RankingAppFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RankingAppFragment.kt */
final class RankingAppFragment$onActivityCreated$3 extends Lambda implements Function2<RecyclerView.ViewHolder, Object, Unit> {
    final /* synthetic */ RankingAppFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RankingAppFragment$onActivityCreated$3(RankingAppFragment rankingAppFragment) {
        super(2);
        this.this$0 = rankingAppFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder, Object obj) {
        invoke(viewHolder, obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RecyclerView.ViewHolder viewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        RankingAppFragment.RankTypeViewHolder rankTypeViewHolder = (RankingAppFragment.RankTypeViewHolder) viewHolder;
        rankTypeViewHolder.setRankType(RankingAppFragment.access$getRankType$p(this.this$0));
        rankTypeViewHolder.setResetRankTypeFunc(new Function1<String, Unit>(this) {
            /* class com.coolapk.market.view.category.RankingAppFragment$onActivityCreated$3.AnonymousClass1 */
            final /* synthetic */ RankingAppFragment$onActivityCreated$3 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke(str);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                this.this$0.this$0.resetRankType(str);
            }
        });
    }
}
