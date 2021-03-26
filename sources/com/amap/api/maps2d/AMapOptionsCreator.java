package com.amap.api.maps2d;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.CameraPosition;

public class AMapOptionsCreator implements Parcelable.Creator<AMapOptions> {
    @Override // android.os.Parcelable.Creator
    public AMapOptions createFromParcel(Parcel parcel) {
        AMapOptions aMapOptions = new AMapOptions();
        aMapOptions.mapType(parcel.readInt());
        aMapOptions.camera((CameraPosition) parcel.readParcelable(CameraPosition.class.getClassLoader()));
        boolean[] createBooleanArray = parcel.createBooleanArray();
        if (createBooleanArray != null && createBooleanArray.length >= 6) {
            aMapOptions.scrollGesturesEnabled(createBooleanArray[0]);
            aMapOptions.zoomGesturesEnabled(createBooleanArray[1]);
            aMapOptions.zoomControlsEnabled(createBooleanArray[2]);
            aMapOptions.zOrderOnTop(createBooleanArray[3]);
            aMapOptions.compassEnabled(createBooleanArray[4]);
            aMapOptions.scaleControlsEnabled(createBooleanArray[5]);
        }
        return aMapOptions;
    }

    @Override // android.os.Parcelable.Creator
    public AMapOptions[] newArray(int i) {
        return new AMapOptions[i];
    }
}
