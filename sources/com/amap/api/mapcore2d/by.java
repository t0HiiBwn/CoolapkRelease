package com.amap.api.mapcore2d;

/* compiled from: TransAnim */
class by extends e {
    private w c;
    private w d;
    private int e;
    private int f = ((int) this.c.f());
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* renamed from: l  reason: collision with root package name */
    private bz f1225l;
    private long m;
    private int n;

    public by(int i2, int i3, w wVar, w wVar2, int i4, bz bzVar) {
        super(i2, i3);
        this.c = wVar;
        this.d = wVar2;
        this.e = (int) wVar.e();
        this.f1225l = bzVar;
        this.i = (int) Math.abs(wVar2.e() - this.c.e());
        this.j = (int) Math.abs(wVar2.f() - this.c.f());
        this.m = System.currentTimeMillis();
        this.n = i2;
    }

    private void b(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.m = currentTimeMillis;
        float f2 = ((float) ((int) (currentTimeMillis - this.m))) / ((float) i2);
        this.g = (int) (((float) this.i) * f2);
        this.h = (int) (((float) this.j) * f2);
    }

    @Override // com.amap.api.mapcore2d.e
    protected void c() {
        this.f1225l.c();
        l.a().b();
    }

    @Override // com.amap.api.mapcore2d.e
    protected void b() {
        this.f1225l.c();
        n.a().b();
    }

    @Override // com.amap.api.mapcore2d.e
    protected void a() {
        b(this.n);
        int e2 = (int) this.d.e();
        int f2 = (int) this.d.f();
        if (!f()) {
            this.e = e2;
            this.f = f2;
            this.f1225l.a(new w((double) f2, (double) e2, false));
            return;
        }
        this.k++;
        this.e = a(this.e, e2, this.g);
        int a = a(this.f, f2, this.h);
        this.f = a;
        this.f1225l.a(new w((double) a, (double) this.e, false));
        if (this.e == e2 && this.f == f2) {
            a(false);
            b(true);
            g();
        }
    }

    private int a(int i2, int i3, int i4) {
        int i5;
        if (i3 > i2) {
            i5 = i2 + i4;
            if (i5 >= i3) {
                this.k = 0;
                return i3;
            }
        } else {
            i5 = i2 - i4;
            if (i5 <= i3) {
                this.k = 0;
                return i3;
            }
        }
        return i5;
    }

    protected void g() {
        bm.a().b();
    }
}
