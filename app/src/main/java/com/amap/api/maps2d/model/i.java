package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: PolylineOptionsCreator */
class i implements Parcelable.Creator<PolylineOptions> {
    i() {
    }

    /* renamed from: a */
    public PolylineOptions createFromParcel(Parcel parcel) {
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z = false;
        boolean z2 = parcel.readByte() == 1;
        polylineOptions.addAll(arrayList);
        polylineOptions.width(readFloat);
        polylineOptions.color(readInt);
        polylineOptions.zIndex(readFloat2);
        polylineOptions.visible(z2);
        polylineOptions.a = parcel.readString();
        boolean z3 = parcel.readByte() == 1;
        if (parcel.readByte() == 1) {
            z = true;
        }
        polylineOptions.geodesic(z3);
        polylineOptions.setDottedLine(z);
        return polylineOptions;
    }

    /* renamed from: a */
    public PolylineOptions[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
