package com.amap.api.mapcore2d;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.animation.Animation;

/* compiled from: ZoomCtlAnim */
class cf extends e {
    public float c;
    public boolean d;
    private Animation.AnimationListener e;
    private b f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1227l;
    private boolean m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cf(b bVar, Animation.AnimationListener animationListener, int i2) {
        super(i2 < 160 ? 160 : i2, 40);
        this.m = false;
        this.c = -1.0f;
        this.d = false;
        this.f = bVar;
        this.e = animationListener;
        this.a /= 2;
    }

    @Override // com.amap.api.mapcore2d.e
    public void a(int i2) {
        this.a = i2 / 2;
    }

    @Override // com.amap.api.mapcore2d.e
    protected void a() {
        try {
            b bVar = this.f;
            if (bVar == null) {
                return;
            }
            if (bVar.a != null) {
                if (this.f1227l) {
                    this.f.a.h.c += this.k;
                } else {
                    this.f.a.h.c -= this.k;
                }
                Matrix matrix = new Matrix();
                matrix.setScale(this.f.a.h.c, this.f.a.h.c, this.g, this.h);
                b bVar2 = this.f;
                bVar2.c(bVar2.a.h.c);
                this.f.b(matrix);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore2d.e
    protected void c() {
        b();
    }

    @Override // com.amap.api.mapcore2d.e
    protected void b() {
        if (!this.m) {
            try {
                b bVar = this.f;
                if (bVar == null) {
                    return;
                }
                if (bVar.a() != null) {
                    this.f.a().e.b = false;
                    if (this.d) {
                        Point point = new Point((int) this.g, (int) this.h);
                        w a = this.f.d().a((int) this.g, (int) this.h);
                        this.f.a().h.f1218l = this.f.a().h.a(a);
                        this.f.a().h.a(point);
                        this.f.a().c.a(false, false);
                    }
                    this.f.i().c(this.c);
                    this.e.onAnimationEnd(null);
                    if (this.d) {
                        Point point2 = new Point(this.f.a().c.c() / 2, this.f.a().c.d() / 2);
                        w a2 = this.f.d().a(this.f.a().c.c() / 2, this.f.a().c.d() / 2);
                        this.f.a().h.f1218l = this.f.a().h.a(a2);
                        this.f.a().h.a(point2);
                        this.f.a().c.a(false, false);
                    }
                    this.f.a.h.c = 1.0f;
                    bb.j = 1.0f;
                    this.f.a().a(true);
                    l.a().b();
                    this.a = 160;
                }
            } catch (Exception e2) {
                cm.a(e2, "ZoomCtlAnim", "onStop");
            }
        }
    }

    public void a(float f2, float f3, boolean z, float f4, float f5) {
        this.f1227l = z;
        this.g = f4;
        this.h = f5;
        this.i = f2;
        this.f.a.h.c = this.i;
        if (this.f1227l) {
            this.k = (this.f.a.h.c * ((float) this.b)) / ((float) this.a);
            this.j = this.i * 2.0f;
            return;
        }
        this.k = ((this.f.a.h.c * 0.5f) * ((float) this.b)) / ((float) this.a);
        this.j = this.i * 0.5f;
    }

    public void a(float f2, boolean z, float f3, float f4) {
        this.f.c[0] = this.f.c[1];
        this.f.c[1] = f2;
        if (this.f.c[0] != this.f.c[1]) {
            this.f.a().a(this.f.g());
            if (!f()) {
                if (this.a < 160) {
                    this.a = 160;
                }
                a(this.f.o(), f2, z, f3, f4);
                this.f.a().e.a(true);
                this.f.a().e.b = true;
                this.e.onAnimationStart(null);
                super.d();
                return;
            }
            this.m = true;
            e();
            a(this.j, f2, z, f3, f4);
            this.f.a().e.a(true);
            this.f.a().e.b = true;
            this.e.onAnimationStart(null);
            super.d();
            this.m = false;
        }
    }
}
