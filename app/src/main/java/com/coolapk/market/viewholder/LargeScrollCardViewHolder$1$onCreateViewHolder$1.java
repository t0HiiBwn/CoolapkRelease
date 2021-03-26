package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.viewholder.LargeScrollCardViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/LargeScrollCardViewHolder$1$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/LargeScrollCardGoodsItemViewHolder;", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LargeScrollCardViewHolder.kt */
public final class LargeScrollCardViewHolder$1$onCreateViewHolder$1 extends LargeScrollCardGoodsItemViewHolder {
    final /* synthetic */ TitleRecycleViewCardViewHolder $holder;
    final /* synthetic */ View $view;
    final /* synthetic */ LargeScrollCardViewHolder.AnonymousClass1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LargeScrollCardViewHolder$1$onCreateViewHolder$1(LargeScrollCardViewHolder.AnonymousClass1 r1, TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, View view, View view2, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        super(view2, dataBindingComponent, entityListPresenter);
        this.this$0 = r1;
        this.$holder = titleRecycleViewCardViewHolder;
        this.$view = view;
    }

    @Override // com.coolapk.market.viewholder.LargeScrollCardGoodsItemViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        super.bindTo(obj);
        setParentCard(this.$holder.getCard());
        setParentViewHolder(this.$holder);
    }
}
