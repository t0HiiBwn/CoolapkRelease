package com.amap.api.maps2d.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.cm;

public class TextOptionsCreator implements Parcelable.Creator<TextOptions> {
    @Override // android.os.Parcelable.Creator
    public TextOptions createFromParcel(Parcel parcel) {
        TextOptions textOptions = new TextOptions();
        Bundle readBundle = parcel.readBundle();
        textOptions.position(new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng")));
        textOptions.text(parcel.readString());
        textOptions.typeface(Typeface.defaultFromStyle(parcel.readInt()));
        textOptions.rotate(parcel.readFloat());
        textOptions.align(parcel.readInt(), parcel.readInt());
        textOptions.backgroundColor(parcel.readInt());
        textOptions.fontColor(parcel.readInt());
        textOptions.fontSize(parcel.readInt());
        textOptions.zIndex((float) parcel.readInt());
        boolean z = true;
        if (parcel.readByte() != 1) {
            z = false;
        }
        textOptions.visible(z);
        try {
            Parcelable parcelable = parcel.readBundle().getParcelable("obj");
            if (parcelable != null) {
                textOptions.setObject(parcelable);
            }
        } catch (Throwable th) {
            cm.a(th, "TextOptionsCreator", "createFromParcel");
        }
        return textOptions;
    }

    @Override // android.os.Parcelable.Creator
    public TextOptions[] newArray(int i) {
        return new TextOptions[i];
    }
}
