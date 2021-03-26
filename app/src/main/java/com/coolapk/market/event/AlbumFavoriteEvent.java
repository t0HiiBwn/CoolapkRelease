package com.coolapk.market.event;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.UserAction;

public class AlbumFavoriteEvent {
    private String feedId;
    private boolean isfavorite;

    public AlbumFavoriteEvent(boolean z, String str) {
        this.isfavorite = z;
        this.feedId = str;
    }

    public String getId() {
        return this.feedId;
    }

    public boolean isfavorite() {
        return this.isfavorite;
    }

    public Album handleEvent(Album album) {
        Album.Builder newBuilder = Album.newBuilder(album);
        UserAction build = UserAction.newBuilder(album.getUserAction()).favorite(this.isfavorite ? 1 : 0).build();
        newBuilder.favoriteNum(album.getFavoriteNum() + (this.isfavorite ? 1 : -1));
        newBuilder.userAction(build);
        return newBuilder.build();
    }
}
