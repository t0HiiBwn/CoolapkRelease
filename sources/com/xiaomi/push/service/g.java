package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

public class g {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f1012a;

    /* renamed from: a  reason: collision with other field name */
    private final c f1013a;

    private static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.a) {
                    this.a.c = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class b implements Runnable {
        protected int a;

        public b(int i) {
            this.a = i;
        }
    }

    private static final class c extends Thread {
        private volatile long a = 0;

        /* renamed from: a  reason: collision with other field name */
        private a f1014a = new a();

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f1015a = false;
        private long b = 50;

        /* renamed from: b  reason: collision with other field name */
        private boolean f1016b;
        private boolean c;

        private static final class a {
            private int a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f1017a;
            private int b;
            private int c;

            private a() {
                this.a = 256;
                this.f1017a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            /* access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f1017a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (this.f1017a[i].f1018a < this.f1017a[i2].f1018a) {
                    d[] dVarArr = this.f1017a;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    i2 = (i2 - 1) / 2;
                    i = i2;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 < i3 && i3 > 0) {
                        int i4 = i2 + 1;
                        if (i4 < i3 && this.f1017a[i4].f1018a < this.f1017a[i2].f1018a) {
                            i2 = i4;
                        }
                        if (this.f1017a[i].f1018a >= this.f1017a[i2].f1018a) {
                            d[] dVarArr = this.f1017a;
                            d dVar = dVarArr[i];
                            dVarArr[i] = dVarArr[i2];
                            dVarArr[i2] = dVar;
                            i2 = (i2 * 2) + 1;
                            i = i2;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public d a() {
                return this.f1017a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m655a() {
                this.f1017a = new d[this.a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f1017a[i2].a == i) {
                        this.f1017a[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f1017a[i2].f1019a == bVar) {
                        this.f1017a[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m656a(d dVar) {
                d[] dVarArr = this.f1017a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[(i * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f1017a = dVarArr2;
                }
                d[] dVarArr3 = this.f1017a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m657a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m658a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f1017a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f1017a[i].f1021a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                int i2;
                if (i >= 0 && i < (i2 = this.b)) {
                    d[] dVarArr = this.f1017a;
                    int i3 = i2 - 1;
                    this.b = i3;
                    dVarArr[i] = dVarArr[i3];
                    dVarArr[i3] = null;
                    c(i);
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* access modifiers changed from: private */
        public void a(d dVar) {
            this.f1014a.m656a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f1016b = true;
            this.f1014a.m655a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m654a() {
            return this.f1015a && SystemClock.uptimeMillis() - this.a > 600000;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d a2;
            while (true) {
                synchronized (this) {
                    if (!this.f1016b) {
                        if (!this.f1014a.m657a()) {
                            long a3 = g.a();
                            a2 = this.f1014a.a();
                            synchronized (a2.f1020a) {
                                if (a2.f1021a) {
                                    this.f1014a.b(0);
                                } else {
                                    long j = a2.f1018a - a3;
                                    if (j > 0) {
                                        long j2 = this.b;
                                        if (j > j2) {
                                            j = j2;
                                        }
                                        long j3 = j2 + 50;
                                        this.b = j3;
                                        if (j3 > 500) {
                                            this.b = 500;
                                        }
                                        wait(j);
                                    } else {
                                        this.b = 50;
                                        synchronized (a2.f1020a) {
                                            int a4 = this.f1014a.a().f1018a != a2.f1018a ? this.f1014a.a(a2) : 0;
                                            if (a2.f1021a) {
                                                a aVar = this.f1014a;
                                                aVar.b(aVar.a(a2));
                                            } else {
                                                a2.a(a2.f1018a);
                                                this.f1014a.b(a4);
                                                a2.f1018a = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (!this.c) {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                try {
                    this.a = SystemClock.uptimeMillis();
                    this.f1015a = true;
                    a2.f1019a.run();
                    this.f1015a = false;
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f1016b = true;
                        throw th;
                    }
                }
            }
        }
    }

    static class d {
        int a;

        /* renamed from: a  reason: collision with other field name */
        long f1018a;

        /* renamed from: a  reason: collision with other field name */
        b f1019a;

        /* renamed from: a  reason: collision with other field name */
        final Object f1020a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f1021a;
        private long b;

        d() {
        }

        void a(long j) {
            synchronized (this.f1020a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1020a) {
                z = !this.f1021a && this.f1018a > 0;
                this.f1021a = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        a = j;
        b = j;
    }

    public g() {
        this(false);
    }

    public g(String str) {
        this(str, false);
    }

    public g(String str, boolean z) {
        Objects.requireNonNull(str, "name == null");
        c cVar = new c(str, z);
        this.f1013a = cVar;
        this.f1012a = new a(cVar);
    }

    public g(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (g.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = b;
            if (elapsedRealtime > j2) {
                a += elapsedRealtime - j2;
            }
            b = elapsedRealtime;
            j = a;
        }
        return j;
    }

    private static synchronized long b() {
        long j;
        synchronized (g.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f1013a) {
            if (!this.f1013a.f1016b) {
                long a2 = j + a();
                if (a2 >= 0) {
                    d dVar = new d();
                    dVar.a = bVar.a;
                    dVar.f1019a = bVar;
                    dVar.f1018a = a2;
                    this.f1013a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m650a() {
        com.xiaomi.channel.commonutils.logger.b.m41a("quit. finalizer:" + this.f1012a);
        this.f1013a.a();
    }

    public void a(int i) {
        synchronized (this.f1013a) {
            this.f1013a.f1014a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f1013a) {
            this.f1013a.f1014a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f1013a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m651a() {
        return this.f1013a.m654a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m652a(int i) {
        boolean a2;
        synchronized (this.f1013a) {
            a2 = this.f1013a.f1014a.m658a(i);
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m653b() {
        synchronized (this.f1013a) {
            this.f1013a.f1014a.m655a();
        }
    }
}
