package com.coolapk.market.widget.multitype;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.viewholder.BindingViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/widget/multitype/BindingViewHolderFactor;", "Lcom/coolapk/market/widget/multitype/ViewHolderFactor;", "()V", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BindingViewHolderFactor.kt */
public abstract class BindingViewHolderFactor implements ViewHolderFactor {
    @Override // com.coolapk.market.widget.multitype.ViewHolderFactor
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof BindingViewHolder) {
            ((BindingViewHolder) viewHolder).bindTo(obj);
        }
    }
}
