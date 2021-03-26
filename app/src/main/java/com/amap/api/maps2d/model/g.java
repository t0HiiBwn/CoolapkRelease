package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: MarkerOptionsCreator */
class g implements Parcelable.Creator<MarkerOptions> {
    g() {
    }

    /* renamed from: a */
    public MarkerOptions createFromParcel(Parcel parcel) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position((LatLng) parcel.readParcelable(LatLng.class.getClassLoader()));
        markerOptions.icon((BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
        markerOptions.title(parcel.readString());
        markerOptions.snippet(parcel.readString());
        markerOptions.anchor(parcel.readFloat(), parcel.readFloat());
        boolean z = false;
        markerOptions.visible(parcel.readByte() == 1);
        markerOptions.draggable(parcel.readByte() == 1);
        if (parcel.readByte() == 1) {
            z = true;
        }
        markerOptions.setGps(z);
        markerOptions.a = parcel.readString();
        markerOptions.zIndex(parcel.readFloat());
        markerOptions.icons(parcel.createTypedArrayList(BitmapDescriptor.a));
        return markerOptions;
    }

    /* renamed from: a */
    public MarkerOptions[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
