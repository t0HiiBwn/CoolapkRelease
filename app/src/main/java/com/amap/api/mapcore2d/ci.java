package com.amap.api.mapcore2d;

import com.amap.api.maps2d.model.LatLng;

/* compiled from: MapbarCoordConver */
public class ci {
    static double a = 3.141592653589793d;

    public static LatLng a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return cj.a(c(latLng.longitude, latLng.latitude));
    }

    public static double a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static double b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static LatLng c(double d, double d2) {
        double d3 = (double) (((long) (d * 100000.0d)) % 36000000);
        double d4 = (double) (((long) (d2 * 100000.0d)) % 36000000);
        double d5 = (double) ((int) ((-a(d3, d4)) + d3));
        double d6 = (double) ((int) ((-b(d3, d4)) + d4));
        int i = 1;
        double d7 = (double) ((int) ((-a(d5, d6)) + d3 + ((double) (d3 > 0.0d ? 1 : -1))));
        double d8 = (-b(d7, d6)) + d4;
        if (d4 <= 0.0d) {
            i = -1;
        }
        return new LatLng(((double) ((int) (d8 + ((double) i)))) / 100000.0d, d7 / 100000.0d);
    }
}
