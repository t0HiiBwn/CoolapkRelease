package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions implements Parcelable {
    public static final i CREATOR = new i();
    String a;
    private final List<LatLng> b = new ArrayList();
    private float c = 10.0f;
    private int d = -16777216;
    private float e = 0.0f;
    private boolean f = true;
    private boolean g = false;
    private boolean h = false;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolylineOptions add(LatLng latLng) {
        this.b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<LatLng> it2 = iterable.iterator();
                while (it2 != null && it2.hasNext()) {
                    arrayList.add(it2.next());
                }
                this.b.addAll(arrayList);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public PolylineOptions width(float f2) {
        this.c = f2;
        return this;
    }

    public PolylineOptions color(int i) {
        this.d = i;
        return this;
    }

    public PolylineOptions zIndex(float f2) {
        this.e = f2;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.f = z;
        return this;
    }

    public PolylineOptions geodesic(boolean z) {
        this.g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public float getWidth() {
        return this.c;
    }

    public int getColor() {
        return this.d;
    }

    public float getZIndex() {
        return this.e;
    }

    public boolean isVisible() {
        return this.f;
    }

    public PolylineOptions setDottedLine(boolean z) {
        this.h = z;
        return this;
    }

    public boolean isDottedLine() {
        return this.h;
    }

    public boolean isGeodesic() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(getPoints());
        parcel.writeFloat(getWidth());
        parcel.writeInt(getColor());
        parcel.writeFloat(getZIndex());
        parcel.writeByte(isVisible() ? (byte) 1 : 0);
        parcel.writeString(this.a);
        parcel.writeByte(isGeodesic() ? (byte) 1 : 0);
        parcel.writeByte(isDottedLine() ? (byte) 1 : 0);
    }
}
