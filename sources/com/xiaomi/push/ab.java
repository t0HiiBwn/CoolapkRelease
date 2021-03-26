package com.xiaomi.push;

import java.io.InputStream;
import java.util.Vector;

public final class ab {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private final InputStream e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private ab(InputStream inputStream) {
        this.h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.a = new byte[4096];
        this.b = 0;
        this.d = 0;
        this.e = inputStream;
    }

    private ab(byte[] bArr, int i2, int i3) {
        this.h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.a = bArr;
        this.b = i3 + i2;
        this.d = i2;
        this.e = null;
    }

    public static ab a(InputStream inputStream) {
        return new ab(inputStream);
    }

    public static ab a(byte[] bArr, int i2, int i3) {
        return new ab(bArr, i2, i3);
    }

    private boolean a(boolean z) {
        int i2 = this.d;
        int i3 = this.b;
        if (i2 >= i3) {
            int i4 = this.g;
            if (i4 + i3 != this.h) {
                this.g = i4 + i3;
                this.d = 0;
                InputStream inputStream = this.e;
                int read = inputStream == null ? -1 : inputStream.read(this.a);
                this.b = read;
                if (read == 0 || read < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
                } else if (read == -1) {
                    this.b = 0;
                    if (!z) {
                        return false;
                    }
                    throw br.a();
                } else {
                    p();
                    int i5 = this.g + this.b + this.c;
                    if (i5 <= this.k && i5 >= 0) {
                        return true;
                    }
                    throw br.h();
                }
            } else if (!z) {
                return false;
            } else {
                throw br.a();
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
    }

    private void p() {
        int i2 = this.b + this.c;
        this.b = i2;
        int i3 = this.g + i2;
        int i4 = this.h;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.c = i5;
            this.b = i2 - i5;
            return;
        }
        this.c = 0;
    }

    public int a() {
        if (n()) {
            this.f = 0;
            return 0;
        }
        int j2 = j();
        this.f = j2;
        if (j2 != 0) {
            return j2;
        }
        throw br.d();
    }

    public void a(int i2) {
        if (this.f != i2) {
            throw br.e();
        }
    }

    public void a(cs csVar) {
        int j2 = j();
        if (this.i < this.j) {
            int c2 = c(j2);
            this.i++;
            csVar.a(this);
            a(0);
            this.i--;
            d(c2);
            return;
        }
        throw br.g();
    }

    public void b() {
        int a2;
        do {
            a2 = a();
            if (a2 == 0) {
                return;
            }
        } while (b(a2));
    }

    public boolean b(int i2) {
        int a2 = dt.a(i2);
        if (a2 == 0) {
            e();
            return true;
        } else if (a2 == 1) {
            m();
            return true;
        } else if (a2 == 2) {
            f(j());
            return true;
        } else if (a2 == 3) {
            b();
            a(dt.a(dt.b(i2), 4));
            return true;
        } else if (a2 == 4) {
            return false;
        } else {
            if (a2 == 5) {
                l();
                return true;
            }
            throw br.f();
        }
    }

    public int c(int i2) {
        if (i2 >= 0) {
            int i3 = i2 + this.g + this.d;
            int i4 = this.h;
            if (i3 <= i4) {
                this.h = i3;
                p();
                return i4;
            }
            throw br.a();
        }
        throw br.b();
    }

    public long c() {
        return k();
    }

    public long d() {
        return k();
    }

    public void d(int i2) {
        this.h = i2;
        p();
    }

    public int e() {
        return j();
    }

    public byte[] e(int i2) {
        if (i2 >= 0) {
            int i3 = this.g;
            int i4 = this.d;
            int i5 = i3 + i4 + i2;
            int i6 = this.h;
            if (i5 <= i6) {
                int i7 = this.b;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.a, i4, bArr, 0, i2);
                    this.d += i2;
                    return bArr;
                } else if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.a, i4, bArr2, 0, i8);
                    this.d = this.b;
                    while (true) {
                        a(true);
                        int i9 = i2 - i8;
                        int i10 = this.b;
                        if (i9 > i10) {
                            System.arraycopy(this.a, 0, bArr2, i8, i10);
                            int i11 = this.b;
                            i8 += i11;
                            this.d = i11;
                        } else {
                            System.arraycopy(this.a, 0, bArr2, i8, i9);
                            this.d = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.g = i3 + i7;
                    this.d = 0;
                    this.b = 0;
                    int i12 = i7 - i4;
                    int i13 = i2 - i12;
                    Vector vector = new Vector();
                    while (i13 > 0) {
                        int min = Math.min(i13, 4096);
                        byte[] bArr3 = new byte[min];
                        int i14 = 0;
                        while (i14 < min) {
                            InputStream inputStream = this.e;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i14, min - i14);
                            if (read != -1) {
                                this.g += read;
                                i14 += read;
                            } else {
                                throw br.a();
                            }
                        }
                        i13 -= min;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.a, i4, bArr4, 0, i12);
                    for (int i15 = 0; i15 < vector.size(); i15++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i15);
                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                        i12 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                f((i6 - i3) - i4);
                throw br.a();
            }
        } else {
            throw br.b();
        }
    }

    public void f(int i2) {
        if (i2 >= 0) {
            int i3 = this.g;
            int i4 = this.d;
            int i5 = i3 + i4 + i2;
            int i6 = this.h;
            if (i5 <= i6) {
                int i7 = this.b;
                if (i2 <= i7 - i4) {
                    this.d = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.g = i3 + i7;
                this.d = 0;
                this.b = 0;
                while (i8 < i2) {
                    InputStream inputStream = this.e;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip((long) (i2 - i8));
                    if (skip > 0) {
                        i8 += skip;
                        this.g += skip;
                    } else {
                        throw br.a();
                    }
                }
                return;
            }
            f((i6 - i3) - i4);
            throw br.a();
        }
        throw br.b();
    }

    public boolean f() {
        return j() != 0;
    }

    public String g() {
        int j2 = j();
        if (j2 > this.b - this.d || j2 <= 0) {
            return new String(e(j2), "UTF-8");
        }
        String str = new String(this.a, this.d, j2, "UTF-8");
        this.d += j2;
        return str;
    }

    public a h() {
        int j2 = j();
        int i2 = this.b;
        int i3 = this.d;
        if (j2 > i2 - i3 || j2 <= 0) {
            return a.a(e(j2));
        }
        a a2 = a.a(this.a, i3, j2);
        this.d += j2;
        return a2;
    }

    public int i() {
        return j();
    }

    public int j() {
        int i2;
        byte o = o();
        if (o >= 0) {
            return o;
        }
        int i3 = o & Byte.MAX_VALUE;
        byte o2 = o();
        if (o2 >= 0) {
            i2 = o2 << 7;
        } else {
            i3 |= (o2 & Byte.MAX_VALUE) << 7;
            byte o3 = o();
            if (o3 >= 0) {
                i2 = o3 << 14;
            } else {
                i3 |= (o3 & Byte.MAX_VALUE) << 14;
                byte o4 = o();
                if (o4 >= 0) {
                    i2 = o4 << 21;
                } else {
                    int i4 = i3 | ((o4 & Byte.MAX_VALUE) << 21);
                    byte o5 = o();
                    int i5 = i4 | (o5 << 28);
                    if (o5 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (o() >= 0) {
                            return i5;
                        }
                    }
                    throw br.c();
                }
            }
        }
        return i3 | i2;
    }

    public long k() {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte o = o();
            j2 |= ((long) (o & Byte.MAX_VALUE)) << i2;
            if ((o & 128) == 0) {
                return j2;
            }
        }
        throw br.c();
    }

    public int l() {
        return (o() & 255) | ((o() & 255) << 8) | ((o() & 255) << 16) | ((o() & 255) << 24);
    }

    public long m() {
        byte o = o();
        byte o2 = o();
        return ((((long) o2) & 255) << 8) | (((long) o) & 255) | ((((long) o()) & 255) << 16) | ((((long) o()) & 255) << 24) | ((((long) o()) & 255) << 32) | ((((long) o()) & 255) << 40) | ((((long) o()) & 255) << 48) | ((((long) o()) & 255) << 56);
    }

    public boolean n() {
        return this.d == this.b && !a(false);
    }

    public byte o() {
        if (this.d == this.b) {
            a(true);
        }
        byte[] bArr = this.a;
        int i2 = this.d;
        this.d = i2 + 1;
        return bArr[i2];
    }
}
