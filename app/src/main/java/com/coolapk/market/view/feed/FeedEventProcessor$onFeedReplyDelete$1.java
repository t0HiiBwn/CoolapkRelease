package com.coolapk.market.view.feed;

import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/Feed;", "it", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEventProcessor.kt */
final class FeedEventProcessor$onFeedReplyDelete$1 extends Lambda implements Function1<Feed, Feed> {
    final /* synthetic */ FeedReplyDeleteEvent $event;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedEventProcessor$onFeedReplyDelete$1(FeedReplyDeleteEvent feedReplyDeleteEvent) {
        super(1);
        this.$event = feedReplyDeleteEvent;
    }

    public final Feed invoke(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "it");
        return this.$event.handleEvent(feed);
    }
}
