package com.amap.api.maps2d.model;

import com.amap.api.interfaces.ITileOverlay;

public final class TileOverlay {
    private ITileOverlay a;

    public TileOverlay(ITileOverlay iTileOverlay) {
        this.a = iTileOverlay;
    }

    public void remove() {
        this.a.remove();
    }

    public void clearTileCache() {
        this.a.clearTileCache();
    }

    public String getId() {
        return this.a.getId();
    }

    public void setZIndex(float f) {
        this.a.setZIndex(f);
    }

    public float getZIndex() {
        return this.a.getZIndex();
    }

    public void setVisible(boolean z) {
        this.a.setVisible(z);
    }

    public boolean isVisible() {
        return this.a.isVisible();
    }

    public boolean equals(Object obj) {
        ITileOverlay iTileOverlay = this.a;
        return iTileOverlay.equalsRemote(iTileOverlay);
    }

    public int hashCode() {
        return this.a.hashCodeRemote();
    }
}
