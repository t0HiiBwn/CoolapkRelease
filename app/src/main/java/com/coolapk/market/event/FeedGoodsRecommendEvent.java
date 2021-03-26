package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoodsAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/event/FeedGoodsRecommendEvent;", "", "recommend", "", "id", "", "(ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "handleEvent", "Lcom/coolapk/market/model/Feed;", "feed", "match", "any", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsRecommendEvent.kt */
public final class FeedGoodsRecommendEvent {
    private final String id;
    private final boolean recommend;

    public FeedGoodsRecommendEvent(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.recommend = z;
        this.id = str;
    }

    public final String getId() {
        return this.id;
    }

    public final Feed handleEvent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Feed.Builder newBuilder = Feed.newBuilder(feed);
        FeedGoodsAction goodsAction = feed.getGoodsAction();
        if (goodsAction == null) {
            goodsAction = FeedGoodsAction.EMPTY;
        }
        newBuilder.goodsAction(FeedGoodsAction.newBuilder(goodsAction).recommendStatus(this.recommend ? 1 : 0).build());
        Feed build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final boolean match(Object obj) {
        if (!(obj instanceof Feed)) {
            return false;
        }
        Feed feed = (Feed) obj;
        if (!Intrinsics.areEqual(feed.getFeedType(), "goods")) {
            return false;
        }
        return Intrinsics.areEqual(feed.getId(), this.id);
    }
}
