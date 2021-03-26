package com.amap.api.mapcore2d;

/* compiled from: GeoPoint */
public class w {
    private long a;
    private long b;
    private double c;
    private double d;

    public w() {
        this.a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.a = 0;
        this.b = 0;
    }

    public w(int i, int i2) {
        this.a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.a = (long) i;
        this.b = (long) i2;
    }

    w(double d2, double d3, boolean z) {
        this.a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        if (z) {
            this.a = (long) (d2 * 1000000.0d);
            this.b = (long) (d3 * 1000000.0d);
            return;
        }
        this.c = d2;
        this.d = d3;
    }

    public void a(double d2) {
        this.d = d2;
    }

    public void b(double d2) {
        this.c = d2;
    }

    private w(double d2, double d3, long j, long j2) {
        this.a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.c = d2;
        this.d = d3;
        this.a = j;
        this.b = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        w wVar = (w) obj;
        return this.a == wVar.a && this.b == wVar.b && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(wVar.c) && Double.doubleToLongBits(this.d) == Double.doubleToLongBits(wVar.d);
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        long doubleToLongBits = Double.doubleToLongBits(this.c);
        long doubleToLongBits2 = Double.doubleToLongBits(this.d);
        return ((((((((int) (j ^ (j >>> 32))) + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public int a() {
        return (int) this.b;
    }

    public int b() {
        return (int) this.a;
    }

    public long c() {
        return this.b;
    }

    public long d() {
        return this.a;
    }

    public double e() {
        if (Double.doubleToLongBits(this.d) == Double.doubleToLongBits(Double.MIN_VALUE)) {
            this.d = (r.a(this.b) * 2.003750834E7d) / 180.0d;
        }
        return this.d;
    }

    public double f() {
        if (Double.doubleToLongBits(this.c) == Double.doubleToLongBits(Double.MIN_VALUE)) {
            this.c = ((Math.log(Math.tan(((r.a(this.a) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d;
        }
        return this.c;
    }

    public w g() {
        return new w(this.c, this.d, this.a, this.b);
    }
}
