package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

public class be {
    private static long a;
    private static long b;
    private static long c;
    private final c d;
    private final a e;

    private static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.a) {
                    this.a.e = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class b implements Runnable {
        protected int f;

        public b(int i) {
            this.f = i;
        }
    }

    private static final class c extends Thread {
        private volatile long a = 0;
        private volatile boolean b = false;
        private long c = 50;
        private boolean d;
        private boolean e;
        private a f = new a();

        private static final class a {
            private int a;
            private d[] b;
            private int c;
            private int d;

            private a() {
                this.a = 256;
                this.b = new d[256];
                this.c = 0;
                this.d = 0;
            }

            /* access modifiers changed from: private */
            public int b(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.b;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void d(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.c;
                    if (i2 < i3 && i3 > 0) {
                        int i4 = i2 + 1;
                        if (i4 < i3 && this.b[i4].c < this.b[i2].c) {
                            i2 = i4;
                        }
                        if (this.b[i].c >= this.b[i2].c) {
                            d[] dVarArr = this.b;
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

            private void e() {
                int i = this.c - 1;
                int i2 = (i - 1) / 2;
                while (this.b[i].c < this.b[i2].c) {
                    d[] dVarArr = this.b;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    i2 = (i2 - 1) / 2;
                    i = i2;
                }
            }

            public d a() {
                return this.b[0];
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].d == bVar) {
                        this.b[i2].a();
                    }
                }
                d();
            }

            public void a(d dVar) {
                d[] dVarArr = this.b;
                int length = dVarArr.length;
                int i = this.c;
                if (length == i) {
                    d[] dVarArr2 = new d[(i * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.b = dVarArr2;
                }
                d[] dVarArr3 = this.b;
                int i2 = this.c;
                this.c = i2 + 1;
                dVarArr3[i2] = dVar;
                e();
            }

            public boolean a(int i) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].e == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b(int i) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].e == i) {
                        this.b[i2].a();
                    }
                }
                d();
            }

            public boolean b() {
                return this.c == 0;
            }

            public void c() {
                this.b = new d[this.a];
                this.c = 0;
            }

            public void c(int i) {
                int i2;
                if (i >= 0 && i < (i2 = this.c)) {
                    d[] dVarArr = this.b;
                    int i3 = i2 - 1;
                    this.c = i3;
                    dVarArr[i] = dVarArr[i3];
                    dVarArr[i3] = null;
                    d(i);
                }
            }

            public void d() {
                int i = 0;
                while (i < this.c) {
                    if (this.b[i].b) {
                        this.d++;
                        c(i);
                        i--;
                    }
                    i++;
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
            this.f.a(dVar);
            notify();
        }

        public synchronized void a() {
            this.d = true;
            this.f.c();
            notify();
        }

        public boolean b() {
            return this.b && SystemClock.uptimeMillis() - this.a > 600000;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d a2;
            while (true) {
                synchronized (this) {
                    if (!this.d) {
                        if (!this.f.b()) {
                            long a3 = be.a();
                            a2 = this.f.a();
                            synchronized (a2.a) {
                                if (a2.b) {
                                    this.f.c(0);
                                } else {
                                    long j = a2.c - a3;
                                    if (j > 0) {
                                        long j2 = this.c;
                                        if (j > j2) {
                                            j = j2;
                                        }
                                        long j3 = j2 + 50;
                                        this.c = j3;
                                        if (j3 > 500) {
                                            this.c = 500;
                                        }
                                        wait(j);
                                    } else {
                                        this.c = 50;
                                        synchronized (a2.a) {
                                            int b2 = this.f.a().c != a2.c ? this.f.b(a2) : 0;
                                            if (a2.b) {
                                                a aVar = this.f;
                                                aVar.c(aVar.b(a2));
                                            } else {
                                                a2.a(a2.c);
                                                this.f.c(b2);
                                                a2.c = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (!this.e) {
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
                    this.b = true;
                    a2.d.run();
                    this.b = false;
                } catch (Throwable th) {
                    synchronized (this) {
                        this.d = true;
                        throw th;
                    }
                }
            }
        }
    }

    static class d {
        final Object a = new Object();
        boolean b;
        long c;
        b d;
        int e;
        private long f;

        d() {
        }

        void a(long j) {
            synchronized (this.a) {
                this.f = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.a) {
                z = !this.b && this.c > 0;
                this.b = true;
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

    public be() {
        this(false);
    }

    public be(String str) {
        this(str, false);
    }

    public be(String str, boolean z) {
        Objects.requireNonNull(str, "name == null");
        c cVar = new c(str, z);
        this.d = cVar;
        this.e = new a(cVar);
    }

    public be(boolean z) {
        this("Timer-" + e(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (be.class) {
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

    private void b(b bVar, long j) {
        synchronized (this.d) {
            if (!this.d.d) {
                long a2 = j + a();
                if (a2 >= 0) {
                    d dVar = new d();
                    dVar.e = bVar.f;
                    dVar.d = bVar;
                    dVar.c = a2;
                    this.d.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    private static synchronized long e() {
        long j;
        synchronized (be.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    public void a(int i, b bVar) {
        synchronized (this.d) {
            this.d.f.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.a.a.a.c.a() >= 1 || Thread.currentThread() == this.d) {
            bVar.run();
        } else {
            com.xiaomi.a.a.a.c.d("run job outside job job thread");
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

    public boolean a(int i) {
        boolean a2;
        synchronized (this.d) {
            a2 = this.d.f.a(i);
        }
        return a2;
    }

    public void b() {
        this.d.a();
    }

    public void b(int i) {
        synchronized (this.d) {
            this.d.f.b(i);
        }
    }

    public void c() {
        synchronized (this.d) {
            this.d.f.c();
        }
    }

    public boolean d() {
        return this.d.b();
    }
}
