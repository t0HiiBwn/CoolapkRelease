package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class dc {

    public static final class a extends cs {
        private boolean a;
        private int b = 0;
        private boolean c;
        private boolean d = false;
        private boolean e;
        private int f = 0;
        private boolean g;
        private boolean h = false;
        private List<String> i = Collections.emptyList();
        private int j = -1;

        public static a b(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a c(ab abVar) {
            return new a().a(abVar);
        }

        @Override // com.xiaomi.push.cs
        public int a() {
            if (this.j < 0) {
                b();
            }
            return this.j;
        }

        public a a(int i2) {
            this.a = true;
            this.b = i2;
            return this;
        }

        public a a(String str) {
            Objects.requireNonNull(str);
            if (this.i.isEmpty()) {
                this.i = new ArrayList();
            }
            this.i.add(str);
            return this;
        }

        public a a(boolean z) {
            this.c = true;
            this.d = z;
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
            for (String str : l()) {
                bcVar.a(5, str);
            }
        }

        @Override // com.xiaomi.push.cs
        public int b() {
            int i2 = 0;
            int d2 = e() ? bc.d(1, d()) + 0 : 0;
            if (g()) {
                d2 += bc.b(2, f());
            }
            if (i()) {
                d2 += bc.c(3, h());
            }
            if (k()) {
                d2 += bc.b(4, j());
            }
            for (String str : l()) {
                i2 += bc.b(str);
            }
            int size = d2 + i2 + (l().size() * 1);
            this.j = size;
            return size;
        }

        public a b(int i2) {
            this.e = true;
            this.f = i2;
            return this;
        }

        /* renamed from: b */
        public a a(ab abVar) {
            while (true) {
                int a2 = abVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(abVar.i());
                } else if (a2 == 16) {
                    a(abVar.f());
                } else if (a2 == 24) {
                    b(abVar.e());
                } else if (a2 == 32) {
                    b(abVar.f());
                } else if (a2 == 42) {
                    a(abVar.g());
                } else if (!a(abVar, a2)) {
                    return this;
                }
            }
        }

        public a b(boolean z) {
            this.g = true;
            this.h = z;
            return this;
        }

        public int d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public boolean f() {
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

        public boolean j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public List<String> l() {
            return this.i;
        }

        public int m() {
            return this.i.size();
        }
    }
}
