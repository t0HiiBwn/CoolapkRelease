package com.coolapk.market.view.feed.vote;

import com.coolapk.market.event.FeedEventRequester;
import com.coolapk.market.model.Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ$\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVotePresenter;", "", "view", "Lcom/coolapk/market/view/feed/vote/FeedVoteView;", "(Lcom/coolapk/market/view/feed/vote/FeedVoteView;)V", "getView", "()Lcom/coolapk/market/view/feed/vote/FeedVoteView;", "requestFeedUpdated", "", "feed", "Lcom/coolapk/market/model/Feed;", "voteOptions", "fid", "", "options", "", "anonymous", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVotePresenter.kt */
public final class FeedVotePresenter {
    private final FeedVoteView view;

    public FeedVotePresenter(FeedVoteView feedVoteView) {
        Intrinsics.checkNotNullParameter(feedVoteView, "view");
        this.view = feedVoteView;
    }

    public final FeedVoteView getView() {
        return this.view;
    }

    public final void voteOptions(String str, List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, "fid");
        Intrinsics.checkNotNullParameter(list, "options");
        FeedEventRequester.INSTANCE.requestVote(str, list, z, new FeedVotePresenter$voteOptions$1(this), new FeedVotePresenter$voteOptions$2(this));
    }

    public final void requestFeedUpdated(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.view.onFeedUpdated(feed);
    }
}
