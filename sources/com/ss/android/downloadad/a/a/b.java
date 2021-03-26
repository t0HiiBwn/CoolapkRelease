package com.ss.android.downloadad.a.a;

import org.json.JSONObject;

/* compiled from: AdDownloadEventConfig */
public class b implements com.ss.android.a.a.b.b {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private boolean j;
    private boolean k;
    private String l;
    private transient Object m;
    private JSONObject n;
    private JSONObject o;

    public b() {
    }

    private b(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.m = aVar.i;
        this.i = aVar.j;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
    }

    @Override // com.ss.android.a.a.b.b
    public String a() {
        return this.l;
    }

    @Override // com.ss.android.a.a.b.b
    public String b() {
        return this.a;
    }

    @Override // com.ss.android.a.a.b.b
    public String c() {
        return this.b;
    }

    @Override // com.ss.android.a.a.b.b
    public String d() {
        return this.c;
    }

    @Override // com.ss.android.a.a.b.b
    public String e() {
        return this.d;
    }

    @Override // com.ss.android.a.a.b.b
    public String f() {
        return this.e;
    }

    @Override // com.ss.android.a.a.b.b
    public String g() {
        return this.f;
    }

    @Override // com.ss.android.a.a.b.b
    public String h() {
        return this.g;
    }

    @Override // com.ss.android.a.a.b.b
    public String i() {
        return this.h;
    }

    @Override // com.ss.android.a.a.b.b
    public Object j() {
        return this.m;
    }

    @Override // com.ss.android.a.a.b.b
    public int k() {
        return this.i;
    }

    @Override // com.ss.android.a.a.b.b
    public boolean l() {
        return this.j;
    }

    @Override // com.ss.android.a.a.b.b
    public boolean m() {
        return this.k;
    }

    @Override // com.ss.android.a.a.b.b
    public JSONObject n() {
        return this.n;
    }

    @Override // com.ss.android.a.a.b.b
    public JSONObject o() {
        return this.o;
    }

    @Override // com.ss.android.a.a.b.b
    public void a(int i2) {
        this.i = i2;
    }

    @Override // com.ss.android.a.a.b.b
    public void a(String str) {
        this.l = str;
    }

    /* compiled from: AdDownloadEventConfig */
    public static final class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private Object i;
        private int j;
        private boolean k = true;
        private boolean l = false;
        private String m;
        private JSONObject n;
        private JSONObject o;

        @Deprecated
        public a b(boolean z) {
            return this;
        }

        @Deprecated
        public a g(String str) {
            return this;
        }

        public a a(String str) {
            this.a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(String str) {
            this.e = str;
            return this;
        }

        public a e(String str) {
            this.f = str;
            return this;
        }

        public a f(String str) {
            this.g = str;
            return this;
        }

        public a h(String str) {
            this.h = str;
            return this;
        }

        public a a(int i2) {
            this.j = i2;
            return this;
        }

        public a a(boolean z) {
            this.k = z;
            return this;
        }

        public a c(boolean z) {
            this.l = z;
            return this;
        }

        public a i(String str) {
            this.m = str;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}
