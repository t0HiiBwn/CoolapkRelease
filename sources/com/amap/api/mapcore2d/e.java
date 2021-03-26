package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Looper;

/* compiled from: AnimBase */
abstract class e {
    protected int a;
    protected int b;
    private Handler c = null;
    private int d = 0;
    private boolean e = false;
    private boolean f = true;
    private Runnable g = new Runnable() {
        /* class com.amap.api.mapcore2d.e.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            e.this.h();
            if (!e.this.f()) {
                if (e.this.c != null) {
                    e.this.c.removeCallbacks(this);
                }
                e.this.c = null;
                if (e.this.f) {
                    e.this.c();
                } else {
                    e.this.b();
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                e.this.a();
                e.this.i();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 < ((long) e.this.b)) {
                    try {
                        Thread.sleep(((long) e.this.b) - currentTimeMillis2);
                    } catch (InterruptedException e) {
                        cm.a(e, "AnimBase", "run");
                    }
                }
            }
        }
    };

    protected abstract void a();

    protected abstract void b();

    protected abstract void c();

    public e(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public void a(int i) {
        this.a = i;
    }

    public void d() {
        if (!f()) {
            this.c = new Handler(Looper.getMainLooper());
            this.e = true;
            this.f = false;
            this.d = 0;
        }
        i();
    }

    public void e() {
        n.a().b();
        g();
        this.g.run();
    }

    private void g() {
        this.e = false;
    }

    /* access modifiers changed from: private */
    public void h() {
        int i = this.d + this.b;
        this.d = i;
        int i2 = this.a;
        if (i2 != -1 && i > i2) {
            g();
            b(true);
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean f() {
        return this.e;
    }

    public void b(boolean z) {
        this.f = z;
    }

    /* access modifiers changed from: private */
    public void i() {
        Handler handler = this.c;
        if (handler != null) {
            handler.post(this.g);
        }
    }
}
