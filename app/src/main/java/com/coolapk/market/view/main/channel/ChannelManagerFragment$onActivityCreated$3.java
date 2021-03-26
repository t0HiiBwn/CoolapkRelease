package com.coolapk.market.view.main.channel;

import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/coolapk/market/view/main/channel/ChannelManagerFragment$onActivityCreated$3", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChannelManagerFragment.kt */
public final class ChannelManagerFragment$onActivityCreated$3 extends GridLayoutManager.SpanSizeLookup {
    final /* synthetic */ ChannelManagerFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ChannelManagerFragment$onActivityCreated$3(ChannelManagerFragment channelManagerFragment) {
        this.this$0 = channelManagerFragment;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i) {
        return this.this$0.getViewModel().getDataList().get(i) instanceof ChannelTitle ? 3 : 1;
    }
}
