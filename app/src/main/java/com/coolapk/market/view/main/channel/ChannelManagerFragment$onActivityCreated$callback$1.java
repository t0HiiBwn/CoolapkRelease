package com.coolapk.market.view.main.channel;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/main/channel/ChannelManagerFragment$onActivityCreated$callback$1", "Lcom/coolapk/market/view/main/channel/ItemTouchHelperAdapter;", "onItemMove", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "source", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "target", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChannelManagerFragment.kt */
public final class ChannelManagerFragment$onActivityCreated$callback$1 implements ItemTouchHelperAdapter {
    final /* synthetic */ ChannelManagerFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ChannelManagerFragment$onActivityCreated$callback$1(ChannelManagerFragment channelManagerFragment) {
        this.this$0 = channelManagerFragment;
    }

    @Override // com.coolapk.market.view.main.channel.ItemTouchHelperAdapter
    public boolean onItemMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "source");
        Intrinsics.checkNotNullParameter(viewHolder2, "target");
        if (viewHolder.getItemViewType() == viewHolder2.getItemViewType() && (viewHolder instanceof ChannelTabViewHolder) && (viewHolder2 instanceof ChannelTabViewHolder)) {
            int adapterPosition = ((ChannelTabViewHolder) viewHolder).getAdapterPosition();
            int adapterPosition2 = ((ChannelTabViewHolder) viewHolder2).getAdapterPosition();
            Object obj = this.this$0.getViewModel().getDataList().get(adapterPosition);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.main.channel.Channel");
            Channel channel = (Channel) obj;
            Object obj2 = this.this$0.getViewModel().getDataList().get(adapterPosition2);
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.coolapk.market.view.main.channel.Channel");
            Channel channel2 = (Channel) obj2;
            if (channel.getVisible() && channel2.getVisible() && !channel.isFixed() && !channel2.isFixed()) {
                this.this$0.getViewModel().onItemMove(adapterPosition, adapterPosition2);
                return true;
            }
        }
        return false;
    }
}
