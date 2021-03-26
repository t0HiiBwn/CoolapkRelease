package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: TileCreator */
class j implements Parcelable.Creator<Tile> {
    j() {
    }

    /* renamed from: a */
    public Tile createFromParcel(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
    }

    /* renamed from: a */
    public Tile[] newArray(int i) {
        return new Tile[i];
    }
}
