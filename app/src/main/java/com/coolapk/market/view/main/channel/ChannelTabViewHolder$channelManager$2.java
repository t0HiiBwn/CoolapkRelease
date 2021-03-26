package com.coolapk.market.view.main.channel;

import androidx.fragment.app.Fragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/main/channel/ChannelManagerFragment;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChannelTabViewHolder.kt */
final class ChannelTabViewHolder$channelManager$2 extends Lambda implements Function0<ChannelManagerFragment> {
    final /* synthetic */ ChannelTabViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelTabViewHolder$channelManager$2(ChannelTabViewHolder channelTabViewHolder) {
        super(0);
        this.this$0 = channelTabViewHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ChannelManagerFragment invoke() {
        Fragment asFragment = this.this$0.container.asFragment();
        Objects.requireNonNull(asFragment, "null cannot be cast to non-null type com.coolapk.market.view.main.channel.ChannelManagerFragment");
        return (ChannelManagerFragment) asFragment;
    }
}
