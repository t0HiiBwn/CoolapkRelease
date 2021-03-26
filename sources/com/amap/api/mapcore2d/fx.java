package com.amap.api.mapcore2d;

/* compiled from: ThreadTask */
public abstract class fx implements Runnable {
    a d;

    /* compiled from: ThreadTask */
    interface a {
        void a(fx fxVar);

        void b(fx fxVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a(this);
            }
            if (!Thread.interrupted()) {
                a();
                if (!Thread.interrupted() && (aVar = this.d) != null) {
                    aVar.b(this);
                }
            }
        } catch (Throwable th) {
            Cdo.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
