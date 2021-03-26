package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class Tile implements Parcelable {
    public static final j CREATOR = new j();
    private final int a;
    private final int b;
    private final int c;
    public final byte[] data;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeByteArray(this.data);
    }
}
