package com.amap.api.mapcore2d;

import android.graphics.PointF;

/* compiled from: TileCoordinate */
class bs implements Cloneable {
    public int a = 0;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public PointF g;
    public int h = -1;
    public boolean i = false;
    private String j;

    public bs(int i2, int i3, int i4, int i5) {
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = !cl.a(i2, i3, i4);
        b();
    }

    public bs(bs bsVar) {
        int i2 = bsVar.b;
        this.b = i2;
        int i3 = bsVar.c;
        this.c = i3;
        int i4 = bsVar.d;
        this.d = i4;
        this.e = bsVar.e;
        this.g = bsVar.g;
        this.a = bsVar.a;
        this.f = !cl.a(i2, i3, i4);
        b();
    }

    /* renamed from: a */
    public bs clone() {
        return new bs(this);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bs)) {
            return false;
        }
        bs bsVar = (bs) obj;
        if (this.b == bsVar.b && this.c == bsVar.c && this.d == bsVar.d && this.e == bsVar.e) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.b * 7) + (this.c * 11) + (this.d * 13) + this.e;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.b + "-" + this.c + "-" + this.d + "-" + this.e;
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append("-");
        sb.append(this.c);
        sb.append("-");
        sb.append(this.d);
        if (this.f && q.i == 1) {
            sb.append("-");
            sb.append(1);
        }
        this.j = sb.toString();
    }

    public String c() {
        return this.j;
    }
}
