package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() {
        /* class com.amap.api.services.core.LatLonSharePoint.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LatLonSharePoint[] newArray(int i) {
            return new LatLonSharePoint[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint createFromParcel(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }
    };
    private String a;

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonSharePoint(double d, double d2, String str) {
        super(d, d2);
        this.a = str;
    }

    public String getSharePointName() {
        return this.a;
    }

    public void setSharePointName(String str) {
        this.a = str;
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
    }

    @Override // com.amap.api.services.core.LatLonPoint, java.lang.Object
    public int hashCode() {
        int i;
        int hashCode = super.hashCode() * 31;
        String str = this.a;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @Override // com.amap.api.services.core.LatLonPoint, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.a;
        if (str == null) {
            if (latLonSharePoint.a != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.a)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.services.core.LatLonPoint, java.lang.Object
    public String toString() {
        return super.toString() + "," + this.a;
    }
}
