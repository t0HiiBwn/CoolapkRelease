package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BitmapDescriptorCreator */
class a implements Parcelable.Creator<BitmapDescriptor> {
    a() {
    }

    /* renamed from: a */
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null);
        bitmapDescriptor.d = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        bitmapDescriptor.b = parcel.readInt();
        bitmapDescriptor.c = parcel.readInt();
        return bitmapDescriptor;
    }

    /* renamed from: a */
    public BitmapDescriptor[] newArray(int i) {
        return new BitmapDescriptor[i];
    }
}
