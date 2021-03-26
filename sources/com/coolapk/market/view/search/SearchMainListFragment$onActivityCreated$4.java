package com.coolapk.market.view.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.SearchHotViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchMainListFragment.kt */
final class SearchMainListFragment$onActivityCreated$4 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ SearchMainListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchMainListFragment$onActivityCreated$4(SearchMainListFragment searchMainListFragment) {
        super(1);
        this.this$0 = searchMainListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new SearchHotViewHolder(view, new FragmentBindingComponent(this.this$0), new ItemActionHandler(this) {
            /* class com.coolapk.market.view.search.SearchMainListFragment$onActivityCreated$4.AnonymousClass1 */
            final /* synthetic */ SearchMainListFragment$onActivityCreated$4 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                if (view.getId() == 2131363223) {
                    this.this$0.this$0.shouldRefresh = true;
                    this.this$0.this$0.setPage(1);
                    this.this$0.this$0.reloadData();
                    StatisticHelper.Companion.getInstance().recordEvent("V9新搜索界面", "换一换");
                }
            }
        });
    }
}