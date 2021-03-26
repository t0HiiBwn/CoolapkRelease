package com.amap.api.maps2d.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class TextOptions implements Parcelable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();
    private String a;
    private Typeface b = Typeface.DEFAULT;
    private boolean c = true;
    private float d;
    private LatLng e;
    private float f = 0.0f;
    private int g = 0;
    private Object h;
    private int i = -16777216;
    private int j = 20;
    private int k = 3;
    private int l = 6;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TextOptions text(String str) {
        this.a = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.b = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.c = z;
        return this;
    }

    public TextOptions zIndex(float f2) {
        this.d = f2;
        return this;
    }

    public TextOptions position(LatLng latLng) {
        this.e = latLng;
        return this;
    }

    public TextOptions rotate(float f2) {
        this.f = f2;
        return this;
    }

    public TextOptions align(int i2, int i3) {
        this.k = i2;
        this.l = i3;
        return this;
    }

    public TextOptions backgroundColor(int i2) {
        this.g = i2;
        return this;
    }

    public TextOptions setObject(Object obj) {
        this.h = obj;
        return this;
    }

    public TextOptions fontColor(int i2) {
        this.i = i2;
        return this;
    }

    public TextOptions fontSize(int i2) {
        this.j = i2;
        return this;
    }

    public int getAlignX() {
        return this.k;
    }

    public int getAlignY() {
        return this.l;
    }

    public int getBackgroundColor() {
        return this.g;
    }

    public Object getObject() {
        return this.h;
    }

    public int getFontColor() {
        return this.i;
    }

    public int getFontSize() {
        return this.j;
    }

    public LatLng getPosition() {
        return this.e;
    }

    public float getRotate() {
        return this.f;
    }

    public String getText() {
        return this.a;
    }

    public Typeface getTypeface() {
        return this.b;
    }

    public float getZIndex() {
        return this.d;
    }

    public boolean isVisible() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.e;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.e.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.a);
        parcel.writeInt(this.b.getStyle());
        parcel.writeFloat(this.f);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.g);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeFloat(this.d);
        parcel.writeByte(this.c ? (byte) 1 : 0);
        if (this.h instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.h);
            parcel.writeBundle(bundle2);
        }
    }
}
