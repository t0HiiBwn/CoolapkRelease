package com.bytedance.sdk.a.b.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class d implements Closeable, Flushable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean j = true;
    final com.bytedance.sdk.a.b.a.f.a b;
    final int c;
    com.bytedance.sdk.a.a.d d;
    final LinkedHashMap<String, b> e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    private long k;
    private long l;
    private long m;
    private final Executor n;
    private final Runnable o;

    synchronized void a(a aVar, boolean z) throws IOException {
        b bVar = aVar.a;
        if (bVar.f == aVar) {
            if (z && !bVar.e) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (!aVar.b[i2]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!this.b.b(bVar.d[i2])) {
                        aVar.b();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.c; i3++) {
                File file = bVar.d[i3];
                if (!z) {
                    this.b.a(file);
                } else if (this.b.b(file)) {
                    File file2 = bVar.c[i3];
                    this.b.a(file, file2);
                    long j2 = bVar.b[i3];
                    long c2 = this.b.c(file2);
                    bVar.b[i3] = c2;
                    this.l = (this.l - j2) + c2;
                }
            }
            this.f++;
            bVar.f = null;
            if (bVar.e || z) {
                bVar.e = true;
                this.d.b("CLEAN").i(32);
                this.d.b(bVar.a);
                bVar.a(this.d);
                this.d.i(10);
                if (z) {
                    long j3 = this.m;
                    this.m = 1 + j3;
                    bVar.g = j3;
                }
            } else {
                this.e.remove(bVar.a);
                this.d.b("REMOVE").i(32);
                this.d.b(bVar.a);
                this.d.i(10);
            }
            this.d.flush();
            if (this.l > this.k || a()) {
                this.n.execute(this.o);
            }
            return;
        }
        throw new IllegalStateException();
    }

    boolean a() {
        int i2 = this.f;
        return i2 >= 2000 && i2 >= this.e.size();
    }

    boolean a(b bVar) throws IOException {
        if (bVar.f != null) {
            bVar.f.a();
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.a(bVar.c[i2]);
            this.l -= bVar.b[i2];
            bVar.b[i2] = 0;
        }
        this.f++;
        this.d.b("REMOVE").i(32).b(bVar.a).i(10);
        this.e.remove(bVar.a);
        if (a()) {
            this.n.execute(this.o);
        }
        return true;
    }

    public synchronized boolean b() {
        return this.h;
    }

    private synchronized void d() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.g) {
            d();
            c();
            this.d.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.g) {
            if (!this.h) {
                b[] bVarArr = (b[]) this.e.values().toArray(new b[this.e.size()]);
                for (b bVar : bVarArr) {
                    if (bVar.f != null) {
                        bVar.f.b();
                    }
                }
                c();
                this.d.close();
                this.d = null;
                this.h = true;
                return;
            }
        }
        this.h = true;
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.e.values().iterator().next());
        }
        this.i = false;
    }

    /* compiled from: DiskLruCache */
    public final class a {
        final b a;
        final boolean[] b;
        final /* synthetic */ d c;
        private boolean d;

        void a() {
            if (this.a.f == this) {
                for (int i = 0; i < this.c.c; i++) {
                    try {
                        this.c.b.a(this.a.d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.a.f = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.c) {
                if (!this.d) {
                    if (this.a.f == this) {
                        this.c.a(this, false);
                    }
                    this.d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* compiled from: DiskLruCache */
    private final class b {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        a f;
        long g;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j : this.b) {
                dVar.i(32).l(j);
            }
        }
    }
}
