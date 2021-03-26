package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/TextLinkListCardViewHolder$1$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/TextLinkListItemViewHolder;", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextLinkListCardViewHolder.kt */
public final class TextLinkListCardViewHolder$1$onCreateViewHolder$1 extends TextLinkListItemViewHolder {
    final /* synthetic */ TitleRecycleViewCardViewHolder $holder;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextLinkListCardViewHolder$1$onCreateViewHolder$1(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, View view, View view2, DataBindingComponent dataBindingComponent) {
        super(view2, dataBindingComponent);
        this.$holder = titleRecycleViewCardViewHolder;
        this.$view = view;
    }

    @Override // com.coolapk.market.viewholder.TextLinkListItemViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        super.bindTo(obj);
        setParentCard(this.$holder.getCard());
        setParentViewHolder(this.$holder);
    }
}
