package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.FeedReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyTopEvent;", "", "reply", "Lcom/coolapk/market/model/FeedReply;", "isTopNow", "", "(Lcom/coolapk/market/model/FeedReply;Z)V", "()Z", "getReply", "()Lcom/coolapk/market/model/FeedReply;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyTopDialogInterceptor.kt */
public final class FeedReplyTopEvent {
    private final boolean isTopNow;
    private final FeedReply reply;

    public static /* synthetic */ FeedReplyTopEvent copy$default(FeedReplyTopEvent feedReplyTopEvent, FeedReply feedReply, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            feedReply = feedReplyTopEvent.reply;
        }
        if ((i & 2) != 0) {
            z = feedReplyTopEvent.isTopNow;
        }
        return feedReplyTopEvent.copy(feedReply, z);
    }

    public final FeedReply component1() {
        return this.reply;
    }

    public final boolean component2() {
        return this.isTopNow;
    }

    public final FeedReplyTopEvent copy(FeedReply feedReply, boolean z) {
        Intrinsics.checkNotNullParameter(feedReply, "reply");
        return new FeedReplyTopEvent(feedReply, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedReplyTopEvent)) {
            return false;
        }
        FeedReplyTopEvent feedReplyTopEvent = (FeedReplyTopEvent) obj;
        return Intrinsics.areEqual(this.reply, feedReplyTopEvent.reply) && this.isTopNow == feedReplyTopEvent.isTopNow;
    }

    public int hashCode() {
        FeedReply feedReply = this.reply;
        int hashCode = (feedReply != null ? feedReply.hashCode() : 0) * 31;
        boolean z = this.isTopNow;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public String toString() {
        return "FeedReplyTopEvent(reply=" + this.reply + ", isTopNow=" + this.isTopNow + ")";
    }

    public FeedReplyTopEvent(FeedReply feedReply, boolean z) {
        Intrinsics.checkNotNullParameter(feedReply, "reply");
        this.reply = feedReply;
        this.isTopNow = z;
    }

    public final FeedReply getReply() {
        return this.reply;
    }

    public final boolean isTopNow() {
        return this.isTopNow;
    }
}
