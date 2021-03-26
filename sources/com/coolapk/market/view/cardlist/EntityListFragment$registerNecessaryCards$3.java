package com.coolapk.market.view.cardlist;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.ProgressHintViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$registerNecessaryCards$3 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ EntityListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$registerNecessaryCards$3(EntityListFragment entityListFragment) {
        super(1);
        this.this$0 = entityListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return new ProgressHintViewHolder(view, this.this$0.getBindingComponent(), new ItemActionHandler(this) {
            /* class com.coolapk.market.view.cardlist.EntityListFragment$registerNecessaryCards$3.AnonymousClass1 */
            final /* synthetic */ EntityListFragment$registerNecessaryCards$3 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Function0 function0;
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                super.onItemClick(viewHolder, view);
                int id = view.getId();
                if ((id == 2131362323 || id == 2131362457) && (function0 = this.this$0.this$0.onProgressViewClickListener) != null) {
                    function0.invoke();
                }
            }
        });
    }
}
