package com.amap.api.mapcore2d;

/* compiled from: HashCodeBuilder */
public class dk {
    private final int a;
    private int b;

    public dk() {
        this.b = 0;
        this.a = 37;
        this.b = 17;
    }

    public dk a(boolean z) {
        this.b = (this.b * this.a) + (!z ? 1 : 0);
        return this;
    }

    public dk a(boolean[] zArr) {
        if (zArr == null) {
            this.b *= this.a;
        } else {
            for (boolean z : zArr) {
                a(z);
            }
        }
        return this;
    }

    public dk a(byte b2) {
        this.b = (this.b * this.a) + b2;
        return this;
    }

    public dk a(byte[] bArr) {
        if (bArr == null) {
            this.b *= this.a;
        } else {
            for (byte b2 : bArr) {
                a(b2);
            }
        }
        return this;
    }

    public dk a(char c) {
        this.b = (this.b * this.a) + c;
        return this;
    }

    public dk a(char[] cArr) {
        if (cArr == null) {
            this.b *= this.a;
        } else {
            for (char c : cArr) {
                a(c);
            }
        }
        return this;
    }

    public dk a(double d) {
        return a(Double.doubleToLongBits(d));
    }

    public dk a(double[] dArr) {
        if (dArr == null) {
            this.b *= this.a;
        } else {
            for (double d : dArr) {
                a(d);
            }
        }
        return this;
    }

    public dk a(float f) {
        this.b = (this.b * this.a) + Float.floatToIntBits(f);
        return this;
    }

    public dk a(float[] fArr) {
        if (fArr == null) {
            this.b *= this.a;
        } else {
            for (float f : fArr) {
                a(f);
            }
        }
        return this;
    }

    public dk a(int i) {
        this.b = (this.b * this.a) + i;
        return this;
    }

    public dk a(int[] iArr) {
        if (iArr == null) {
            this.b *= this.a;
        } else {
            for (int i : iArr) {
                a(i);
            }
        }
        return this;
    }

    public dk a(long j) {
        this.b = (this.b * this.a) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public dk a(long[] jArr) {
        if (jArr == null) {
            this.b *= this.a;
        } else {
            for (long j : jArr) {
                a(j);
            }
        }
        return this;
    }

    public dk a(Object obj) {
        if (obj == null) {
            this.b *= this.a;
        } else if (!obj.getClass().isArray()) {
            this.b = (this.b * this.a) + obj.hashCode();
        } else if (obj instanceof long[]) {
            a((long[]) obj);
        } else if (obj instanceof int[]) {
            a((int[]) obj);
        } else if (obj instanceof short[]) {
            a((short[]) obj);
        } else if (obj instanceof char[]) {
            a((char[]) obj);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj);
        } else if (obj instanceof double[]) {
            a((double[]) obj);
        } else if (obj instanceof float[]) {
            a((float[]) obj);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj);
        } else {
            a((Object[]) obj);
        }
        return this;
    }

    public dk a(Object[] objArr) {
        if (objArr == null) {
            this.b *= this.a;
        } else {
            for (Object obj : objArr) {
                a(obj);
            }
        }
        return this;
    }

    public dk a(short s) {
        this.b = (this.b * this.a) + s;
        return this;
    }

    public dk a(short[] sArr) {
        if (sArr == null) {
            this.b *= this.a;
        } else {
            for (short s : sArr) {
                a(s);
            }
        }
        return this;
    }

    public int a() {
        return this.b;
    }

    public int hashCode() {
        return a();
    }
}
