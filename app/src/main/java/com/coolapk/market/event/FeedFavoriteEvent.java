package com.coolapk.market.event;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;

public class FeedFavoriteEvent {
    private int favNum;
    private String feedId;
    private boolean isfavorite;

    public FeedFavoriteEvent(boolean z, String str) {
        this.isfavorite = z;
        this.feedId = str;
    }

    public FeedFavoriteEvent(boolean z, int i, String str) {
        this.isfavorite = z;
        this.feedId = str;
        this.favNum = i;
    }

    public String getId() {
        return this.feedId;
    }

    public boolean isfavorite() {
        return this.isfavorite;
    }

    public int getFavNum() {
        return this.favNum;
    }

    public Feed handleEvent(Feed feed) {
        Feed.Builder newBuilder = Feed.newBuilder(feed);
        UserAction build = UserAction.newBuilder(feed.getUserAction()).collect(this.isfavorite ? 1 : 0).build();
        newBuilder.favoriteNum(this.favNum);
        newBuilder.userAction(build);
        return newBuilder.build();
    }

    public Album handleEvent(Album album) {
        Album.Builder newBuilder = Album.newBuilder(album);
        UserAction build = UserAction.newBuilder(album.getUserAction()).collect(this.isfavorite ? 1 : 0).build();
        newBuilder.favoriteNum(this.favNum);
        newBuilder.userAction(build);
        return newBuilder.build();
    }
}
