package com.amap.api.maps2d.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public class MyLocationStyle implements Parcelable {
    public static final MyLocationStyleCreator CREATOR = new MyLocationStyleCreator();
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_INFO = "errorInfo";
    public static final String LOCATION_TYPE = "locationType";
    public static final int LOCATION_TYPE_FOLLOW = 2;
    public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_SHOW = 0;
    private BitmapDescriptor a;
    private float b = 0.5f;
    private float c = 0.5f;
    private int d = Color.argb(100, 0, 0, 180);
    private int e = Color.argb(255, 0, 0, 220);
    private float f = 1.0f;
    private int g = 1;
    private long h = 2000;
    private boolean i = true;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        this.a = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle anchor(float f2, float f3) {
        this.b = f2;
        this.c = f3;
        return this;
    }

    public MyLocationStyle radiusFillColor(int i2) {
        this.d = i2;
        return this;
    }

    public MyLocationStyle strokeColor(int i2) {
        this.e = i2;
        return this;
    }

    public MyLocationStyle strokeWidth(float f2) {
        this.f = f2;
        return this;
    }

    public MyLocationStyle myLocationType(int i2) {
        this.g = i2;
        return this;
    }

    public MyLocationStyle interval(long j) {
        this.h = j;
        return this;
    }

    public MyLocationStyle showMyLocation(boolean z) {
        this.i = z;
        return this;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.a;
    }

    public float getAnchorU() {
        return this.b;
    }

    public float getAnchorV() {
        return this.c;
    }

    public int getRadiusFillColor() {
        return this.d;
    }

    public int getStrokeColor() {
        return this.e;
    }

    public float getStrokeWidth() {
        return this.f;
    }

    public int getMyLocationType() {
        return this.g;
    }

    public long getInterval() {
        return this.h;
    }

    public boolean isMyLocationShowing() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeInt(this.g);
        parcel.writeLong(this.h);
        parcel.writeBooleanArray(new boolean[]{this.i});
    }
}
