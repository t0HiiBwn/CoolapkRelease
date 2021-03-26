package com.coolapk.market.view.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.viewholder.FeedFilterViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$onActivityCreated$4 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ SuperSearchFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuperSearchFragment$onActivityCreated$4(SuperSearchFragment superSearchFragment) {
        super(1);
        this.this$0 = superSearchFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new FeedFilterViewHolder(view, SuperSearchFragment.access$getViewModel$p(this.this$0), this.this$0.feedPageType, new ItemActionHandler() {
            /* class com.coolapk.market.view.search.SuperSearchFragment$onActivityCreated$4.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                super.onItemClick(viewHolder, view);
            }
        });
    }
}
