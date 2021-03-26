package com.coolapk.market.view.main.channel;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "c1", "Lcom/coolapk/market/view/main/channel/Channel;", "kotlin.jvm.PlatformType", "c2", "compare"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChannelViewModel.kt */
final class ChannelViewModel$moveToOtherChannel$1<T> implements Comparator<Channel> {
    public static final ChannelViewModel$moveToOtherChannel$1 INSTANCE = new ChannelViewModel$moveToOtherChannel$1();

    ChannelViewModel$moveToOtherChannel$1() {
    }

    public final int compare(Channel channel, Channel channel2) {
        return Integer.signum(channel.getOrder() - channel2.getOrder());
    }
}
