package com.coolapk.market.view.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.search.SecondhandSortListFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/search/SecondhandSortListFragment$DataAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondhandSortListFragment.kt */
public final class SecondhandSortListFragment$DataAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ SecondhandSortListFragment.DataAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SecondhandSortListFragment$DataAdapter$onCreateViewHolder$1(SecondhandSortListFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0074, code lost:
        if (r0.equals("sell_price_down") != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007d, code lost:
        if (r0.equals("buy_price_up") != false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0086, code lost:
        if (r0.equals("buy_price_down") != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0088, code lost:
        r0 = "priceUp";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0091, code lost:
        if (r0.equals("sell_price_up") != false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0093, code lost:
        r0 = "priceDown";
     */
    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        super.onItemClick(viewHolder, view);
        int adapterPosition = viewHolder.getAdapterPosition();
        int index = SecondhandSortListFragment.this.getIndex();
        if (index == 0) {
            SecondhandSortListFragment.access$getViewModel$p(SecondhandSortListFragment.this).setDealTypeText((String) ((Pair) SecondhandSortListFragment.access$getDataList$p(SecondhandSortListFragment.this).get(adapterPosition)).getSecond());
            SecondhandSortListFragment.access$getViewModel$p(SecondhandSortListFragment.this).setDealType((String) ((Pair) SecondhandSortListFragment.access$getDataList$p(SecondhandSortListFragment.this).get(adapterPosition)).getFirst());
        } else if (index == 1) {
            SecondhandSortListFragment.access$getViewModel$p(SecondhandSortListFragment.this).setSecondHandSort((String) ((Pair) SecondhandSortListFragment.access$getDataList$p(SecondhandSortListFragment.this).get(adapterPosition)).getFirst());
        } else if (index == 2) {
            SecondhandSortListFragment.access$getViewModel$p(SecondhandSortListFragment.this).setSecondHandOther((String) ((Pair) SecondhandSortListFragment.access$getDataList$p(SecondhandSortListFragment.this).get(adapterPosition)).getFirst());
        } else if (index == 3) {
            SuperSearchViewModel access$getViewModel$p = SecondhandSortListFragment.access$getViewModel$p(SecondhandSortListFragment.this);
            String str2 = (String) ((Pair) SecondhandSortListFragment.access$getDataList$p(SecondhandSortListFragment.this).get(adapterPosition)).getFirst();
            switch (str2.hashCode()) {
                case -861417570:
                    break;
                case 90257713:
                    break;
                case 880540394:
                    break;
                case 1105899749:
                    break;
                default:
                    str = (String) ((Pair) SecondhandSortListFragment.access$getDataList$p(SecondhandSortListFragment.this).get(adapterPosition)).getFirst();
                    break;
            }
            access$getViewModel$p.setSecondHandSort(str);
            SecondhandSortListFragment.access$getViewModel$p(SecondhandSortListFragment.this).setSecondHandChangeSort((String) ((Pair) SecondhandSortListFragment.access$getDataList$p(SecondhandSortListFragment.this).get(adapterPosition)).getFirst());
        } else if (index == 4) {
            SecondhandSortListFragment.access$getViewModel$p(SecondhandSortListFragment.this).setSecondHandFilterInBuy((String) ((Pair) SecondhandSortListFragment.access$getDataList$p(SecondhandSortListFragment.this).get(adapterPosition)).getFirst());
        }
    }
}
