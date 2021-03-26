package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class MarkerOptions implements Parcelable {
    public static final g CREATOR = new g();
    String a;
    private LatLng b;
    private String c;
    private String d;
    private float e = 0.5f;
    private float f = 1.0f;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;
    private float j;
    private ArrayList<BitmapDescriptor> k = new ArrayList<>();
    private int l = 20;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        this.k = arrayList;
        return this;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.k;
    }

    public MarkerOptions period(int i2) {
        if (i2 <= 1) {
            this.l = 1;
        } else {
            this.l = i2;
        }
        return this;
    }

    public int getPeriod() {
        return this.l;
    }

    public MarkerOptions position(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            a();
            this.k.clear();
            this.k.add(bitmapDescriptor);
        } catch (Throwable unused) {
        }
        return this;
    }

    public MarkerOptions anchor(float f2, float f3) {
        this.e = f2;
        this.f = f3;
        return this;
    }

    public MarkerOptions title(String str) {
        this.c = str;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.d = str;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.g = z;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    public MarkerOptions setGps(boolean z) {
        this.i = z;
        return this;
    }

    public MarkerOptions zIndex(float f2) {
        this.j = f2;
        return this;
    }

    public float getZIndex() {
        return this.j;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public String getTitle() {
        return this.c;
    }

    public String getSnippet() {
        return this.d;
    }

    public BitmapDescriptor getIcon() {
        ArrayList<BitmapDescriptor> arrayList = this.k;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.k.get(0);
    }

    public float getAnchorU() {
        return this.e;
    }

    public float getAnchorV() {
        return this.f;
    }

    public boolean isDraggable() {
        return this.g;
    }

    public boolean isVisible() {
        return this.h;
    }

    public boolean isGps() {
        return this.i;
    }

    private void a() {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.b, i2);
        ArrayList<BitmapDescriptor> arrayList = this.k;
        if (!(arrayList == null || arrayList.size() == 0)) {
            parcel.writeParcelable(this.k.get(0), i2);
        }
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeByte(this.i ? (byte) 1 : 0);
        parcel.writeString(this.a);
        parcel.writeFloat(this.j);
        parcel.writeList(this.k);
    }
}
