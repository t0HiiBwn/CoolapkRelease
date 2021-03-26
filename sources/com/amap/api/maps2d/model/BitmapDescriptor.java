package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.cm;

public final class BitmapDescriptor implements Parcelable, Cloneable {
    static final a a = new a();
    int b = 0;
    int c = 0;
    Bitmap d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.b = bitmap.getWidth();
            this.c = bitmap.getHeight();
            this.d = bitmap;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.b = i;
        this.c = i2;
        this.d = bitmap;
    }

    @Override // java.lang.Object
    public BitmapDescriptor clone() {
        try {
            return new BitmapDescriptor(Bitmap.createBitmap(this.d), this.b, this.c);
        } catch (Throwable th) {
            cm.a(th, "BitmapDescriptor", "clone");
            return null;
        }
    }

    public Bitmap getBitmap() {
        return this.d;
    }

    public int getWidth() {
        return this.b;
    }

    public int getHeight() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    public void recycle() {
        Bitmap bitmap = this.d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
    }
}
