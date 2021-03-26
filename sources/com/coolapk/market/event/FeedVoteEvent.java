package com.coolapk.market.event;

import com.coolapk.market.model.Vote;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/event/FeedVoteEvent;", "", "vote", "Lcom/coolapk/market/model/Vote;", "(Lcom/coolapk/market/model/Vote;)V", "getVote", "()Lcom/coolapk/market/model/Vote;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEventProcessor.kt */
public final class FeedVoteEvent {
    private final Vote vote;

    public static /* synthetic */ FeedVoteEvent copy$default(FeedVoteEvent feedVoteEvent, Vote vote2, int i, Object obj) {
        if ((i & 1) != 0) {
            vote2 = feedVoteEvent.vote;
        }
        return feedVoteEvent.copy(vote2);
    }

    public final Vote component1() {
        return this.vote;
    }

    public final FeedVoteEvent copy(Vote vote2) {
        Intrinsics.checkNotNullParameter(vote2, "vote");
        return new FeedVoteEvent(vote2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedVoteEvent) && Intrinsics.areEqual(this.vote, ((FeedVoteEvent) obj).vote);
        }
        return true;
    }

    public int hashCode() {
        Vote vote2 = this.vote;
        if (vote2 != null) {
            return vote2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "FeedVoteEvent(vote=" + this.vote + ")";
    }

    public FeedVoteEvent(Vote vote2) {
        Intrinsics.checkNotNullParameter(vote2, "vote");
        this.vote = vote2;
    }

    public final Vote getVote() {
        return this.vote;
    }
}
