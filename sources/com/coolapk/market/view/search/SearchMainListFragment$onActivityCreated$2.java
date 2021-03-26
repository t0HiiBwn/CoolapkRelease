package com.coolapk.market.view.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.SearchHistoryViewHolder;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchMainListFragment.kt */
final class SearchMainListFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ SearchMainListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchMainListFragment$onActivityCreated$2(SearchMainListFragment searchMainListFragment) {
        super(1);
        this.this$0 = searchMainListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new SearchHistoryViewHolder(view, this.this$0.historyDataSet, this.this$0.historyLines, this.this$0.showAllHistory, new ItemActionHandler(this) {
            /* class com.coolapk.market.view.search.SearchMainListFragment$onActivityCreated$2.AnonymousClass1 */
            final /* synthetic */ SearchMainListFragment$onActivityCreated$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                int id = view.getId();
                if (id == 2131362257) {
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    instance.getDataBase().delete("searchHistory", null, new String[0]);
                    this.this$0.this$0.loadHistory();
                } else if (id == 2131363587) {
                    this.this$0.this$0.showAllHistory.set(!this.this$0.this$0.showAllHistory.get());
                    this.this$0.this$0.loadHistory();
                }
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                if (view.getId() == 2131362768) {
                    Object tag = view.getTag();
                    Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
                    String[] strArr = {(String) tag};
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    instance.getDataBase().delete("searchHistory", "keyword=?", (String[]) Arrays.copyOf(strArr, 1));
                    this.this$0.this$0.loadHistory();
                }
                return super.onItemLongClick(viewHolder, view);
            }
        }, null, 32, null);
    }
}
