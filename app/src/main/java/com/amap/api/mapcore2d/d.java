package com.amap.api.mapcore2d;

import android.location.Location;
import com.amap.api.maps2d.LocationSource;

/* compiled from: AMapOnLocationChangedListener */
class d implements LocationSource.OnLocationChangedListener {
    Location a;
    private y b;

    d(y yVar) {
        this.b = yVar;
    }

    @Override // com.amap.api.maps2d.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location location) {
        this.a = location;
        try {
            if (this.b.isMyLocationEnabled()) {
                this.b.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            cm.a(th, "AMapOnLocationChangedListener", "onLocationChanged");
        }
    }
}
