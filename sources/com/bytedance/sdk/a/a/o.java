package com.bytedance.sdk.a.a;

/* compiled from: Segment */
final class o {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    o f;
    o g;

    o() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    final o a() {
        this.d = true;
        return new o(this.a, this.b, this.c, true, false);
    }

    public final o b() {
        o oVar = this.f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.g;
        oVar3.f = oVar;
        this.f.g = oVar3;
        this.f = null;
        this.g = null;
        return oVar2;
    }

    public final o a(o oVar) {
        oVar.g = this;
        oVar.f = this.f;
        this.f.g = oVar;
        this.f = oVar;
        return oVar;
    }

    public final o a(int i) {
        o oVar;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            oVar = a();
        } else {
            oVar = p.a();
            System.arraycopy(this.a, this.b, oVar.a, 0, i);
        }
        oVar.c = oVar.b + i;
        this.b += i;
        this.g.a(oVar);
        return oVar;
    }

    public final void c() {
        o oVar = this.g;
        if (oVar == this) {
            throw new IllegalStateException();
        } else if (oVar.e) {
            int i = this.c - this.b;
            if (i <= (8192 - oVar.c) + (oVar.d ? 0 : oVar.b)) {
                a(oVar, i);
                b();
                p.a(this);
            }
        }
    }

    public final void a(o oVar, int i) {
        if (oVar.e) {
            int i2 = oVar.c;
            if (i2 + i > 8192) {
                if (!oVar.d) {
                    int i3 = oVar.b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = oVar.a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        oVar.c -= oVar.b;
                        oVar.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, oVar.a, oVar.c, i);
            oVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
