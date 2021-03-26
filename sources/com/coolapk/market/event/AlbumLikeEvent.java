package com.coolapk.market.event;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;

public class AlbumLikeEvent {
    private final String id;
    private final boolean liked;
    private final LikeResult result;

    public AlbumLikeEvent(String str, boolean z, LikeResult likeResult) {
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

    public Album handleEvent(Album album) {
        Album.Builder newBuilder = Album.newBuilder(album);
        if (isLiked()) {
            newBuilder.userAction(UserAction.newBuilder(album.getUserAction()).like(1).build());
        } else {
            newBuilder.userAction(UserAction.newBuilder(album.getUserAction()).like(0).build());
        }
        newBuilder.likeNum(getResult().getCount());
        return newBuilder.build();
    }
}
