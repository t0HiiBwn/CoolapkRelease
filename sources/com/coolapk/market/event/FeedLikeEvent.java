package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;

public class FeedLikeEvent {
    private final String id;
    private final boolean liked;
    private final LikeResult result;

    public FeedLikeEvent(String str, boolean z, LikeResult likeResult) {
        this.id = str;
        this.liked = z;
        this.result = likeResult;
    }

    public LikeResult getResult() {
        return this.result;
    }

    public String getId() {
        return this.id;
    }

    public boolean isLiked() {
        return this.liked;
    }

    public Feed handleEvent(Feed feed) {
        Feed.Builder newBuilder = Feed.newBuilder(feed);
        if (isLiked()) {
            newBuilder.userAction(UserAction.newBuilder(feed.getUserAction()).like(1).build());
        } else {
            newBuilder.userAction(UserAction.newBuilder(feed.getUserAction()).like(0).build());
        }
        newBuilder.likeNum(getResult().getCount());
        newBuilder.recentLikeList(getResult().getRecentLikeList());
        return newBuilder.build();
    }
}
