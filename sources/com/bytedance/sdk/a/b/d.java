package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c.e;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheControl */
public final class d {
    public static final d a = new a().a().c();
    public static final d b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;

    /* renamed from: l  reason: collision with root package name */
    private final int f1275l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    private d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.d = z;
        this.e = z2;
        this.f = i2;
        this.g = i3;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i4;
        this.f1275l = i5;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.c = str;
    }

    d(a aVar) {
        this.d = aVar.a;
        this.e = aVar.b;
        this.f = aVar.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = aVar.d;
        this.f1275l = aVar.e;
        this.m = aVar.f;
        this.n = aVar.g;
        this.o = aVar.h;
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.f1275l;
    }

    public boolean i() {
        return this.m;
    }

    public boolean j() {
        return this.o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    public static d a(r rVar) {
        int i2;
        int i3;
        String str;
        r rVar2 = rVar;
        int a2 = rVar.a();
        int i4 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i5 = -1;
        int i6 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i7 = -1;
        int i8 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i4 < a2) {
            String a3 = rVar2.a(i4);
            String b2 = rVar2.b(i4);
            if (a3.equalsIgnoreCase("Cache-Control")) {
                if (str2 == null) {
                    str2 = b2;
                    for (i2 = 0; i2 < b2.length(); i2 = i3) {
                        int a4 = e.a(b2, i2, "=,;");
                        String trim = b2.substring(i2, a4).trim();
                        if (a4 == b2.length() || b2.charAt(a4) == ',' || b2.charAt(a4) == ';') {
                            i3 = a4 + 1;
                            str = null;
                        } else {
                            int a5 = e.a(b2, a4 + 1);
                            if (a5 >= b2.length() || b2.charAt(a5) != '\"') {
                                i3 = e.a(b2, a5, ",;");
                                str = b2.substring(a5, i3).trim();
                            } else {
                                int i9 = a5 + 1;
                                int a6 = e.a(b2, i9, "\"");
                                str = b2.substring(i9, a6);
                                i3 = a6 + 1;
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else if ("max-age".equalsIgnoreCase(trim)) {
                            i5 = e.b(str, -1);
                        } else if ("s-maxage".equalsIgnoreCase(trim)) {
                            i6 = e.b(str, -1);
                        } else if ("private".equalsIgnoreCase(trim)) {
                            z4 = true;
                        } else if ("public".equalsIgnoreCase(trim)) {
                            z5 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                            z6 = true;
                        } else if ("max-stale".equalsIgnoreCase(trim)) {
                            i7 = e.b(str, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(trim)) {
                            i8 = e.b(str, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                            z7 = true;
                        } else if ("no-transform".equalsIgnoreCase(trim)) {
                            z8 = true;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z9 = true;
                        }
                    }
                    i4++;
                    rVar2 = rVar;
                }
            } else if (!a3.equalsIgnoreCase("Pragma")) {
                i4++;
                rVar2 = rVar;
            }
            z = false;
            while (i2 < b2.length()) {
            }
            i4++;
            rVar2 = rVar;
        }
        return new d(z2, z3, i5, i6, z4, z5, z6, i7, i8, z7, z8, z9, !z ? null : str2);
    }

    public String toString() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String k2 = k();
        this.c = k2;
        return k2;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.e) {
            sb.append("no-store, ");
        }
        if (this.f != -1) {
            sb.append("max-age=");
            sb.append(this.f);
            sb.append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=");
            sb.append(this.g);
            sb.append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.f1275l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f1275l);
            sb.append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* compiled from: CacheControl */
    public static final class a {
        boolean a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        public a a() {
            this.a = true;
            return this;
        }

        public a a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a b() {
            this.f = true;
            return this;
        }

        public d c() {
            return new d(this);
        }
    }
}
