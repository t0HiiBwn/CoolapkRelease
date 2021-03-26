package com.coolapk.market.view.feed.reply;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$onActivityCreated$11 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FeedReplyEventProcessor $eventHandler;
    final /* synthetic */ FeedReplyEventProcessor $loadedDataHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyListFragmentV8$onActivityCreated$11(FeedReplyEventProcessor feedReplyEventProcessor, FeedReplyEventProcessor feedReplyEventProcessor2) {
        super(0);
        this.$eventHandler = feedReplyEventProcessor;
        this.$loadedDataHandler = feedReplyEventProcessor2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$eventHandler.detach();
        this.$loadedDataHandler.detach();
    }
}
