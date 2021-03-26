package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class LatLng implements Parcelable, Cloneable {
    public static final f CREATOR = new f();
    private static DecimalFormat a = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
    public final double latitude;
    public final double longitude;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng(double d, double d2) {
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.longitude = a(((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        } else {
            this.longitude = a(d2);
        }
        this.latitude = a(Math.max(-90.0d, Math.min(90.0d, d)));
    }

    private static double a(double d) {
        try {
            return Double.parseDouble(a.format(d));
        } catch (Throwable unused) {
            return d;
        }
    }

    @Override // java.lang.Object
    public LatLng clone() {
        return new LatLng(this.latitude, this.longitude);
    }

    @Override // java.lang.Object
    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        if (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }
}
