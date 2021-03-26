package com.coolapk.market.view.live;

import com.coolapk.market.model.LiveMessage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/LiveMessage;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveMessageListFragment.kt */
final class LiveMessageListFragment$onLiveMessageEventChanged$2 extends Lambda implements Function1<LiveMessage, Boolean> {
    public static final LiveMessageListFragment$onLiveMessageEventChanged$2 INSTANCE = new LiveMessageListFragment$onLiveMessageEventChanged$2();

    LiveMessageListFragment$onLiveMessageEventChanged$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(LiveMessage liveMessage) {
        return Boolean.valueOf(invoke(liveMessage));
    }

    public final boolean invoke(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "it");
        return liveMessage.getIsBroadcast() == 1;
    }
}
