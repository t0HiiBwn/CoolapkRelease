package com.ss.android.downloadad.a.a;

import org.json.JSONObject;

/* compiled from: AdDownloadController */
public class a implements com.ss.android.a.a.b.a {
    private int a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private JSONObject g;
    private boolean h;
    private boolean i;
    private boolean j;
    private Object k;

    /* renamed from: l  reason: collision with root package name */
    private Object f1394l;

    public a() {
        this.h = true;
        this.j = true;
    }

    private a(C0080a aVar) {
        this.h = true;
        this.j = true;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.k = aVar.e;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.h;
        this.f1394l = aVar.i;
        this.h = aVar.j;
        this.i = aVar.k;
        this.j = aVar.f1395l;
    }

    @Override // com.ss.android.a.a.b.a
    public int a() {
        return this.a;
    }

    @Override // com.ss.android.a.a.b.a
    public int b() {
        return this.b;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean c() {
        return this.c;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean d() {
        return this.d;
    }

    @Override // com.ss.android.a.a.b.a
    public void a(int i2) {
        this.b = i2;
    }

    @Override // com.ss.android.a.a.b.a
    public void b(int i2) {
        this.a = i2;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean e() {
        return this.h;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean f() {
        return this.i;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean g() {
        return this.j;
    }

    @Override // com.ss.android.a.a.b.a
    public void a(boolean z) {
        this.j = z;
    }

    /* renamed from: com.ss.android.downloadad.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: AdDownloadController */
    public static final class C0080a {
        private int a;
        private int b;
        private boolean c;
        private boolean d;
        private Object e;
        private boolean f;
        private int g;
        private JSONObject h;
        private Object i;
        private boolean j = true;
        private boolean k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f1395l = true;

        @Deprecated
        public C0080a c(boolean z) {
            return this;
        }

        public C0080a a(int i2) {
            this.a = i2;
            return this;
        }

        public C0080a b(int i2) {
            this.b = i2;
            return this;
        }

        public C0080a a(boolean z) {
            this.c = z;
            return this;
        }

        public C0080a b(boolean z) {
            this.d = z;
            return this;
        }

        public C0080a a(Object obj) {
            this.e = obj;
            return this;
        }

        public C0080a d(boolean z) {
            this.f = z;
            return this;
        }

        public C0080a e(boolean z) {
            this.j = z;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
