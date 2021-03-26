package com.coolapk.market.event;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.Feed;

public class FeedRecommendEvent {
    private String feedId;
    private boolean recommend;

    public FeedRecommendEvent(boolean z, String str) {
        this.recommend = z;
        this.feedId = str;
    }

    public String getId() {
        return this.feedId;
    }

    public Feed handleEvent(Feed feed) {
        Feed.Builder newBuilder = Feed.newBuilder(feed);
        newBuilder.recommend(this.recommend ? 1 : 0);
        return newBuilder.build();
    }

    public Album handleEvent(Album album) {
        Album.Builder newBuilder = Album.newBuilder(album);
        newBuilder.recommend(this.recommend ? 1 : 0);
        return newBuilder.build();
    }
}
