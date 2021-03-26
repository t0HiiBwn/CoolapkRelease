package com.loc;

import java.util.Locale;

/* compiled from: Cgi */
public final class dv {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = -113;
    public int k = 0;

    /* renamed from: l  reason: collision with root package name */
    public short f1367l = 0;
    public long m = 0;
    public boolean n = false;
    public int o = 32767;
    public boolean p = true;

    public dv(int i2, boolean z) {
        this.k = i2;
        this.n = z;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof dv)) {
            dv dvVar = (dv) obj;
            int i2 = dvVar.k;
            if (i2 != 1) {
                return i2 != 2 ? i2 != 3 ? i2 == 4 && this.k == 4 && dvVar.c == this.c && dvVar.d == this.d && dvVar.b == this.b : this.k == 3 && dvVar.c == this.c && dvVar.d == this.d && dvVar.b == this.b : this.k == 2 && dvVar.i == this.i && dvVar.h == this.h && dvVar.g == this.g;
            }
            if (this.k == 1 && dvVar.c == this.c && dvVar.d == this.d && dvVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int hashCode = String.valueOf(this.k).hashCode();
        if (this.k == 2) {
            i3 = String.valueOf(this.i).hashCode() + String.valueOf(this.h).hashCode();
            i2 = this.g;
        } else {
            i3 = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
            i2 = this.b;
        }
        return hashCode + i3 + String.valueOf(i2).hashCode();
    }

    public final String toString() {
        int i2 = this.k;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : String.format(Locale.CHINA, "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.f1367l), Boolean.valueOf(this.n), Integer.valueOf(this.o)) : String.format(Locale.CHINA, "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.f1367l), Boolean.valueOf(this.n), Integer.valueOf(this.o)) : String.format(Locale.CHINA, "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.i), Integer.valueOf(this.h), Integer.valueOf(this.g), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.f1367l), Boolean.valueOf(this.n)) : String.format(Locale.CHINA, "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.f1367l), Boolean.valueOf(this.n));
    }
}
