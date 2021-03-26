package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SimpleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/event/FeedCensorEvent;", "", "feedId", "", "status", "", "simpleInfo", "Lcom/coolapk/market/model/SimpleInfo;", "(Ljava/lang/String;ILcom/coolapk/market/model/SimpleInfo;)V", "getFeedId", "()Ljava/lang/String;", "getSimpleInfo", "()Lcom/coolapk/market/model/SimpleInfo;", "getStatus", "()I", "handleEvent", "Lcom/coolapk/market/model/Feed;", "feed", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedCensorEvent.kt */
public final class FeedCensorEvent {
    private final String feedId;
    private final SimpleInfo simpleInfo;
    private final int status;

    public FeedCensorEvent(String str, int i, SimpleInfo simpleInfo2) {
        Intrinsics.checkNotNullParameter(str, "feedId");
        Intrinsics.checkNotNullParameter(simpleInfo2, "simpleInfo");
        this.feedId = str;
        this.status = i;
        this.simpleInfo = simpleInfo2;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final SimpleInfo getSimpleInfo() {
        return this.simpleInfo;
    }

    public final int getStatus() {
        return this.status;
    }

    public final Feed handleEvent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Feed build = Feed.newBuilder(feed).status(this.status).innerInfo(this.simpleInfo).build();
        Intrinsics.checkNotNullExpressionValue(build, "Feed.newBuilder(feed)\n  …\n                .build()");
        return build;
    }
}
