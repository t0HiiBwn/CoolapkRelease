package com.coolapk.market.view.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.search.SecondhandDealTypeListFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/search/SecondhandDealTypeListFragment$DataAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondhandDealTypeListFragment.kt */
public final class SecondhandDealTypeListFragment$DataAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ SecondhandDealTypeListFragment.DataAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SecondhandDealTypeListFragment$DataAdapter$onCreateViewHolder$1(SecondhandDealTypeListFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        super.onItemClick(viewHolder, view);
        int adapterPosition = viewHolder.getAdapterPosition();
        SecondhandDealTypeListFragment.access$getViewModel$p(SecondhandDealTypeListFragment.this).setDealTypeText((String) ((Pair) SecondhandDealTypeListFragment.access$getDataList$p(SecondhandDealTypeListFragment.this).get(adapterPosition)).getSecond());
        SecondhandDealTypeListFragment.access$getViewModel$p(SecondhandDealTypeListFragment.this).setDealType((String) ((Pair) SecondhandDealTypeListFragment.access$getDataList$p(SecondhandDealTypeListFragment.this).get(adapterPosition)).getFirst());
    }
}
