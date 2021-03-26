package com.xiaomi.push;

import java.util.Objects;

public final class dd {

    public static final class a extends cs {
        private boolean a;
        private int b = 0;
        private boolean c;
        private long d = 0;
        private boolean e;
        private String f = "";
        private boolean g;
        private String h = "";
        private boolean i;
        private String j = "";
        private boolean k;
        private String l = "";
        private boolean m;
        private String n = "";
        private boolean o;
        private int p = 1;
        private boolean q;
        private int r = 0;
        private boolean s;
        private int t = 0;
        private boolean u;
        private String v = "";
        private int w = -1;

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.w < 0) {
                b();
            }
            return this.w;
        }

        public a a(int i2) {
            this.a = true;
            this.b = i2;
            return this;
        }

        public a a(long j2) {
            this.c = true;
            this.d = j2;
            return this;
        }

        public a a(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (g()) {
                bcVar.b(2, f());
            }
            if (i()) {
                bcVar.a(3, h());
            }
            if (k()) {
                bcVar.a(4, j());
            }
            if (m()) {
                bcVar.a(5, l());
            }
            if (o()) {
                bcVar.a(6, n());
            }
            if (r()) {
                bcVar.a(7, q());
            }
            if (s()) {
                bcVar.a(8, t());
            }
            if (v()) {
                bcVar.a(9, u());
            }
            if (x()) {
                bcVar.a(10, w());
            }
            if (z()) {
                bcVar.a(11, y());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i2 = 0;
            if (e()) {
                i2 = 0 + bc.c(1, d());
            }
            if (g()) {
                i2 += bc.d(2, f());
            }
            if (i()) {
                i2 += bc.b(3, h());
            }
            if (k()) {
                i2 += bc.b(4, j());
            }
            if (m()) {
                i2 += bc.b(5, l());
            }
            if (o()) {
                i2 += bc.b(6, n());
            }
            if (r()) {
                i2 += bc.b(7, q());
            }
            if (s()) {
                i2 += bc.c(8, t());
            }
            if (v()) {
                i2 += bc.c(9, u());
            }
            if (x()) {
                i2 += bc.c(10, w());
            }
            if (z()) {
                i2 += bc.b(11, y());
            }
            this.w = i2;
            return i2;
        }

        public a b(int i2) {
            this.o = true;
            this.p = i2;
            return this;
        }

        /* renamed from: b */
        public a a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                switch (a2) {
                    case 0:
                        return this;
                    case 8:
                        a(abVar.e());
                        break;
                    case 16:
                        a(abVar.d());
                        break;
                    case 26:
                        a(abVar.g());
                        break;
                    case 34:
                        b(abVar.g());
                        break;
                    case 42:
                        c(abVar.g());
                        break;
                    case 50:
                        d(abVar.g());
                        break;
                    case 58:
                        e(abVar.g());
                        break;
                    case 64:
                        b(abVar.e());
                        break;
                    case 72:
                        c(abVar.e());
                        break;
                    case 80:
                        d(abVar.e());
                        break;
                    case 90:
                        f(abVar.g());
                        break;
                    default:
                        if (a(abVar, a2)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a b(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public a c(int i2) {
            this.q = true;
            this.r = i2;
            return this;
        }

        public a c(String str) {
            this.i = true;
            this.j = str;
            return this;
        }

        public int d() {
            return this.b;
        }

        public a d(int i2) {
            this.s = true;
            this.t = i2;
            return this;
        }

        public a d(String str) {
            this.k = true;
            this.l = str;
            return this;
        }

        public a e(String str) {
            this.m = true;
            this.n = str;
            return this;
        }

        public boolean e() {
            return this.a;
        }

        public long f() {
            return this.d;
        }

        public a f(String str) {
            this.u = true;
            this.v = str;
            return this;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public String j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public String l() {
            return this.j;
        }

        public boolean m() {
            return this.i;
        }

        public String n() {
            return this.l;
        }

        public boolean o() {
            return this.k;
        }

        public a p() {
            this.k = false;
            this.l = "";
            return this;
        }

        public String q() {
            return this.n;
        }

        public boolean r() {
            return this.m;
        }

        public boolean s() {
            return this.o;
        }

        public int t() {
            return this.p;
        }

        public int u() {
            return this.r;
        }

        public boolean v() {
            return this.q;
        }

        public int w() {
            return this.t;
        }

        public boolean x() {
            return this.s;
        }

        public String y() {
            return this.v;
        }

        public boolean z() {
            return this.u;
        }
    }

    public static final class b extends cs {
        private boolean a;
        private boolean b = false;
        private boolean c;
        private int d = 0;
        private boolean e;
        private int f = 0;
        private boolean g;
        private int h = 0;
        private int i = -1;

        public static b b(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.i < 0) {
                b();
            }
            return this.i;
        }

        public b a(int i2) {
            this.c = true;
            this.d = i2;
            return this;
        }

        public b a(boolean z) {
            this.a = true;
            this.b = z;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (g()) {
                bcVar.a(3, f());
            }
            if (i()) {
                bcVar.a(4, h());
            }
            if (k()) {
                bcVar.a(5, j());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i2 = 0;
            if (e()) {
                i2 = 0 + bc.b(1, d());
            }
            if (g()) {
                i2 += bc.c(3, f());
            }
            if (i()) {
                i2 += bc.c(4, h());
            }
            if (k()) {
                i2 += bc.c(5, j());
            }
            this.i = i2;
            return i2;
        }

        public b b(int i2) {
            this.e = true;
            this.f = i2;
            return this;
        }

        /* renamed from: b */
        public b a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(abVar.f());
                } else if (a2 == 24) {
                    a(abVar.e());
                } else if (a2 == 32) {
                    b(abVar.e());
                } else if (a2 == 40) {
                    c(abVar.e());
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public b c(int i2) {
            this.g = true;
            this.h = i2;
            return this;
        }

        public boolean d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public int f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public int h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public int j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }
    }

    public static final class c extends cs {
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private String f = "";
        private boolean g;
        private String h = "";
        private boolean i;
        private String j = "";
        private boolean k;
        private String l = "";
        private int m = -1;

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.m < 0) {
                b();
            }
            return this.m;
        }

        public c a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (g()) {
                bcVar.a(2, f());
            }
            if (i()) {
                bcVar.a(3, h());
            }
            if (k()) {
                bcVar.a(4, j());
            }
            if (m()) {
                bcVar.a(5, l());
            }
            if (o()) {
                bcVar.a(6, n());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i2 = 0;
            if (e()) {
                i2 = 0 + bc.b(1, d());
            }
            if (g()) {
                i2 += bc.b(2, f());
            }
            if (i()) {
                i2 += bc.b(3, h());
            }
            if (k()) {
                i2 += bc.b(4, j());
            }
            if (m()) {
                i2 += bc.b(5, l());
            }
            if (o()) {
                i2 += bc.b(6, n());
            }
            this.m = i2;
            return i2;
        }

        /* renamed from: b */
        public c a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(abVar.g());
                } else if (a2 == 18) {
                    b(abVar.g());
                } else if (a2 == 26) {
                    c(abVar.g());
                } else if (a2 == 34) {
                    d(abVar.g());
                } else if (a2 == 42) {
                    e(abVar.g());
                } else if (a2 == 50) {
                    f(abVar.g());
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public c b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public c c(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public c d(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public c e(String str) {
            this.i = true;
            this.j = str;
            return this;
        }

        public boolean e() {
            return this.a;
        }

        public c f(String str) {
            this.k = true;
            this.l = str;
            return this;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public String j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public String l() {
            return this.j;
        }

        public boolean m() {
            return this.i;
        }

        public String n() {
            return this.l;
        }

        public boolean o() {
            return this.k;
        }
    }

    public static final class d extends cs {
        private boolean a;
        private boolean b = false;
        private boolean c;
        private String d = "";
        private boolean e;
        private String f = "";
        private boolean g;
        private String h = "";
        private int i = -1;

        public static d b(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.i < 0) {
                b();
            }
            return this.i;
        }

        public d a(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public d a(boolean z) {
            this.a = true;
            this.b = z;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (g()) {
                bcVar.a(2, f());
            }
            if (i()) {
                bcVar.a(3, h());
            }
            if (k()) {
                bcVar.a(4, j());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i2 = 0;
            if (e()) {
                i2 = 0 + bc.b(1, d());
            }
            if (g()) {
                i2 += bc.b(2, f());
            }
            if (i()) {
                i2 += bc.b(3, h());
            }
            if (k()) {
                i2 += bc.b(4, j());
            }
            this.i = i2;
            return i2;
        }

        /* renamed from: b */
        public d a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(abVar.f());
                } else if (a2 == 18) {
                    a(abVar.g());
                } else if (a2 == 26) {
                    b(abVar.g());
                } else if (a2 == 34) {
                    c(abVar.g());
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public d b(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public d c(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public boolean d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public String j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }
    }

    public static final class e extends cs {
        private boolean a;
        private int b = 0;
        private boolean c;
        private String d = "";
        private boolean e;
        private String f = "";
        private boolean g;
        private String h = "";
        private boolean i;
        private int j = 0;
        private boolean k;
        private String l = "";
        private boolean m;
        private String n = "";
        private boolean o;
        private String p = "";
        private boolean q;
        private b r = null;
        private boolean s;
        private int t = 0;
        private int u = -1;

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.u < 0) {
                b();
            }
            return this.u;
        }

        public e a(int i2) {
            this.a = true;
            this.b = i2;
            return this;
        }

        public e a(b bVar) {
            Objects.requireNonNull(bVar);
            this.q = true;
            this.r = bVar;
            return this;
        }

        public e a(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.b(1, d());
            }
            if (g()) {
                bcVar.a(2, f());
            }
            if (i()) {
                bcVar.a(3, h());
            }
            if (k()) {
                bcVar.a(4, j());
            }
            if (m()) {
                bcVar.a(5, l());
            }
            if (o()) {
                bcVar.a(6, n());
            }
            if (q()) {
                bcVar.a(7, p());
            }
            if (s()) {
                bcVar.a(8, r());
            }
            if (t()) {
                bcVar.a(9, u());
            }
            if (w()) {
                bcVar.a(10, v());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i2 = 0;
            if (e()) {
                i2 = 0 + bc.d(1, d());
            }
            if (g()) {
                i2 += bc.b(2, f());
            }
            if (i()) {
                i2 += bc.b(3, h());
            }
            if (k()) {
                i2 += bc.b(4, j());
            }
            if (m()) {
                i2 += bc.c(5, l());
            }
            if (o()) {
                i2 += bc.b(6, n());
            }
            if (q()) {
                i2 += bc.b(7, p());
            }
            if (s()) {
                i2 += bc.b(8, r());
            }
            if (t()) {
                i2 += bc.b(9, u());
            }
            if (w()) {
                i2 += bc.c(10, v());
            }
            this.u = i2;
            return i2;
        }

        public e b(int i2) {
            this.i = true;
            this.j = i2;
            return this;
        }

        /* renamed from: b */
        public e a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                switch (a2) {
                    case 0:
                        return this;
                    case 8:
                        a(abVar.i());
                        break;
                    case 18:
                        a(abVar.g());
                        break;
                    case 26:
                        b(abVar.g());
                        break;
                    case 34:
                        c(abVar.g());
                        break;
                    case 40:
                        b(abVar.e());
                        break;
                    case 50:
                        d(abVar.g());
                        break;
                    case 58:
                        e(abVar.g());
                        break;
                    case 66:
                        f(abVar.g());
                        break;
                    case 74:
                        b bVar = new b();
                        abVar.a(bVar);
                        a(bVar);
                        break;
                    case 80:
                        c(abVar.e());
                        break;
                    default:
                        if (a(abVar, a2)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e b(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public e c(int i2) {
            this.s = true;
            this.t = i2;
            return this;
        }

        public e c(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.k = true;
            this.l = str;
            return this;
        }

        public e e(String str) {
            this.m = true;
            this.n = str;
            return this;
        }

        public boolean e() {
            return this.a;
        }

        public e f(String str) {
            this.o = true;
            this.p = str;
            return this;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public String j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public int l() {
            return this.j;
        }

        public boolean m() {
            return this.i;
        }

        public String n() {
            return this.l;
        }

        public boolean o() {
            return this.k;
        }

        public String p() {
            return this.n;
        }

        public boolean q() {
            return this.m;
        }

        public String r() {
            return this.p;
        }

        public boolean s() {
            return this.o;
        }

        public boolean t() {
            return this.q;
        }

        public b u() {
            return this.r;
        }

        public int v() {
            return this.t;
        }

        public boolean w() {
            return this.s;
        }
    }

    public static final class f extends cs {
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private b f = null;
        private int g = -1;

        public static f b(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.g < 0) {
                b();
            }
            return this.g;
        }

        public f a(b bVar) {
            Objects.requireNonNull(bVar);
            this.e = true;
            this.f = bVar;
            return this;
        }

        public f a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (g()) {
                bcVar.a(2, f());
            }
            if (h()) {
                bcVar.a(3, i());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i = 0;
            if (e()) {
                i = 0 + bc.b(1, d());
            }
            if (g()) {
                i += bc.b(2, f());
            }
            if (h()) {
                i += bc.b(3, i());
            }
            this.g = i;
            return i;
        }

        /* renamed from: b */
        public f a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(abVar.g());
                } else if (a2 == 18) {
                    b(abVar.g());
                } else if (a2 == 26) {
                    b bVar = new b();
                    abVar.a(bVar);
                    a(bVar);
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public f b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public boolean h() {
            return this.e;
        }

        public b i() {
            return this.f;
        }
    }

    public static final class g extends cs {
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private String f = "";
        private int g = -1;

        public static g b(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.g < 0) {
                b();
            }
            return this.g;
        }

        public g a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (g()) {
                bcVar.a(2, f());
            }
            if (i()) {
                bcVar.a(3, h());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i = 0;
            if (e()) {
                i = 0 + bc.b(1, d());
            }
            if (g()) {
                i += bc.b(2, f());
            }
            if (i()) {
                i += bc.b(3, h());
            }
            this.g = i;
            return i;
        }

        /* renamed from: b */
        public g a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(abVar.g());
                } else if (a2 == 18) {
                    b(abVar.g());
                } else if (a2 == 26) {
                    c(abVar.g());
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public g b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public g c(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }
    }

    public static final class h extends cs {
        private boolean a;
        private int b = 0;
        private boolean c;
        private String d = "";
        private int e = -1;

        public static h b(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        public h a(int i) {
            this.a = true;
            this.b = i;
            return this;
        }

        public h a(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (g()) {
                bcVar.a(2, f());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i = 0;
            if (e()) {
                i = 0 + bc.c(1, d());
            }
            if (g()) {
                i += bc.b(2, f());
            }
            this.e = i;
            return i;
        }

        /* renamed from: b */
        public h a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(abVar.e());
                } else if (a2 == 18) {
                    a(abVar.g());
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public int d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }
    }

    public static final class i extends cs {
        private boolean a;
        private a b = a.a;
        private int c = -1;

        public static i b(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        public i a(a aVar) {
            this.a = true;
            this.b = aVar;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i = 0;
            if (e()) {
                i = 0 + bc.b(1, d());
            }
            this.c = i;
            return i;
        }

        /* renamed from: b */
        public i a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(abVar.h());
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public a d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }
    }

    public static final class j extends cs {
        private boolean a;
        private a b = a.a;
        private boolean c;
        private b d = null;
        private int e = -1;

        public static j b(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        public j a(a aVar) {
            this.a = true;
            this.b = aVar;
            return this;
        }

        public j a(b bVar) {
            Objects.requireNonNull(bVar);
            this.c = true;
            this.d = bVar;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (f()) {
                bcVar.a(2, g());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i = 0;
            if (e()) {
                i = 0 + bc.b(1, d());
            }
            if (f()) {
                i += bc.b(2, g());
            }
            this.e = i;
            return i;
        }

        /* renamed from: b */
        public j a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(abVar.h());
                } else if (a2 == 18) {
                    b bVar = new b();
                    abVar.a(bVar);
                    a(bVar);
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public a d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public boolean f() {
            return this.c;
        }

        public b g() {
            return this.d;
        }
    }

    public static final class k extends cs {
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private long f = 0;
        private boolean g;
        private long h = 0;
        private boolean i;
        private boolean j = false;
        private boolean k;
        private int l = 0;
        private int m = -1;

        public static k b(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.m < 0) {
                b();
            }
            return this.m;
        }

        public k a(int i2) {
            this.k = true;
            this.l = i2;
            return this;
        }

        public k a(long j2) {
            this.e = true;
            this.f = j2;
            return this;
        }

        public k a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        public k a(boolean z) {
            this.i = true;
            this.j = z;
            return this;
        }

        @Override // com.xiaomi.push.cs
        public void a(bc bcVar) {
            if (e()) {
                bcVar.a(1, d());
            }
            if (g()) {
                bcVar.a(2, f());
            }
            if (i()) {
                bcVar.a(3, h());
            }
            if (k()) {
                bcVar.a(4, j());
            }
            if (m()) {
                bcVar.a(5, l());
            }
            if (o()) {
                bcVar.a(6, n());
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i2 = 0;
            if (e()) {
                i2 = 0 + bc.b(1, d());
            }
            if (g()) {
                i2 += bc.b(2, f());
            }
            if (i()) {
                i2 += bc.c(3, h());
            }
            if (k()) {
                i2 += bc.c(4, j());
            }
            if (m()) {
                i2 += bc.b(5, l());
            }
            if (o()) {
                i2 += bc.c(6, n());
            }
            this.m = i2;
            return i2;
        }

        public k b(long j2) {
            this.g = true;
            this.h = j2;
            return this;
        }

        /* renamed from: b */
        public k a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(abVar.g());
                } else if (a2 == 18) {
                    b(abVar.g());
                } else if (a2 == 24) {
                    a(abVar.c());
                } else if (a2 == 32) {
                    b(abVar.c());
                } else if (a2 == 40) {
                    a(abVar.f());
                } else if (a2 == 48) {
                    a(abVar.e());
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public k b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public long h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public long j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public boolean l() {
            return this.j;
        }

        public boolean m() {
            return this.i;
        }

        public int n() {
            return this.l;
        }

        public boolean o() {
            return this.k;
        }
    }
}
