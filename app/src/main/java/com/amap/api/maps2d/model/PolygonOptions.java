package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions implements Parcelable {
    public static final h CREATOR = new h();
    String a;
    private final List<LatLng> b = new ArrayList();
    private float c = 10.0f;
    private int d = -16777216;
    private int e = -16777216;
    private float f = 0.0f;
    private boolean g = true;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeByte((byte) (!this.g ? 1 : 0));
        parcel.writeString(this.a);
    }

    public PolygonOptions add(LatLng latLng) {
        this.b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable == null) {
            return this;
        }
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
        return this;
    }

    public PolygonOptions strokeWidth(float f2) {
        this.c = f2;
        return this;
    }

    public PolygonOptions strokeColor(int i) {
        this.d = i;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.e = i;
        return this;
    }

    public PolygonOptions zIndex(float f2) {
        this.f = f2;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public float getStrokeWidth() {
        return this.c;
    }

    public int getStrokeColor() {
        return this.d;
    }

    public int getFillColor() {
        return this.e;
    }

    public float getZIndex() {
        return this.f;
    }

    public boolean isVisible() {
        return this.g;
    }
}
