package com.amap.api.maps2d;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.CameraPosition;

public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 0;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
    private int a = 1;
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    private boolean e = false;
    private CameraPosition f;
    private boolean g = false;
    private boolean h = false;
    private int i = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AMapOptions logoPosition(int i2) {
        this.i = i2;
        return this;
    }

    public AMapOptions zOrderOnTop(boolean z) {
        this.e = z;
        return this;
    }

    public AMapOptions mapType(int i2) {
        this.a = i2;
        return this;
    }

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.f = cameraPosition;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z) {
        this.h = z;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z) {
        this.d = z;
        return this;
    }

    public AMapOptions compassEnabled(boolean z) {
        this.g = z;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z) {
        this.b = z;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z) {
        this.c = z;
        return this;
    }

    public int getLogoPosition() {
        return this.i;
    }

    public Boolean getZOrderOnTop() {
        return Boolean.valueOf(this.e);
    }

    public int getMapType() {
        return this.a;
    }

    public CameraPosition getCamera() {
        return this.f;
    }

    public Boolean getScaleControlsEnabled() {
        return Boolean.valueOf(this.h);
    }

    public Boolean getZoomControlsEnabled() {
        return Boolean.valueOf(this.d);
    }

    public Boolean getCompassEnabled() {
        return Boolean.valueOf(this.g);
    }

    public Boolean getScrollGesturesEnabled() {
        return Boolean.valueOf(this.b);
    }

    public Boolean getZoomGesturesEnabled() {
        return Boolean.valueOf(this.c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f, i2);
        parcel.writeInt(this.a);
        parcel.writeBooleanArray(new boolean[]{this.b, this.c, this.d, this.e, this.g, this.h});
    }
}
