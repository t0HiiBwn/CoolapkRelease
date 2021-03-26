package com.amap.api.mapcore2d;

import com.amap.api.maps2d.model.LatLng;

/* compiled from: NaviveCoordConver */
public class cj {
    public static LatLng a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        if (!cl.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        double[] a = fy.a(latLng.longitude, latLng.latitude);
        return new LatLng(a[1], a[0]);
    }
}
