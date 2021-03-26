package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.cm;

public final class VisibleRegion implements Parcelable {
    public static final l CREATOR = new l();
    private final int a;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds2) {
        this.a = i;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds2;
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds2) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        l.a(this, parcel, i);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return cm.a(new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds});
    }

    int a() {
        return this.a;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        if (!this.nearLeft.equals(visibleRegion.nearLeft) || !this.nearRight.equals(visibleRegion.nearRight) || !this.farLeft.equals(visibleRegion.farLeft) || !this.farRight.equals(visibleRegion.farRight) || !this.latLngBounds.equals(visibleRegion.latLngBounds)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        return cm.a(cm.a("nearLeft", this.nearLeft), cm.a("nearRight", this.nearRight), cm.a("farLeft", this.farLeft), cm.a("farRight", this.farRight), cm.a("latLngBounds", this.latLngBounds));
    }
}
