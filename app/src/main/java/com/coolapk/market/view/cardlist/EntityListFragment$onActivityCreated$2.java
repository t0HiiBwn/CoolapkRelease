package com.coolapk.market.view.cardlist;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.viewholder.iview.Recyclable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onViewRecycled"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$onActivityCreated$2 implements RecyclerView.RecyclerListener {
    public static final EntityListFragment$onActivityCreated$2 INSTANCE = new EntityListFragment$onActivityCreated$2();

    EntityListFragment$onActivityCreated$2() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof Recyclable) {
            ((Recyclable) viewHolder).onRecycled();
        }
    }
}
