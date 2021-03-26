package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/event/FeedVoteRecommendEvent;", "", "id", "", "fid", "result", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getFid", "()Ljava/lang/String;", "getId", "getResult", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "match", "feed", "Lcom/coolapk/market/model/Feed;", "patch", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEventProcessor.kt */
public final class FeedVoteRecommendEvent {
    private final String fid;
    private final String id;
    private final boolean result;

    public static /* synthetic */ FeedVoteRecommendEvent copy$default(FeedVoteRecommendEvent feedVoteRecommendEvent, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feedVoteRecommendEvent.id;
        }
        if ((i & 2) != 0) {
            str2 = feedVoteRecommendEvent.fid;
        }
        if ((i & 4) != 0) {
            z = feedVoteRecommendEvent.result;
        }
        return feedVoteRecommendEvent.copy(str, str2, z);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.fid;
    }

    public final boolean component3() {
        return this.result;
    }

    public final FeedVoteRecommendEvent copy(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "fid");
        return new FeedVoteRecommendEvent(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedVoteRecommendEvent)) {
            return false;
        }
        FeedVoteRecommendEvent feedVoteRecommendEvent = (FeedVoteRecommendEvent) obj;
        return Intrinsics.areEqual(this.id, feedVoteRecommendEvent.id) && Intrinsics.areEqual(this.fid, feedVoteRecommendEvent.fid) && this.result == feedVoteRecommendEvent.result;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.fid;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.result;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public String toString() {
        return "FeedVoteRecommendEvent(id=" + this.id + ", fid=" + this.fid + ", result=" + this.result + ")";
    }

    public FeedVoteRecommendEvent(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "fid");
        this.id = str;
        this.fid = str2;
        this.result = z;
    }

    public final String getFid() {
        return this.fid;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getResult() {
        return this.result;
    }

    public final boolean match(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        return Intrinsics.areEqual(feed.getId(), this.id);
    }

    public final Feed patch(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Feed build = Feed.newBuilder(feed).isRecommendVoteComment(this.result ? 1 : 0).build();
        Intrinsics.checkNotNullExpressionValue(build, "Feed.newBuilder(feed)\n  …\n                .build()");
        return build;
    }
}
