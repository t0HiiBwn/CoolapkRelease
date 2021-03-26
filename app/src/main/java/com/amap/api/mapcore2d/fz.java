package com.amap.api.mapcore2d;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;

/* compiled from: LocationListener */
public final class fz implements AMapLocationListener {
    public Inner_3dMap_locationListener a = null;

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        this.a = inner_3dMap_locationListener;
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        try {
            Inner_3dMap_location a2 = gb.a(aMapLocation);
            if (gk.a(a2)) {
                gb.a = a2;
            }
            Inner_3dMap_locationListener inner_3dMap_locationListener = this.a;
            if (inner_3dMap_locationListener != null) {
                inner_3dMap_locationListener.onLocationChanged(a2);
            }
        } catch (Throwable th) {
            gu.a(th, "LocationListener", "onLocationChanged");
        }
    }
}
