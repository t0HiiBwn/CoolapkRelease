package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.e;
import java.io.InputStream;
import java.util.concurrent.Future;

/* compiled from: AsyncStreamReader */
public class a implements b {
    private final InputStream a;
    private final int b;
    private final int c;
    private final Object d = new Object();
    private final Object e = new Object();
    private com.ss.android.socialbase.downloader.f.a f;
    private com.ss.android.socialbase.downloader.f.a g;
    private com.ss.android.socialbase.downloader.f.a h;
    private com.ss.android.socialbase.downloader.f.a i;
    private com.ss.android.socialbase.downloader.f.a j;
    private com.ss.android.socialbase.downloader.f.a k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f1411l;
    private volatile boolean m;
    private volatile Throwable n;
    private volatile Future o;
    private int p;
    private final Runnable q = new Runnable() {
        /* class com.ss.android.socialbase.downloader.e.a.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.f.a d;
            Process.setThreadPriority(10);
            do {
                try {
                    d = a.this.d();
                    d.c = a.this.a.read(d.a);
                    a.this.c(d);
                } catch (Throwable th) {
                    synchronized (a.this.e) {
                        a.this.m = true;
                        a.this.e.notify();
                        e.a(a.this.a);
                        throw th;
                    }
                }
            } while (d.c != -1);
            synchronized (a.this.e) {
                a.this.m = true;
                a.this.e.notify();
            }
            e.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.a = inputStream;
        this.b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.c = i3;
        c();
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() throws BaseException, InterruptedException {
        return e();
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
        b(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        synchronized (this.d) {
            this.f1411l = true;
            this.d.notify();
        }
        Future future = this.o;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.o = null;
        }
    }

    private void c() throws Throwable {
        this.o = b.q().submit(this.q);
    }

    /* access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        int i2;
        com.ss.android.socialbase.downloader.f.a aVar = this.h;
        if (aVar == null) {
            synchronized (this.d) {
                if (!this.f1411l) {
                    com.ss.android.socialbase.downloader.f.a aVar2 = this.f;
                    if (aVar2 != null || (i2 = this.p) >= this.c) {
                        while (aVar2 == null) {
                            this.d.wait();
                            if (!this.f1411l) {
                                aVar2 = this.f;
                            } else {
                                throw new p("");
                            }
                        }
                        this.h = aVar2.d;
                        this.g = null;
                        this.f = null;
                        aVar2.d = null;
                        return aVar2;
                    }
                    this.p = i2 + 1;
                    return new com.ss.android.socialbase.downloader.f.a(this.b);
                }
                throw new p("");
            }
        } else if (!this.f1411l) {
            this.h = aVar.d;
            aVar.d = null;
            return aVar;
        } else {
            throw new p("");
        }
    }

    private void b(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.g;
            if (aVar2 == null) {
                this.g = aVar;
                this.f = aVar;
                this.d.notify();
            } else {
                aVar2.d = aVar;
                this.g = aVar;
            }
        }
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.d;
            aVar2.d = null;
            return aVar2;
        }
        synchronized (this.e) {
            aVar = this.i;
            if (aVar == null) {
                do {
                    if (this.m) {
                        f();
                    }
                    this.e.wait();
                    aVar = this.i;
                } while (aVar == null);
            }
            this.k = aVar.d;
            this.j = null;
            this.i = null;
            aVar.d = null;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public void c(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.i = aVar;
                this.e.notify();
            } else {
                aVar2.d = aVar;
                this.j = aVar;
            }
        }
    }

    private void f() throws BaseException {
        Throwable th = this.n;
        if (th != null) {
            if (th instanceof p) {
                throw new BaseException(1068, "async reader closed!");
            }
            e.a(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }
}
