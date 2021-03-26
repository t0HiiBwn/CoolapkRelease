package com.amap.api.col.s;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* compiled from: RequestConfig */
public class ag {
    private static volatile ag r;
    boolean a = true;
    boolean b = true;
    boolean c = true;
    boolean d = true;
    boolean e = true;
    boolean f = true;
    boolean g = true;
    int h = 25;
    int i = 100;
    int j = 100;
    int k = 100;

    /* renamed from: l  reason: collision with root package name */
    int f1198l = 6;
    int m = 100;
    int n = 5000;
    int o = 1200;
    int p = 100000000;
    int q = 16;

    public static ag a() {
        if (r == null) {
            synchronized (ag.class) {
                if (r == null) {
                    r = new ag();
                }
            }
        }
        return r;
    }

    public final void a(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double d2;
        if (!(!this.c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null)) {
            double d3 = 0.0d;
            if (list == null || list.size() == 0) {
                d2 = (double) i.a(fromAndTo.getFrom(), fromAndTo.getTo());
            } else {
                LatLonPoint from = fromAndTo.getFrom();
                LatLonPoint to = fromAndTo.getTo();
                for (LatLonPoint latLonPoint : list) {
                    d3 += (double) i.a(from, latLonPoint);
                    from = latLonPoint;
                }
                d2 = d3 + ((double) i.a(from, to));
            }
            if (((double) this.n) < d2 / 1000.0d) {
                throw new AMapException("起点终点距离过长");
            }
        }
    }

    public final int a(int i2) {
        int i3;
        return (this.d && (i3 = this.m) < i2) ? i3 : i2;
    }

    public final int b(int i2) {
        int i3;
        return (this.d && (i3 = this.h) < i2) ? i3 : i2;
    }

    public final void a(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (this.e && fromAndTo != null && fromAndTo.getFrom() != null && fromAndTo.getTo() != null) {
            if (((double) this.o) < ((double) i.a(fromAndTo.getFrom(), fromAndTo.getTo())) / 1000.0d) {
                throw new AMapException("起点终点距离过长");
            }
        }
    }

    public final void b(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (this.f && fromAndTo != null && fromAndTo.getFrom() != null && fromAndTo.getTo() != null) {
            if (((double) this.k) < ((double) i.a(fromAndTo.getFrom(), fromAndTo.getTo())) / 1000.0d) {
                throw new AMapException("起点终点距离过长");
            }
        }
    }

    public final void a(List<LatLonPoint> list) throws AMapException {
        if (this.g && list != null && this.f1198l < list.size()) {
            throw new AMapException("途经点个数超限");
        }
    }

    public final void b(List<List<LatLonPoint>> list) throws AMapException {
        if (this.a && list != null) {
            if (this.j >= list.size()) {
                for (List<LatLonPoint> list2 : list) {
                    double d2 = 0.0d;
                    if (list2 != null && list2.size() >= 3) {
                        int size = list2.size();
                        int i2 = 0;
                        while (i2 < size) {
                            LatLonPoint latLonPoint = list2.get(i2);
                            i2++;
                            LatLonPoint latLonPoint2 = list2.get(i2 % size);
                            d2 += (((latLonPoint.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint.getLatitude() * 0.017453292519943295d)) * (latLonPoint2.getLatitude() * 111319.49079327357d)) - (((latLonPoint2.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint2.getLatitude() * 0.017453292519943295d)) * (latLonPoint.getLatitude() * 111319.49079327357d));
                        }
                        d2 = Math.abs(d2 / 2.0d);
                    }
                    if (this.q < list2.size()) {
                        throw new AMapException("避让区域点个数超限");
                    } else if (((double) this.p) < d2) {
                        throw new AMapException("避让区域大小超限");
                    }
                }
                return;
            }
            throw new AMapException("避让区域个数超限");
        }
    }

    public final void a(String str) throws AMapException {
        if (str != null && this.b && str.length() > this.i) {
            throw new AMapException("关键字过长");
        }
    }
}
