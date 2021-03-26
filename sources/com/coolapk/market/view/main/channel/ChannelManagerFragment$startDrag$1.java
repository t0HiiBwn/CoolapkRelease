package com.coolapk.market.view.main.channel;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"drag", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChannelManagerFragment.kt */
final class ChannelManagerFragment$startDrag$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $position;
    final /* synthetic */ ChannelManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelManagerFragment$startDrag$1(ChannelManagerFragment channelManagerFragment, int i) {
        super(0);
        this.this$0 = channelManagerFragment;
        this.$position = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.this$0.getRecyclerView().findViewHolderForAdapterPosition(this.$position);
        if (findViewHolderForAdapterPosition != null) {
            this.this$0.onStartDrag(findViewHolderForAdapterPosition);
        }
    }
}
