package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new Parcelable.Creator<BusinessArea>() {
        /* class com.amap.api.services.geocoder.BusinessArea.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusinessArea[] newArray(int i) {
            return new BusinessArea[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea createFromParcel(Parcel parcel) {
            return new BusinessArea(parcel);
        }
    };
    private LatLonPoint a;
    private String b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BusinessArea() {
    }

    public LatLonPoint getCenterPoint() {
        return this.a;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public String getName() {
        return this.b;
    }

    public void setName(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
    }

    public BusinessArea(Parcel parcel) {
        this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = parcel.readString();
    }
}
