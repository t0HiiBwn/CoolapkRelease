package com.amap.api.mapcore2d;

/* compiled from: ThreadPool */
class bq {
    private Thread[] a;

    public bq(int i, Runnable runnable, Runnable runnable2) {
        this.a = new Thread[i];
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 != 0 || i <= 1) {
                this.a[i2] = new Thread(runnable2);
            } else {
                this.a[i2] = new Thread(runnable);
            }
        }
    }

    public void a() {
        try {
            Thread[] threadArr = this.a;
            for (Thread thread : threadArr) {
                thread.setDaemon(true);
                thread.start();
            }
        } catch (Throwable th) {
            cm.a(th, "ThreadPool", "start");
        }
    }

    public void b() {
        Thread[] threadArr = this.a;
        if (threadArr != null) {
            int length = threadArr.length;
            for (int i = 0; i < length; i++) {
                this.a[i].interrupt();
                this.a[i] = null;
            }
            this.a = null;
        }
    }
}
