package com.amap.api.maps2d.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class TileOverlayOptions implements Parcelable {
    public static final k CREATOR = new k();
    private final int a;
    private TileProvider b;
    private boolean c;
    private float d;
    private int e;
    private int f;
    private String g;
    private boolean h;
    private boolean i;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions() {
        this.c = true;
        this.e = 5120;
        this.f = 20480;
        this.g = null;
        this.h = true;
        this.i = true;
        this.a = 1;
    }

    TileOverlayOptions(int i2, IBinder iBinder, boolean z, float f2) {
        this.c = true;
        this.e = 5120;
        this.f = 20480;
        this.g = null;
        this.h = true;
        this.i = true;
        this.a = i2;
        this.c = z;
        this.d = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeValue(this.b);
        parcel.writeByte(this.c ? (byte) 1 : 0);
        parcel.writeFloat(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        parcel.writeByte(this.i ? (byte) 1 : 0);
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.b = tileProvider;
        return this;
    }

    public TileOverlayOptions zIndex(float f2) {
        this.d = f2;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.c = z;
        return this;
    }

    public TileOverlayOptions memCacheSize(int i2) {
        this.e = i2;
        return this;
    }

    public TileOverlayOptions diskCacheSize(int i2) {
        this.f = i2 * 1024;
        return this;
    }

    public TileOverlayOptions diskCacheDir(String str) {
        this.g = str;
        return this;
    }

    public TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.h = z;
        return this;
    }

    public TileOverlayOptions diskCacheEnabled(boolean z) {
        this.i = z;
        return this;
    }

    public TileProvider getTileProvider() {
        return this.b;
    }

    public float getZIndex() {
        return this.d;
    }

    public boolean isVisible() {
        return this.c;
    }

    public int getMemCacheSize() {
        return this.e;
    }

    public int getDiskCacheSize() {
        return this.f;
    }

    public String getDiskCacheDir() {
        return this.g;
    }

    public boolean getMemoryCacheEnabled() {
        return this.h;
    }

    public boolean getDiskCacheEnabled() {
        return this.i;
    }
}
