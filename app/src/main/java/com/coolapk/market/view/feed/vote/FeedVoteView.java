package com.coolapk.market.view.feed.vote;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteView;", "", "onFeedUpdated", "", "feed", "Lcom/coolapk/market/model/Feed;", "onVoteEvent", "vote", "Lcom/coolapk/market/model/Vote;", "error", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVotePresenter.kt */
public interface FeedVoteView {
    void onFeedUpdated(Feed feed);

    void onVoteEvent(Vote vote, Throwable th);
}
