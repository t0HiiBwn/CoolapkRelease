package com.coolapk.market.view.main;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.main.RankFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RankFragment.kt */
final class RankFragment$onActivityCreated$1 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ RankFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RankFragment$onActivityCreated$1(RankFragment rankFragment) {
        super(1);
        this.this$0 = rankFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new RankFragment.RankHeaderViewHolder(view, new ItemActionHandler(this) {
            /* class com.coolapk.market.view.main.RankFragment$onActivityCreated$1.AnonymousClass1 */
            final /* synthetic */ RankFragment$onActivityCreated$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                switch (view.getId()) {
                    case 2131362251:
                        this.this$0.this$0.apkType = "0";
                        break;
                    case 2131362252:
                        this.this$0.this$0.apkType = "1";
                        break;
                    case 2131362253:
                        this.this$0.this$0.apkType = "2";
                        break;
                }
                this.this$0.this$0.reloadData();
            }
        });
    }
}
