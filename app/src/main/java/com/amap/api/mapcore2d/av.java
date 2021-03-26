package com.amap.api.mapcore2d;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.mapcore2d.az;
import java.util.ArrayList;

/* compiled from: MapProjection */
class av {
    public int a = 256;
    public int b = 256;
    float c = 1.0f;
    public double d = 156543.0339d;
    int e = 0;
    double f = -2.003750834E7d;
    double g = 2.003750834E7d;
    public int h = q.d;
    public int i = q.c;
    public float j = 10.0f;
    public double k = 0.0d;

    /* renamed from: l  reason: collision with root package name */
    public w f1218l = null;
    public w m = null;
    public Point n = null;
    public a o = null;
    az.c p = null;
    private double q = 116.39716d;
    private double r = 39.91669d;
    private double s = 0.01745329251994329d;

    public av(az.c cVar) {
        this.p = cVar;
    }

    public void a() {
        double d2 = (this.g * 2.0d) / ((double) this.a);
        this.d = d2;
        float f2 = this.j;
        int i2 = (int) f2;
        this.k = (d2 / ((double) (1 << i2))) / ((double) ((f2 + 1.0f) - ((float) i2)));
        w a2 = a(new w(this.r, this.q, true));
        this.f1218l = a2;
        this.m = a2.g();
        this.n = new Point(this.p.c() / 2, this.p.d() / 2);
        a aVar = new a();
        this.o = aVar;
        aVar.a = -2.0037508E7f;
        this.o.b = 2.0037508E7f;
        this.o.c = 2.0037508E7f;
        this.o.d = -2.0037508E7f;
    }

    public void a(Point point) {
        this.n = point;
    }

    public w a(w wVar) {
        if (wVar == null) {
            return null;
        }
        return new w(((Math.log(Math.tan((((((double) wVar.b()) / 1000000.0d) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d, ((((double) wVar.a()) / 1000000.0d) * 2.003750834E7d) / 180.0d, false);
    }

    PointF a(w wVar, w wVar2, Point point, double d2) {
        Throwable th;
        PointF pointF = null;
        if (wVar == null || wVar2 == null) {
            return null;
        }
        try {
            PointF pointF2 = new PointF();
            try {
                pointF2.x = (float) (((wVar.e() - wVar2.e()) / d2) + ((double) point.x));
                pointF2.y = (float) (((double) point.y) - ((wVar.f() - wVar2.f()) / d2));
                return pointF2;
            } catch (Throwable th2) {
                th = th2;
                pointF = pointF2;
            }
        } catch (Throwable th3) {
            th = th3;
            cm.a(th, "MapProjection", "convertProjectionToScreen");
            return pointF;
        }
    }

    public w b(w wVar) {
        if (wVar == null) {
            return null;
        }
        return new w((int) (((double) ((float) (((Math.atan(Math.exp((((double) ((float) ((wVar.f() * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d))) * 1000000.0d), (int) (((double) ((float) ((wVar.e() * 180.0d) / 2.003750834E7d))) * 1000000.0d));
    }

    public w a(PointF pointF, w wVar, Point point, double d2, a aVar) {
        return b(b(pointF, wVar, point, d2, aVar));
    }

    w b(PointF pointF, w wVar, Point point, double d2, a aVar) {
        az.c cVar = this.p;
        if (cVar == null || pointF == null || wVar == null || point == null || aVar == null) {
            return null;
        }
        PointF c2 = cVar.g().c(pointF);
        double e2 = wVar.e() + (((double) (c2.x - ((float) point.x))) * d2);
        double f2 = wVar.f() - (((double) (c2.y - ((float) point.y))) * d2);
        while (e2 < ((double) aVar.a)) {
            e2 += (double) (aVar.b - aVar.a);
        }
        double d3 = e2;
        while (d3 > ((double) aVar.b)) {
            d3 -= (double) (aVar.b - aVar.a);
        }
        while (f2 < ((double) aVar.d)) {
            f2 += (double) (aVar.c - aVar.d);
        }
        double d4 = f2;
        while (d4 > ((double) aVar.c)) {
            d4 -= (double) (aVar.c - aVar.d);
        }
        return new w(d4, d3, false);
    }

    public PointF b(w wVar, w wVar2, Point point, double d2) {
        if (this.p == null || wVar == null || wVar2 == null || point == null) {
            return null;
        }
        return this.p.g().b(a(a(wVar), wVar2, point, d2));
    }

    int b() {
        float f2 = this.j;
        int i2 = (int) f2;
        return ((double) (f2 - ((float) i2))) < az.a ? i2 : i2 + 1;
    }

    public PointF a(int i2, int i3) {
        double d2;
        int i4 = this.a;
        double d3 = this.k;
        double d4 = (((double) (i2 * i4)) * d3) + this.f;
        int i5 = this.e;
        if (i5 == 0) {
            d2 = this.g - (((double) (i3 * i4)) * d3);
        } else {
            d2 = i5 == 1 ? ((double) ((i3 + 1) * i4)) * d3 : 0.0d;
        }
        return a(new w(d2, d4, false), this.f1218l, this.n, this.k);
    }

    public ArrayList<bs> a(w wVar, int i2, int i3, int i4) {
        double d2;
        int i5;
        int i6;
        double d3 = this.k;
        double e2 = wVar.e();
        double d4 = this.f;
        int i7 = this.a;
        int i8 = (int) ((e2 - d4) / (((double) i7) * d3));
        double d5 = (((double) (i7 * i8)) * d3) + d4;
        int i9 = this.e;
        if (i9 == 0) {
            double f2 = this.g - wVar.f();
            int i10 = this.a;
            int i11 = (int) (f2 / (((double) i10) * d3));
            i5 = i11;
            d2 = this.g - (((double) (i10 * i11)) * d3);
        } else if (i9 == 1) {
            double f3 = wVar.f() - this.g;
            int i12 = this.a;
            int i13 = (int) (f3 / (((double) i12) * d3));
            i5 = i13;
            d2 = ((double) ((i13 + 1) * i12)) * d3;
        } else {
            d2 = 0.0d;
            i5 = 0;
        }
        PointF a2 = a(new w(d2, d5, false), wVar, this.n, d3);
        bs bsVar = new bs(i8, i5, b(), -1);
        bsVar.g = a2;
        ArrayList<bs> arrayList = new ArrayList<>();
        arrayList.add(bsVar);
        int i14 = 1;
        while (true) {
            int i15 = i8 - i14;
            int i16 = i15;
            boolean z = false;
            while (true) {
                i6 = i8 + i14;
                if (i16 > i6) {
                    break;
                }
                int i17 = i5 + i14;
                try {
                    PointF a3 = a(i16, i17, i8, i5, a2, i3, i4);
                    if (a3 != null) {
                        boolean z2 = !z ? true : z;
                        bs bsVar2 = new bs(i16, i17, b(), -1);
                        bsVar2.g = a3;
                        arrayList.add(bsVar2);
                        z = z2;
                    }
                    int i18 = i5 - i14;
                    PointF a4 = a(i16, i18, i8, i5, a2, i3, i4);
                    if (a4 != null) {
                        boolean z3 = !z ? true : z;
                        bs bsVar3 = new bs(i16, i18, b(), -1);
                        bsVar3.g = a4;
                        arrayList.add(bsVar3);
                        z = z3;
                    }
                    i16++;
                    i5 = i5;
                } catch (Error e3) {
                    cm.a(e3, "MapProjection", "getTilesInDomain");
                }
            }
            int i19 = (i5 + i14) - 1;
            while (i19 > i5 - i14) {
                PointF a5 = a(i6, i19, i8, i5, a2, i3, i4);
                if (a5 != null) {
                    boolean z4 = !z ? true : z;
                    bs bsVar4 = new bs(i6, i19, b(), -1);
                    bsVar4.g = a5;
                    arrayList.add(bsVar4);
                    z = z4;
                }
                PointF a6 = a(i15, i19, i8, i5, a2, i3, i4);
                if (a6 != null) {
                    boolean z5 = !z ? true : z;
                    bs bsVar5 = new bs(i15, i19, b(), -1);
                    bsVar5.g = a6;
                    arrayList.add(bsVar5);
                    z = z5;
                }
                i19--;
                i6 = i6;
            }
            if (!z) {
                break;
            }
            i14++;
            i5 = i5;
        }
        return arrayList;
    }

    PointF a(int i2, int i3, int i4, int i5, PointF pointF, int i6, int i7) {
        PointF pointF2 = new PointF();
        pointF2.x = ((float) ((i2 - i4) * this.a)) + pointF.x;
        int i8 = this.e;
        if (i8 == 0) {
            pointF2.y = ((float) ((i3 - i5) * this.a)) + pointF.y;
        } else if (i8 == 1) {
            pointF2.y = pointF.y - ((float) ((i3 - i5) * this.a));
        }
        if (pointF2.x + ((float) this.a) <= 0.0f || pointF2.x >= ((float) i6) || pointF2.y + ((float) this.a) <= 0.0f || pointF2.y >= ((float) i7)) {
            return null;
        }
        return pointF2;
    }

    public void a(PointF pointF, PointF pointF2, float f2) {
        if (this.f1218l != null) {
            double[] b2 = b(pointF, pointF2);
            this.f1218l.b(b2[1]);
            this.f1218l.a(b2[0]);
        }
    }

    public w a(PointF pointF, PointF pointF2) {
        double[] b2 = b(pointF, pointF2);
        w wVar = new w(this.f1218l.b(), this.f1218l.a());
        wVar.b(b2[1]);
        wVar.a(b2[0]);
        return wVar;
    }

    private double[] b(PointF pointF, PointF pointF2) {
        double d2 = this.k;
        w b2 = b(pointF, this.f1218l, this.n, d2, this.o);
        w b3 = b(pointF2, this.f1218l, this.n, d2, this.o);
        double e2 = b3.e() - b2.e();
        double f2 = b3.f() - b2.f();
        double e3 = this.f1218l.e() + e2;
        double f3 = this.f1218l.f() + f2;
        while (e3 < ((double) this.o.a)) {
            e3 += (double) (this.o.b - this.o.a);
        }
        while (e3 > ((double) this.o.b)) {
            e3 -= (double) (this.o.b - this.o.a);
        }
        while (f3 < ((double) this.o.d)) {
            f3 += (double) (this.o.c - this.o.d);
        }
        while (f3 > ((double) this.o.c)) {
            f3 -= (double) (this.o.c - this.o.d);
        }
        return new double[]{e3, f3};
    }

    public float a(w wVar, w wVar2) {
        if (wVar == null || wVar2 == null) {
            return 0.0f;
        }
        double a2 = r.a(wVar.c());
        double a3 = r.a(wVar.d());
        double a4 = r.a(wVar2.c());
        double a5 = r.a(wVar2.d());
        double d2 = this.s;
        double d3 = a2 * d2;
        double d4 = a3 * d2;
        double d5 = a4 * d2;
        double d6 = a5 * d2;
        double sin = Math.sin(d3);
        double sin2 = Math.sin(d4);
        double cos = Math.cos(d3);
        double cos2 = Math.cos(d4);
        double sin3 = Math.sin(d5);
        double sin4 = Math.sin(d6);
        double cos3 = Math.cos(d5);
        double cos4 = Math.cos(d6);
        double[] dArr = {cos * cos2, cos2 * sin, sin2};
        double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
        return (float) (Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d);
    }

    /* compiled from: MapProjection */
    static class a {
        float a;
        float b;
        float c;
        float d;

        a() {
        }
    }
}
