package com.xiaomi.push;

import java.util.Objects;

public final class dw {

    public static final class a extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f328a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f329a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f330a;
        private int b = 1;

        /* renamed from: b  reason: collision with other field name */
        private String f331b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f332b;
        private int c = 0;

        /* renamed from: c  reason: collision with other field name */
        private String f333c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f334c;
        private int d = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f335d = "";

        /* renamed from: d  reason: collision with other field name */
        private boolean f336d;
        private int e = -1;

        /* renamed from: e  reason: collision with other field name */
        private String f337e = "";

        /* renamed from: e  reason: collision with other field name */
        private boolean f338e;
        private String f = "";

        /* renamed from: f  reason: collision with other field name */
        private boolean f339f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.e < 0) {
                mo212b();
            }
            return this.e;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public long mo216a() {
            return this.f328a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public a mo217a() {
            this.f339f = false;
            this.f335d = "";
            return this;
        }

        public a a(int i2) {
            this.f330a = true;
            this.a = i2;
            return this;
        }

        public a a(long j2) {
            this.f332b = true;
            this.f328a = j2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                switch (a2) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m123b());
                        break;
                    case 16:
                        a(bVar.m124b());
                        break;
                    case 26:
                        a(bVar.m117a());
                        break;
                    case 34:
                        b(bVar.m117a());
                        break;
                    case 42:
                        c(bVar.m117a());
                        break;
                    case 50:
                        d(bVar.m117a());
                        break;
                    case 58:
                        e(bVar.m117a());
                        break;
                    case 64:
                        b(bVar.m123b());
                        break;
                    case 72:
                        c(bVar.m123b());
                        break;
                    case 80:
                        d(bVar.m123b());
                        break;
                    case 90:
                        f(bVar.m117a());
                        break;
                    default:
                        if (a(bVar, a2)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a a(String str) {
            this.f334c = true;
            this.f329a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String mo218a() {
            return this.f329a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo219a()) {
                cVar.m152a(1, c());
            }
            if (mo221b()) {
                cVar.m166b(2, mo216a());
            }
            if (m223c()) {
                cVar.m156a(3, mo218a());
            }
            if (m225d()) {
                cVar.m156a(4, mo220b());
            }
            if (m227e()) {
                cVar.m156a(5, m222c());
            }
            if (m229f()) {
                cVar.m156a(6, m224d());
            }
            if (g()) {
                cVar.m156a(7, m226e());
            }
            if (h()) {
                cVar.m152a(8, d());
            }
            if (i()) {
                cVar.m152a(9, e());
            }
            if (j()) {
                cVar.m152a(10, f());
            }
            if (k()) {
                cVar.m156a(11, m228f());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo219a() {
            return this.f330a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i2 = 0;
            if (mo219a()) {
                i2 = 0 + c.a(1, c());
            }
            if (mo221b()) {
                i2 += c.b(2, mo216a());
            }
            if (m223c()) {
                i2 += c.a(3, mo218a());
            }
            if (m225d()) {
                i2 += c.a(4, mo220b());
            }
            if (m227e()) {
                i2 += c.a(5, m222c());
            }
            if (m229f()) {
                i2 += c.a(6, m224d());
            }
            if (g()) {
                i2 += c.a(7, m226e());
            }
            if (h()) {
                i2 += c.a(8, d());
            }
            if (i()) {
                i2 += c.a(9, e());
            }
            if (j()) {
                i2 += c.a(10, f());
            }
            if (k()) {
                i2 += c.a(11, m228f());
            }
            this.e = i2;
            return i2;
        }

        public a b(int i2) {
            this.h = true;
            this.b = i2;
            return this;
        }

        public a b(String str) {
            this.f336d = true;
            this.f331b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String mo220b() {
            return this.f331b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo221b() {
            return this.f332b;
        }

        public int c() {
            return this.a;
        }

        public a c(int i2) {
            this.i = true;
            this.c = i2;
            return this;
        }

        public a c(String str) {
            this.f338e = true;
            this.f333c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m222c() {
            return this.f333c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m223c() {
            return this.f334c;
        }

        public int d() {
            return this.b;
        }

        public a d(int i2) {
            this.j = true;
            this.d = i2;
            return this;
        }

        public a d(String str) {
            this.f339f = true;
            this.f335d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m224d() {
            return this.f335d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m225d() {
            return this.f336d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f337e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m226e() {
            return this.f337e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m227e() {
            return this.f338e;
        }

        public int f() {
            return this.d;
        }

        public a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m228f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m229f() {
            return this.f339f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }
    }

    public static final class b extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private boolean f340a;
        private int b = 0;

        /* renamed from: b  reason: collision with other field name */
        private boolean f341b = false;
        private int c = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f342c;
        private int d = -1;

        /* renamed from: d  reason: collision with other field name */
        private boolean f343d;
        private boolean e;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.d < 0) {
                mo212b();
            }
            return this.d;
        }

        public b a(int i) {
            this.f342c = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public b a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.m120a());
                } else if (a2 == 24) {
                    a(bVar.m123b());
                } else if (a2 == 32) {
                    b(bVar.m123b());
                } else if (a2 == 40) {
                    c(bVar.m123b());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.f340a = true;
            this.f341b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo231b()) {
                cVar.m157a(1, mo230a());
            }
            if (m232c()) {
                cVar.m152a(3, c());
            }
            if (m233d()) {
                cVar.m152a(4, d());
            }
            if (m234e()) {
                cVar.m152a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo230a() {
            return this.f341b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo231b()) {
                i = 0 + c.a(1, mo230a());
            }
            if (m232c()) {
                i += c.a(3, c());
            }
            if (m233d()) {
                i += c.a(4, d());
            }
            if (m234e()) {
                i += c.a(5, e());
            }
            this.d = i;
            return i;
        }

        public b b(int i) {
            this.f343d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo231b() {
            return this.f340a;
        }

        public int c() {
            return this.a;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m232c() {
            return this.f342c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m233d() {
            return this.f343d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m234e() {
            return this.e;
        }
    }

    public static final class c extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private String f344a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f345a;
        private String b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f346b;
        private String c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f347c;
        private String d = "";

        /* renamed from: d  reason: collision with other field name */
        private boolean f348d;
        private String e = "";

        /* renamed from: e  reason: collision with other field name */
        private boolean f349e;
        private String f = "";

        /* renamed from: f  reason: collision with other field name */
        private boolean f350f;

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.a < 0) {
                mo212b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public c a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m117a());
                } else if (a2 == 18) {
                    b(bVar.m117a());
                } else if (a2 == 26) {
                    c(bVar.m117a());
                } else if (a2 == 34) {
                    d(bVar.m117a());
                } else if (a2 == 42) {
                    e(bVar.m117a());
                } else if (a2 == 50) {
                    f(bVar.m117a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            this.f345a = true;
            this.f344a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String mo235a() {
            return this.f344a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo236a()) {
                cVar.m156a(1, mo235a());
            }
            if (mo238b()) {
                cVar.m156a(2, mo237b());
            }
            if (m239c()) {
                cVar.m156a(3, c());
            }
            if (m240d()) {
                cVar.m156a(4, d());
            }
            if (m241e()) {
                cVar.m156a(5, e());
            }
            if (m242f()) {
                cVar.m156a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo236a() {
            return this.f345a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo236a()) {
                i = 0 + c.a(1, mo235a());
            }
            if (mo238b()) {
                i += c.a(2, mo237b());
            }
            if (m239c()) {
                i += c.a(3, c());
            }
            if (m240d()) {
                i += c.a(4, d());
            }
            if (m241e()) {
                i += c.a(5, e());
            }
            if (m242f()) {
                i += c.a(6, f());
            }
            this.a = i;
            return i;
        }

        public c b(String str) {
            this.f346b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String mo237b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo238b() {
            return this.f346b;
        }

        public c c(String str) {
            this.f347c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m239c() {
            return this.f347c;
        }

        public c d(String str) {
            this.f348d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m240d() {
            return this.f348d;
        }

        public c e(String str) {
            this.f349e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m241e() {
            return this.f349e;
        }

        public c f(String str) {
            this.f350f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m242f() {
            return this.f350f;
        }
    }

    public static final class d extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private String f351a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f352a;
        private String b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f353b = false;
        private String c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f354c;
        private boolean d;
        private boolean e;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.a < 0) {
                mo212b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public d a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.m120a());
                } else if (a2 == 18) {
                    a(bVar.m117a());
                } else if (a2 == 26) {
                    b(bVar.m117a());
                } else if (a2 == 34) {
                    c(bVar.m117a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            this.f354c = true;
            this.f351a = str;
            return this;
        }

        public d a(boolean z) {
            this.f352a = true;
            this.f353b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String mo243a() {
            return this.f351a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo246b()) {
                cVar.m157a(1, mo244a());
            }
            if (m247c()) {
                cVar.m156a(2, mo243a());
            }
            if (d()) {
                cVar.m156a(3, mo245b());
            }
            if (e()) {
                cVar.m156a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo244a() {
            return this.f353b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo246b()) {
                i = 0 + c.a(1, mo244a());
            }
            if (m247c()) {
                i += c.a(2, mo243a());
            }
            if (d()) {
                i += c.a(3, mo245b());
            }
            if (e()) {
                i += c.a(4, c());
            }
            this.a = i;
            return i;
        }

        public d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String mo245b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo246b() {
            return this.f352a;
        }

        public d c(String str) {
            this.e = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m247c() {
            return this.f354c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    public static final class e extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private b f355a = null;

        /* renamed from: a  reason: collision with other field name */
        private String f356a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f357a;
        private int b = 0;

        /* renamed from: b  reason: collision with other field name */
        private String f358b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f359b;
        private int c = 0;

        /* renamed from: c  reason: collision with other field name */
        private String f360c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f361c;
        private int d = -1;

        /* renamed from: d  reason: collision with other field name */
        private String f362d = "";

        /* renamed from: d  reason: collision with other field name */
        private boolean f363d;
        private String e = "";

        /* renamed from: e  reason: collision with other field name */
        private boolean f364e;
        private String f = "";

        /* renamed from: f  reason: collision with other field name */
        private boolean f365f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.d < 0) {
                mo212b();
            }
            return this.d;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public b mo248a() {
            return this.f355a;
        }

        public e a(int i2) {
            this.f357a = true;
            this.a = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public e a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                switch (a2) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m117a());
                        break;
                    case 26:
                        b(bVar.m117a());
                        break;
                    case 34:
                        c(bVar.m117a());
                        break;
                    case 40:
                        b(bVar.m123b());
                        break;
                    case 50:
                        d(bVar.m117a());
                        break;
                    case 58:
                        e(bVar.m117a());
                        break;
                    case 66:
                        f(bVar.m117a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m123b());
                        break;
                    default:
                        if (a(bVar, a2)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e a(b bVar) {
            Objects.requireNonNull(bVar);
            this.i = true;
            this.f355a = bVar;
            return this;
        }

        public e a(String str) {
            this.f359b = true;
            this.f356a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String mo249a() {
            return this.f356a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo250a()) {
                cVar.m165b(1, c());
            }
            if (mo252b()) {
                cVar.m156a(2, mo249a());
            }
            if (m254c()) {
                cVar.m156a(3, mo251b());
            }
            if (m256d()) {
                cVar.m156a(4, m253c());
            }
            if (m258e()) {
                cVar.m152a(5, d());
            }
            if (m259f()) {
                cVar.m156a(6, m255d());
            }
            if (g()) {
                cVar.m156a(7, m257e());
            }
            if (h()) {
                cVar.m156a(8, f());
            }
            if (i()) {
                cVar.m155a(9, (e) mo248a());
            }
            if (j()) {
                cVar.m152a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo250a() {
            return this.f357a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i2 = 0;
            if (mo250a()) {
                i2 = 0 + c.b(1, c());
            }
            if (mo252b()) {
                i2 += c.a(2, mo249a());
            }
            if (m254c()) {
                i2 += c.a(3, mo251b());
            }
            if (m256d()) {
                i2 += c.a(4, m253c());
            }
            if (m258e()) {
                i2 += c.a(5, d());
            }
            if (m259f()) {
                i2 += c.a(6, m255d());
            }
            if (g()) {
                i2 += c.a(7, m257e());
            }
            if (h()) {
                i2 += c.a(8, f());
            }
            if (i()) {
                i2 += c.a(9, (e) mo248a());
            }
            if (j()) {
                i2 += c.a(10, e());
            }
            this.d = i2;
            return i2;
        }

        public e b(int i2) {
            this.f364e = true;
            this.b = i2;
            return this;
        }

        public e b(String str) {
            this.f361c = true;
            this.f358b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String mo251b() {
            return this.f358b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo252b() {
            return this.f359b;
        }

        public int c() {
            return this.a;
        }

        public e c(int i2) {
            this.j = true;
            this.c = i2;
            return this;
        }

        public e c(String str) {
            this.f363d = true;
            this.f360c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m253c() {
            return this.f360c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m254c() {
            return this.f361c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f365f = true;
            this.f362d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m255d() {
            return this.f362d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m256d() {
            return this.f363d;
        }

        public int e() {
            return this.c;
        }

        public e e(String str) {
            this.g = true;
            this.e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m257e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m258e() {
            return this.f364e;
        }

        public e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m259f() {
            return this.f365f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }
    }

    public static final class f extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private b f366a = null;

        /* renamed from: a  reason: collision with other field name */
        private String f367a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f368a;
        private String b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f369b;
        private boolean c;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.a < 0) {
                mo212b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public b mo260a() {
            return this.f366a;
        }

        @Override // com.xiaomi.push.e
        public f a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m117a());
                } else if (a2 == 18) {
                    b(bVar.m117a());
                } else if (a2 == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            Objects.requireNonNull(bVar);
            this.c = true;
            this.f366a = bVar;
            return this;
        }

        public f a(String str) {
            this.f368a = true;
            this.f367a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String mo261a() {
            return this.f367a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo262a()) {
                cVar.m156a(1, mo261a());
            }
            if (mo264b()) {
                cVar.m156a(2, mo263b());
            }
            if (c()) {
                cVar.m155a(3, (e) mo260a());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo262a() {
            return this.f368a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo262a()) {
                i = 0 + c.a(1, mo261a());
            }
            if (mo264b()) {
                i += c.a(2, mo263b());
            }
            if (c()) {
                i += c.a(3, (e) mo260a());
            }
            this.a = i;
            return i;
        }

        public f b(String str) {
            this.f369b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String mo263b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo264b() {
            return this.f369b;
        }

        public boolean c() {
            return this.c;
        }
    }

    public static final class g extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private String f370a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f371a;
        private String b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f372b;
        private String c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f373c;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.a < 0) {
                mo212b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public g a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m117a());
                } else if (a2 == 18) {
                    b(bVar.m117a());
                } else if (a2 == 26) {
                    c(bVar.m117a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            this.f371a = true;
            this.f370a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String mo265a() {
            return this.f370a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo266a()) {
                cVar.m156a(1, mo265a());
            }
            if (mo268b()) {
                cVar.m156a(2, mo267b());
            }
            if (m269c()) {
                cVar.m156a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo266a() {
            return this.f371a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo266a()) {
                i = 0 + c.a(1, mo265a());
            }
            if (mo268b()) {
                i += c.a(2, mo267b());
            }
            if (m269c()) {
                i += c.a(3, c());
            }
            this.a = i;
            return i;
        }

        public g b(String str) {
            this.f372b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String mo267b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo268b() {
            return this.f372b;
        }

        public g c(String str) {
            this.f373c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m269c() {
            return this.f373c;
        }
    }

    public static final class h extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f374a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f375a;
        private int b = -1;

        /* renamed from: b  reason: collision with other field name */
        private boolean f376b;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.b < 0) {
                mo212b();
            }
            return this.b;
        }

        public h a(int i) {
            this.f375a = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public h a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.m123b());
                } else if (a2 == 18) {
                    a(bVar.m117a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f376b = true;
            this.f374a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String mo270a() {
            return this.f374a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo271a()) {
                cVar.m152a(1, c());
            }
            if (mo272b()) {
                cVar.m156a(2, mo270a());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo271a() {
            return this.f375a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo271a()) {
                i = 0 + c.a(1, c());
            }
            if (mo272b()) {
                i += c.a(2, mo270a());
            }
            this.b = i;
            return i;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo272b() {
            return this.f376b;
        }

        public int c() {
            return this.a;
        }
    }

    public static final class i extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private a f377a = a.a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f378a;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.a < 0) {
                mo212b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public a mo273a() {
            return this.f377a;
        }

        public i a(a aVar) {
            this.f378a = true;
            this.f377a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public i a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m116a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo274a()) {
                cVar.m154a(1, mo273a());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo274a() {
            return this.f378a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo274a()) {
                i = 0 + c.a(1, mo273a());
            }
            this.a = i;
            return i;
        }
    }

    public static final class j extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private a f379a = a.a;

        /* renamed from: a  reason: collision with other field name */
        private b f380a = null;

        /* renamed from: a  reason: collision with other field name */
        private boolean f381a;
        private boolean b;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.a < 0) {
                mo212b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public a mo275a() {
            return this.f379a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public b mo276a() {
            return this.f380a;
        }

        public j a(a aVar) {
            this.f381a = true;
            this.f379a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public j a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m116a());
                } else if (a2 == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            Objects.requireNonNull(bVar);
            this.b = true;
            this.f380a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo277a()) {
                cVar.m154a(1, mo275a());
            }
            if (mo278b()) {
                cVar.m155a(2, (e) mo276a());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo277a() {
            return this.f381a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo277a()) {
                i = 0 + c.a(1, mo275a());
            }
            if (mo278b()) {
                i += c.a(2, (e) mo276a());
            }
            this.a = i;
            return i;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo278b() {
            return this.b;
        }
    }

    public static final class k extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f382a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f383a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f384a;
        private int b = -1;

        /* renamed from: b  reason: collision with other field name */
        private long f385b = 0;

        /* renamed from: b  reason: collision with other field name */
        private String f386b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f387b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f = false;
        private boolean g;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.b < 0) {
                mo212b();
            }
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public long mo279a() {
            return this.f382a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f382a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public k a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m117a());
                } else if (a2 == 18) {
                    b(bVar.m117a());
                } else if (a2 == 24) {
                    a(bVar.m115a());
                } else if (a2 == 32) {
                    b(bVar.m115a());
                } else if (a2 == 40) {
                    a(bVar.m120a());
                } else if (a2 == 48) {
                    a(bVar.m123b());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            this.f384a = true;
            this.f383a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String mo280a() {
            return this.f383a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo281a()) {
                cVar.m156a(1, mo280a());
            }
            if (mo284b()) {
                cVar.m156a(2, mo283b());
            }
            if (m285c()) {
                cVar.m153a(3, mo279a());
            }
            if (d()) {
                cVar.m153a(4, mo282b());
            }
            if (f()) {
                cVar.m157a(5, e());
            }
            if (g()) {
                cVar.m152a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo281a() {
            return this.f384a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            if (mo281a()) {
                i = 0 + c.a(1, mo280a());
            }
            if (mo284b()) {
                i += c.a(2, mo283b());
            }
            if (m285c()) {
                i += c.a(3, mo279a());
            }
            if (d()) {
                i += c.a(4, mo282b());
            }
            if (f()) {
                i += c.a(5, e());
            }
            if (g()) {
                i += c.a(6, c());
            }
            this.b = i;
            return i;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public long mo282b() {
            return this.f385b;
        }

        public k b(long j) {
            this.d = true;
            this.f385b = j;
            return this;
        }

        public k b(String str) {
            this.f387b = true;
            this.f386b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String mo283b() {
            return this.f386b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo284b() {
            return this.f387b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m285c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.g;
        }
    }
}
