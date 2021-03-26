package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/event/FeedPostEvent;", "", "feed", "Lcom/coolapk/market/model/Feed;", "multiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "uiConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "(Lcom/coolapk/market/model/Feed;Lcom/coolapk/market/model/FeedMultiPart;Lcom/coolapk/market/model/FeedUIConfig;)V", "getFeed", "()Lcom/coolapk/market/model/Feed;", "getMultiPart", "()Lcom/coolapk/market/model/FeedMultiPart;", "getUiConfig", "()Lcom/coolapk/market/model/FeedUIConfig;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedPostEvent.kt */
public final class FeedPostEvent {
    private final Feed feed;
    private final FeedMultiPart multiPart;
    private final FeedUIConfig uiConfig;

    public FeedPostEvent(Feed feed2, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.feed = feed2;
        this.multiPart = feedMultiPart;
        this.uiConfig = feedUIConfig;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedPostEvent(Feed feed2, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(feed2, (i & 2) != 0 ? null : feedMultiPart, (i & 4) != 0 ? null : feedUIConfig);
    }

    public final Feed getFeed() {
        return this.feed;
    }

    public final FeedMultiPart getMultiPart() {
        return this.multiPart;
    }

    public final FeedUIConfig getUiConfig() {
        return this.uiConfig;
    }
}
