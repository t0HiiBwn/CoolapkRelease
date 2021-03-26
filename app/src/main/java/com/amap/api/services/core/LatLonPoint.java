package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() {
        /* class com.amap.api.services.core.LatLonPoint.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LatLonPoint[] newArray(int i) {
            return new LatLonPoint[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint createFromParcel(Parcel parcel) {
            return new LatLonPoint(parcel);
        }
    };
    private double a;
    private double b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public double getLatitude() {
        return this.a;
    }

    public void setLatitude(double d) {
        this.a = d;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.a, this.b);
    }

    @Override // java.lang.Object
    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.a) == Double.doubleToLongBits(latLonPoint.a) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLonPoint.b);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a + "," + this.b;
    }

    protected LatLonPoint(Parcel parcel) {
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
    }
}
