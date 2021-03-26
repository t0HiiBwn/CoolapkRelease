package com.bytedance.sdk.a.a;

import java.util.Arrays;

/* compiled from: SegmentedByteString */
final class q extends f {
    final transient byte[][] f;
    final transient int[] g;

    q(c cVar, int i) {
        super(null);
        u.a(cVar.b, 0, (long) i);
        o oVar = cVar.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (oVar.c != oVar.b) {
                i3 += oVar.c - oVar.b;
                i4++;
                oVar = oVar.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f = new byte[i4][];
        this.g = new int[(i4 * 2)];
        o oVar2 = cVar.a;
        int i5 = 0;
        while (i2 < i) {
            this.f[i5] = oVar2.a;
            i2 += oVar2.c - oVar2.b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.g;
            iArr[i5] = i2;
            iArr[this.f.length + i5] = oVar2.b;
            oVar2.d = true;
            i5++;
            oVar2 = oVar2.f;
        }
    }

    @Override // com.bytedance.sdk.a.a.f
    public String a() {
        return i().a();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String b() {
        return i().b();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String e() {
        return i().e();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f f() {
        return i().f();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f c() {
        return i().c();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f d() {
        return i().d();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f a(int i, int i2) {
        return i().a(i, i2);
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte a(int i) {
        int i2;
        u.a((long) this.g[this.f.length - 1], (long) i, 1);
        int b = b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.g[b - 1];
        }
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.bytedance.sdk.a.a.f
    public int g() {
        return this.g[this.f.length - 1];
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte[] h() {
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.a.a.f
    void a(c cVar) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            o oVar = new o(this.f[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.a == null) {
                oVar.g = oVar;
                oVar.f = oVar;
                cVar.a = oVar;
            } else {
                cVar.a.g.a(oVar);
            }
            i++;
            i2 = i4;
        }
        cVar.b += (long) i2;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i, f fVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.g[b - 1];
            }
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr = this.f;
            if (!fVar.a(i2, bArr[b], (i - i4) + iArr[bArr.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.g[b - 1];
            }
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr2 = this.f;
            if (!u.a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private f i() {
        return new f(h());
    }

    @Override // com.bytedance.sdk.a.a.f, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.g() == g() && a(0, fVar, 0, g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.a.a.f, java.lang.Object
    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int[] iArr = this.g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.d = i4;
        return i4;
    }

    @Override // com.bytedance.sdk.a.a.f, java.lang.Object
    public String toString() {
        return i().toString();
    }
}
