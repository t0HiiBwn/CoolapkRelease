package com.coolapk.market.view.feed.pick;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemNodePickItemBinding;
import com.coolapk.market.model.Entity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "any", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodePickRecentListFragment.kt */
final class NodePickRecentListFragment$onActivityCreated$3 extends Lambda implements Function2<RecyclerView.ViewHolder, Object, Unit> {
    final /* synthetic */ NodePickRecentListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodePickRecentListFragment$onActivityCreated$3(NodePickRecentListFragment nodePickRecentListFragment) {
        super(2);
        this.this$0 = nodePickRecentListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder, Object obj) {
        invoke(viewHolder, obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RecyclerView.ViewHolder viewHolder, final Object obj) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        ItemNodePickItemBinding itemNodePickItemBinding = (ItemNodePickItemBinding) ((NodePickItemViewHolder) viewHolder).getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNodePickItemBinding, "(viewHolder as NodePickItemViewHolder).binding");
        itemNodePickItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feed.pick.NodePickRecentListFragment$onActivityCreated$3.AnonymousClass1 */
            final /* synthetic */ NodePickRecentListFragment$onActivityCreated$3 this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NodePickRecentListFragment nodePickRecentListFragment = this.this$0.this$0;
                Object obj = obj;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
                nodePickRecentListFragment.pickAndFinish((Entity) obj);
            }
        });
    }
}
