package com.coolapk.market.view.collectionList;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CollectionSelectFragment.kt */
final class CollectionSelectFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ CollectionSelectFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionSelectFragment$onActivityCreated$2(CollectionSelectFragment collectionSelectFragment) {
        super(1);
        this.this$0 = collectionSelectFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        TextView access$getDoneView$p = CollectionSelectFragment.access$getDoneView$p(this.this$0);
        LinkedHashMap access$getCollectionMap$p = CollectionSelectFragment.access$getCollectionMap$p(this.this$0);
        Intrinsics.checkNotNull(access$getCollectionMap$p);
        return new CollectionSelectViewHolder(access$getDoneView$p, access$getCollectionMap$p, CollectionSelectFragment.access$getCancelMap$p(this.this$0), CollectionSelectFragment.access$getComponent$p(this.this$0), view, null);
    }
}
