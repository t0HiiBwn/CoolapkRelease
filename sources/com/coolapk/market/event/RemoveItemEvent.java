package com.coolapk.market.event;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.model.ServiceApp;

public class RemoveItemEvent {
    private Album album;
    private ItemPlaceHolder itemPlaceHolder;
    private ServiceApp serviceApp;

    public RemoveItemEvent(ServiceApp serviceApp2) {
        this.serviceApp = serviceApp2;
    }

    public RemoveItemEvent(ItemPlaceHolder itemPlaceHolder2) {
        this.itemPlaceHolder = itemPlaceHolder2;
    }

    public RemoveItemEvent(Album album2) {
        this.album = album2;
    }

    public Album getAlbum() {
        return this.album;
    }

    public ItemPlaceHolder getItemPlaceHolder() {
        return this.itemPlaceHolder;
    }

    public ServiceApp getServiceApp() {
        return this.serviceApp;
    }
}
