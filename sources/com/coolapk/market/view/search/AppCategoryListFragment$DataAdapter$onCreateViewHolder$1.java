package com.coolapk.market.view.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.search.AppCategoryListFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/search/AppCategoryListFragment$DataAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppCategoryListFragment.kt */
public final class AppCategoryListFragment$DataAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ AppCategoryListFragment.DataAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppCategoryListFragment$DataAdapter$onCreateViewHolder$1(AppCategoryListFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        super.onItemClick(viewHolder, view);
        if (viewHolder.getAdapterPosition() == 0) {
            str = "";
        } else {
            Object obj = AppCategoryListFragment.access$getDataList$p(AppCategoryListFragment.this).get(viewHolder.getAdapterPosition() - 1);
            Intrinsics.checkNotNullExpressionValue(obj, "dataList[holder.adapterPosition - 1]");
            str = ((Entity) obj).getId();
            Intrinsics.checkNotNull(str);
        }
        String access$getApkType$p = AppCategoryListFragment.access$getApkType$p(AppCategoryListFragment.this);
        int hashCode = access$getApkType$p.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && access$getApkType$p.equals("2")) {
                AppCategoryListFragment.access$getViewModel$p(AppCategoryListFragment.this).setGameCat(str);
            }
        } else if (access$getApkType$p.equals("1")) {
            AppCategoryListFragment.access$getViewModel$p(AppCategoryListFragment.this).setAppCat(str);
        }
    }
}
