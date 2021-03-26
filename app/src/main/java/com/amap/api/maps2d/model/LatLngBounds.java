package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.AMapException;

public final class LatLngBounds implements Parcelable {
    public static final e CREATOR = new e();
    private final int a;
    public final LatLng northeast;
    public final LatLng southwest;

    /* access modifiers changed from: private */
    public static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: private */
    public static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) throws AMapException {
        if (latLng == null) {
            throw new AMapException("null southwest");
        } else if (latLng2 == null) {
            throw new AMapException("null northeast");
        } else if (latLng2.latitude >= latLng.latitude) {
            this.a = i;
            this.southwest = latLng;
            this.northeast = latLng2;
        } else {
            throw new AMapException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) throws AMapException {
        this(1, latLng, latLng2);
    }

    int a() {
        return this.a;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(LatLng latLng) {
        if (latLng != null && a(latLng.latitude) && b(latLng.longitude)) {
            return true;
        }
        return false;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        if (latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        return a(latLngBounds) || latLngBounds.a(this);
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        double d = ((latLng.longitude + latLngBounds.southwest.longitude) - this.northeast.longitude) - this.southwest.longitude;
        double d2 = ((this.northeast.longitude - this.southwest.longitude) + latLngBounds.northeast.longitude) - this.southwest.longitude;
        double d3 = ((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) - this.northeast.latitude) - this.southwest.latitude;
        double d4 = ((this.northeast.latitude - this.southwest.latitude) + latLngBounds.northeast.latitude) - latLngBounds.southwest.latitude;
        if (Math.abs(d) >= d2 || Math.abs(d3) >= d4) {
            return false;
        }
        return true;
    }

    public LatLngBounds including(LatLng latLng) {
        if (latLng == null) {
            return this;
        }
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!b(d3)) {
            int i = (c(d2, d3) > d(d, d3) ? 1 : (c(d2, d3) == d(d, d3) ? 0 : -1));
        }
        try {
            return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d3));
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    private boolean a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean b(double d) {
        if (this.southwest.longitude <= this.northeast.longitude) {
            if (this.southwest.longitude > d || d > this.northeast.longitude) {
                return false;
            }
            return true;
        } else if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
            return true;
        } else {
            return false;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return cm.a(new Object[]{this.southwest, this.northeast});
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (!this.southwest.equals(latLngBounds.southwest) || !this.northeast.equals(latLngBounds.northeast)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        return cm.a(cm.a("southwest", this.southwest), cm.a("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }

    public static final class Builder {
        private double a = Double.POSITIVE_INFINITY;
        private double b = Double.NEGATIVE_INFINITY;
        private double c = Double.NaN;
        private double d = Double.NaN;

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.a = Math.min(this.a, latLng.latitude);
            this.b = Math.max(this.b, latLng.latitude);
            double d2 = latLng.longitude;
            if (Double.isNaN(this.c)) {
                this.c = d2;
                this.d = d2;
            } else if (!a(d2)) {
                if (LatLngBounds.c(this.c, d2) < LatLngBounds.d(this.d, d2)) {
                    this.c = d2;
                } else {
                    this.d = d2;
                }
            }
            return this;
        }

        private boolean a(double d2) {
            double d3 = this.c;
            double d4 = this.d;
            return d3 <= d4 ? d3 <= d2 && d2 <= d4 : d3 <= d2 || d2 <= d4;
        }

        public LatLngBounds build() {
            try {
                if (Double.isNaN(this.c)) {
                    Log.w("LatLngBounds", "no included points");
                    return null;
                }
                double d2 = this.c;
                double d3 = this.d;
                if (d2 > d3) {
                    this.c = d3;
                    this.d = d2;
                }
                double d4 = this.a;
                double d5 = this.b;
                if (d4 > d5) {
                    this.a = d5;
                    this.b = d4;
                }
                return new LatLngBounds(new LatLng(this.a, this.c), new LatLng(this.b, this.d));
            } catch (Throwable th) {
                cm.a(th, "LatLngBounds", "build");
                return null;
            }
        }
    }
}
