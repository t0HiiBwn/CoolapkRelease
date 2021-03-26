package com.amap.api.maps2d.model;

public interface TileProvider {
    public static final Tile NO_TILE = new Tile(-1, -1, null);

    Tile getTile(int i, int i2, int i3);

    int getTileHeight();

    int getTileWidth();
}
