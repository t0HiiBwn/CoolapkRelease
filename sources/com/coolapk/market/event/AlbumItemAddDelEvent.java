package com.coolapk.market.event;

import com.coolapk.market.model.AlbumItem;

public class AlbumItemAddDelEvent {
    private boolean add;
    private AlbumItem albumItem;

    public AlbumItemAddDelEvent(AlbumItem albumItem2, boolean z) {
        this.albumItem = albumItem2;
        this.add = z;
    }

    public void setAdd(boolean z) {
        this.add = z;
    }

    public boolean getAdd() {
        return this.add;
    }

    public AlbumItem getAlbumItem() {
        return this.albumItem;
    }
}
