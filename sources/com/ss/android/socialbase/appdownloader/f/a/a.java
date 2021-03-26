package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: AXmlResourceParser */
class a implements i {
    private d b;
    private boolean c = false;
    private f d;
    private int[] e;
    private C0101a f = new C0101a();
    private boolean g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private int m;
    private int n;
    private int o;

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int f() {
        return -1;
    }

    public a() {
        g();
    }

    public void a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            this.b = new d(inputStream, false);
        }
    }

    public void a() {
        if (this.c) {
            this.c = false;
            this.b.a();
            this.b = null;
            this.d = null;
            this.e = null;
            this.f.a();
            g();
        }
    }

    public int b() throws h, IOException {
        if (this.b != null) {
            try {
                h();
                return this.h;
            } catch (IOException e2) {
                a();
                throw e2;
            }
        } else {
            throw new h("Parser is not opened.", this, null);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int c() {
        return this.i;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public String d() {
        return "XML line #" + c();
    }

    public int e() {
        if (this.h != 2) {
            return -1;
        }
        return this.l.length / 5;
    }

    public String a(int i2) {
        int i3 = this.l[e(i2) + 1];
        if (i3 == -1) {
            return "";
        }
        return this.d.a(i3);
    }

    public int b(int i2) {
        return this.l[e(i2) + 3];
    }

    public int c(int i2) {
        return this.l[e(i2) + 4];
    }

    public String d(int i2) {
        int e2 = e(i2);
        int[] iArr = this.l;
        if (iArr[e2 + 3] == 3) {
            return this.d.a(iArr[e2 + 2]);
        }
        int i3 = iArr[e2 + 4];
        return "";
    }

    private final int e(int i2) {
        if (this.h == 2) {
            int i3 = i2 * 5;
            if (i3 < this.l.length) {
                return i3;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    private final void g() {
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.o = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x018e, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    private final void h() throws IOException {
        int i2;
        int b2;
        if (this.d == null) {
            b.a(this.b, 524291);
            this.b.c();
            this.d = f.a(this.b);
            this.f.e();
            this.c = true;
        }
        int i3 = this.h;
        if (i3 != 1) {
            g();
            while (true) {
                if (this.g) {
                    this.g = false;
                    this.f.f();
                }
                int i4 = 3;
                if (i3 == 3 && this.f.d() == 1 && this.f.b() == 0) {
                    this.h = 1;
                    return;
                }
                if (i3 == 0) {
                    i2 = 1048834;
                } else {
                    i2 = this.b.b();
                }
                if (i2 == 524672) {
                    b2 = this.b.b();
                    if (b2 < 8 || b2 % 4 != 0) {
                        break;
                    }
                    this.e = this.b.b((b2 / 4) - 2);
                } else if (i2 < 1048832 || i2 > 1048836) {
                    break;
                } else if (i2 == 1048834 && i3 == -1) {
                    this.h = 0;
                    return;
                } else {
                    this.b.c();
                    int b3 = this.b.b();
                    this.b.c();
                    if (i2 != 1048832 && i2 != 1048833) {
                        this.i = b3;
                        if (i2 == 1048834) {
                            this.k = this.b.b();
                            this.j = this.b.b();
                            this.b.c();
                            int b4 = this.b.b();
                            this.m = (b4 >>> 16) - 1;
                            int b5 = this.b.b();
                            this.n = b5;
                            this.o = (b5 >>> 16) - 1;
                            this.n = (65535 & b5) - 1;
                            this.l = this.b.b((b4 & 65535) * 5);
                            while (true) {
                                int[] iArr = this.l;
                                if (i4 < iArr.length) {
                                    iArr[i4] = iArr[i4] >>> 24;
                                    i4 += 5;
                                } else {
                                    this.f.e();
                                    this.h = 2;
                                    return;
                                }
                            }
                        } else if (i2 == 1048835) {
                            this.k = this.b.b();
                            this.j = this.b.b();
                            this.h = 3;
                            this.g = true;
                            return;
                        } else if (i2 == 1048836) {
                            this.j = this.b.b();
                            this.b.c();
                            this.b.c();
                            this.h = 4;
                            return;
                        }
                    } else if (i2 == 1048832) {
                        this.f.a(this.b.b(), this.b.b());
                    } else {
                        this.b.c();
                        this.b.c();
                        this.f.c();
                    }
                }
            }
            throw new IOException("Invalid resource ids size (" + b2 + ").");
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.f.a.a$a  reason: collision with other inner class name */
    /* compiled from: AXmlResourceParser */
    private static final class C0101a {
        private int[] a = new int[32];
        private int b;
        private int c;

        public final void a() {
            this.b = 0;
            this.c = 0;
        }

        public final int b() {
            int i = this.b;
            if (i == 0) {
                return 0;
            }
            return this.a[i - 1];
        }

        public final void a(int i, int i2) {
            if (this.c == 0) {
                e();
            }
            a(2);
            int i3 = this.b;
            int i4 = i3 - 1;
            int[] iArr = this.a;
            int i5 = iArr[i4];
            int i6 = i5 + 1;
            iArr[(i4 - 1) - (i5 * 2)] = i6;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i6;
            this.b = i3 + 2;
        }

        public final boolean c() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.b;
            if (i3 == 0 || (i2 = (iArr = this.a)[i3 - 1]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.b = i3 - 2;
            return true;
        }

        public final int d() {
            return this.c;
        }

        public final void e() {
            a(2);
            int i = this.b;
            int[] iArr = this.a;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.b = i + 2;
            this.c++;
        }

        public final void f() {
            int i = this.b;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.a[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.b = i - (i3 + 2);
                    this.c--;
                }
            }
        }

        private void a(int i) {
            int[] iArr = this.a;
            int length = iArr.length;
            int i2 = this.b;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[((iArr.length + i3) * 2)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.a = iArr2;
            }
        }
    }
}
