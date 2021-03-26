package com.coolapk.market.view.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.search.AppSortListFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/search/AppSortListFragment$DataAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppSortListFragment.kt */
public final class AppSortListFragment$DataAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ AppSortListFragment.DataAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppSortListFragment$DataAdapter$onCreateViewHolder$1(AppSortListFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        super.onItemClick(viewHolder, view);
        String access$getApkType$p = AppSortListFragment.access$getApkType$p(AppSortListFragment.this);
        int hashCode = access$getApkType$p.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && access$getApkType$p.equals("2")) {
                AppSortListFragment.access$getViewModel$p(AppSortListFragment.this).setGameSort((String) ((Pair) AppSortListFragment.access$getDataList$p(AppSortListFragment.this).get(viewHolder.getAdapterPosition())).getFirst());
            }
        } else if (access$getApkType$p.equals("1")) {
            AppSortListFragment.access$getViewModel$p(AppSortListFragment.this).setAppSort((String) ((Pair) AppSortListFragment.access$getDataList$p(AppSortListFragment.this).get(viewHolder.getAdapterPosition())).getFirst());
        }
    }
}
