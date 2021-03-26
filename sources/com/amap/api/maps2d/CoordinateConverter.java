package com.amap.api.maps2d;

import com.amap.api.mapcore2d.cg;
import com.amap.api.mapcore2d.ci;
import com.amap.api.mapcore2d.cj;
import com.amap.api.mapcore2d.cl;
import com.amap.api.maps2d.model.LatLng;

public class CoordinateConverter {
    private CoordType a = null;
    private LatLng b = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter from(CoordType coordType) {
        this.a = coordType;
        return this;
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public LatLng convert() {
        if (this.a == null || this.b == null) {
            return null;
        }
        try {
            switch (AnonymousClass1.a[this.a.ordinal()]) {
                case 1:
                    return cg.a(this.b);
                case 2:
                    return ci.a(this.b);
                case 3:
                case 4:
                case 5:
                case 6:
                    return this.b;
                case 7:
                    return cj.a(this.b);
                default:
                    return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return this.b;
        }
    }

    /* renamed from: com.amap.api.maps2d.CoordinateConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CoordType.values().length];
            a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return cl.a(d, d2);
    }
}
