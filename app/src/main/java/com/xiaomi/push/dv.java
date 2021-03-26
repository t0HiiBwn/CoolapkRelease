package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class dv {

    public static final class a extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f324a = Collections.emptyList();

        /* renamed from: a  reason: collision with other field name */
        private boolean f325a;
        private int b = 0;

        /* renamed from: b  reason: collision with other field name */
        private boolean f326b;
        private int c = -1;

        /* renamed from: c  reason: collision with other field name */
        private boolean f327c = false;
        private boolean d;
        private boolean e;
        private boolean f = false;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public int mo211a() {
            if (this.c < 0) {
                mo212b();
            }
            return this.c;
        }

        public a a(int i) {
            this.f325a = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int a2 = bVar.m114a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.c());
                } else if (a2 == 16) {
                    a(bVar.m120a());
                } else if (a2 == 24) {
                    b(bVar.m123b());
                } else if (a2 == 32) {
                    b(bVar.m120a());
                } else if (a2 == 42) {
                    a(bVar.m117a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            Objects.requireNonNull(str);
            if (this.f324a.isEmpty()) {
                this.f324a = new ArrayList();
            }
            this.f324a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f326b = true;
            this.f327c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public List<String> mo211a() {
            return this.f324a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (mo211a()) {
                cVar.m165b(1, c());
            }
            if (m213c()) {
                cVar.m157a(2, mo212b());
            }
            if (m214d()) {
                cVar.m152a(3, d());
            }
            if (f()) {
                cVar.m157a(4, m215e());
            }
            for (String str : mo211a()) {
                cVar.m156a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        /* renamed from: a */
        public boolean mo211a() {
            return this.f325a;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b */
        public int mo212b() {
            int i = 0;
            int b2 = mo211a() ? c.b(1, c()) + 0 : 0;
            if (m213c()) {
                b2 += c.a(2, mo212b());
            }
            if (m214d()) {
                b2 += c.a(3, d());
            }
            if (f()) {
                b2 += c.a(4, m215e());
            }
            for (String str : mo211a()) {
                i += c.a(str);
            }
            int size = b2 + i + (mo211a().size() * 1);
            this.c = size;
            return size;
        }

        public a b(int i) {
            this.d = true;
            this.b = i;
            return this;
        }

        public a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean mo212b() {
            return this.f327c;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m213c() {
            return this.f326b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m214d() {
            return this.d;
        }

        public int e() {
            return this.f324a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m215e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
