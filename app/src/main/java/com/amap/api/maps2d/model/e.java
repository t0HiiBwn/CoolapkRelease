package com.amap.api.maps2d.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.AMapException;

/* compiled from: LatLngBoundsCreator */
class e implements Parcelable.Creator<LatLngBounds> {
    e() {
    }

    /* renamed from: a */
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        BadParcelableException e;
        int readInt = parcel.readInt();
        try {
            latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e2) {
                e = e2;
            }
        } catch (BadParcelableException e3) {
            e = e3;
            latLng2 = null;
            cm.a(e, "LatLngBoundsCreator", "createFromParcel");
            latLng = null;
            return new LatLngBounds(readInt, latLng2, latLng);
        }
        try {
            return new LatLngBounds(readInt, latLng2, latLng);
        } catch (AMapException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }

    static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i);
        parcel.writeParcelable(latLngBounds.northeast, i);
    }
}
