package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyLocationStyleCreator implements Parcelable.Creator<MyLocationStyle> {
    @Override // android.os.Parcelable.Creator
    public MyLocationStyle createFromParcel(Parcel parcel) {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon((BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
        myLocationStyle.anchor(parcel.readFloat(), parcel.readFloat());
        myLocationStyle.radiusFillColor(parcel.readInt());
        myLocationStyle.strokeColor(parcel.readInt());
        myLocationStyle.strokeWidth(parcel.readFloat());
        return myLocationStyle;
    }

    @Override // android.os.Parcelable.Creator
    public MyLocationStyle[] newArray(int i) {
        return new MyLocationStyle[i];
    }
}
