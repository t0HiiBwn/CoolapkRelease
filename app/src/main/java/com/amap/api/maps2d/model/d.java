package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: GroundOverlayOptionsCreator */
class d implements Parcelable.Creator<GroundOverlayOptions> {
    d() {
    }

    /* renamed from: a */
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions(readInt, null, (LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), parcel.readByte() != 0, parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        groundOverlayOptions.image(bitmapDescriptor);
        return groundOverlayOptions;
    }

    /* renamed from: a */
    public GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
