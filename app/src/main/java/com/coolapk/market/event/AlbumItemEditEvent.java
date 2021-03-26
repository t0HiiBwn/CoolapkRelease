package com.coolapk.market.event;

import com.coolapk.market.model.AlbumItem;

public class AlbumItemEditEvent {
    private AlbumItem albumItem;
    private String editType;

    public AlbumItemEditEvent(AlbumItem albumItem2, String str) {
        this.albumItem = albumItem2;
        this.editType = str;
    }

    public AlbumItem getAlbumItem() {
        return this.albumItem;
    }

    public String getEditType() {
        return this.editType;
    }
}
