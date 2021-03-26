package com.amap.api.mapcore2d;

import com.amap.api.maps2d.model.LatLng;
import java.math.BigDecimal;

/* compiled from: B2GCoordConver */
public class cg {
    public static LatLng a(LatLng latLng) {
        if (latLng != null) {
            return b(latLng);
        }
        return null;
    }

    private static double a(double d) {
        return Math.sin(d * 3000.0d * 0.017453292519943295d) * 2.0E-5d;
    }

    private static double b(double d) {
        return Math.cos(d * 3000.0d * 0.017453292519943295d) * 3.0E-6d;
    }

    private static ch a(double d, double d2) {
        ch chVar = new ch();
        double d3 = (d * d) + (d2 * d2);
        chVar.a = a((Math.cos(b(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.0065d, 8);
        chVar.b = a((Math.sin(b(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.006d, 8);
        return chVar;
    }

    private static double a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    private static LatLng b(LatLng latLng) {
        return a(latLng, 2);
    }

    private static LatLng a(LatLng latLng, int i) {
        LatLng latLng2 = null;
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        for (int i2 = 0; i2 < i; i2++) {
            latLng2 = a(latLng.longitude, latLng.latitude, d, d2);
            d = latLng.longitude - latLng2.longitude;
            d2 = latLng.latitude - latLng2.latitude;
        }
        return latLng2;
    }

    private static LatLng a(double d, double d2, double d3, double d4) {
        ch chVar = new ch();
        double d5 = d - d3;
        double d6 = d2 - d4;
        ch a = a(d5, d6);
        chVar.a = a((d + d5) - a.a, 8);
        chVar.b = a((d2 + d6) - a.b, 8);
        return new LatLng(chVar.b, chVar.a);
    }
}
