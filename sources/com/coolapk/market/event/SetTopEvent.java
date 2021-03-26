package com.coolapk.market.event;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ServiceApp;

public class SetTopEvent {
    private String id;
    private boolean isTop;
    private String type;

    public SetTopEvent(boolean z, String str, String str2) {
        this.isTop = z;
        this.id = str;
        this.type = str2;
    }

    public boolean isTop() {
        return this.isTop;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public Feed handleFeedEvent(Feed feed) {
        Feed.Builder newBuilder = Feed.newBuilder(feed);
        newBuilder.isStickTop(this.isTop ? 1 : 0);
        return newBuilder.build();
    }

    public Feed handleFeedCollectionEvent(Feed feed) {
        Feed.Builder newBuilder = Feed.newBuilder(feed);
        newBuilder.collectionItem(CollectionItem.newBuilder(feed.getCollectionItem()).isTop(this.isTop ? 1 : 0).build());
        return newBuilder.build();
    }

    public ServiceApp handleAppCollectionEvent(ServiceApp serviceApp) {
        ServiceApp.Builder builder = ServiceApp.builder(serviceApp);
        builder.setCollectionItem(CollectionItem.newBuilder(serviceApp.getCollectionItem()).isTop(this.isTop ? 1 : 0).build());
        return builder.build();
    }

    public DyhArticle handleArticlrCollectionEvent(DyhArticle dyhArticle) {
        DyhArticle.Builder newBuilder = DyhArticle.newBuilder(dyhArticle);
        newBuilder.collectionItem(CollectionItem.newBuilder(dyhArticle.getCollectionItem()).isTop(this.isTop ? 1 : 0).build());
        return newBuilder.build();
    }

    public Album handleAlbumCollectionEvent(Album album) {
        Album.Builder newBuilder = Album.newBuilder(album);
        newBuilder.collectionItem(CollectionItem.newBuilder(album.getCollectionItem()).isTop(this.isTop ? 1 : 0).build());
        return newBuilder.build();
    }
}
