package com.coolapk.market.view.feedv8;

import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.feedv8.TopicPickFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TopicPickFragment.kt */
final class TopicPickFragment$onActivityCreated$8 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ TopicPickFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicPickFragment$onActivityCreated$8(TopicPickFragment topicPickFragment) {
        super(1);
        this.this$0 = topicPickFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return new TopicPickFragment.DeleteRecentViewHolder(view, new ItemActionHandler(this) {
            /* class com.coolapk.market.view.feedv8.TopicPickFragment$onActivityCreated$8.AnonymousClass1 */
            final /* synthetic */ TopicPickFragment$onActivityCreated$8 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                super.onItemClick(viewHolder, view);
                this.this$0.this$0.atHelper.clear();
                Iterator<Parcelable> it2 = this.this$0.this$0.getDataList().iterator();
                int i = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    }
                    Parcelable next = it2.next();
                    if ((next instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) next).getEntityType(), "holder_title")) {
                        break;
                    }
                    i++;
                }
                for (int i2 = i - 1; i2 >= 1; i2--) {
                    this.this$0.this$0.getDataList().remove(i2);
                }
            }
        });
    }
}
