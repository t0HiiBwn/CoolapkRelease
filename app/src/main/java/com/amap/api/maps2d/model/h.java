package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: PolygonOptionsCreator */
class h implements Parcelable.Creator<PolygonOptions> {
    h() {
    }

    /* renamed from: a */
    public PolygonOptions createFromParcel(Parcel parcel) {
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z = parcel.readByte() == 0;
        polygonOptions.add((LatLng[]) arrayList.toArray(new LatLng[arrayList.size()]));
        polygonOptions.strokeWidth(readFloat);
        polygonOptions.strokeColor(readInt);
        polygonOptions.fillColor(readInt2);
        polygonOptions.zIndex(readFloat2);
        polygonOptions.visible(z);
        polygonOptions.a = parcel.readString();
        return polygonOptions;
    }

    /* renamed from: a */
    public PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
