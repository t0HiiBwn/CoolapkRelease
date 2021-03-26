package com.ss.android.socialbase.downloader.f;

/* compiled from: BufferQueue */
class b implements c, d, e {
    private final int a;
    private final int b;
    private final Object c = new Object();
    private final Object d = new Object();
    private a e;
    private a f;
    private a g;
    private a h;
    private a i;
    private volatile boolean j;
    private int k;

    b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.i = aVar2.d;
            aVar2.d = null;
            return aVar2;
        }
        synchronized (this.d) {
            aVar = this.g;
            while (aVar == null) {
                if (!this.j) {
                    this.d.wait();
                    aVar = this.g;
                } else {
                    throw new p("read");
                }
            }
            this.i = aVar.d;
            this.h = null;
            this.g = null;
            aVar.d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(a aVar) {
        synchronized (this.c) {
            a aVar2 = this.f;
            if (aVar2 == null) {
                this.f = aVar;
                this.e = aVar;
            } else {
                aVar2.d = aVar;
                this.f = aVar;
            }
            this.c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public a b() throws p, InterruptedException {
        synchronized (this.c) {
            if (!this.j) {
                a aVar = this.e;
                if (aVar == null) {
                    int i2 = this.k;
                    if (i2 < this.a) {
                        this.k = i2 + 1;
                        return new a(this.b);
                    }
                    do {
                        this.c.wait();
                        if (!this.j) {
                            aVar = this.e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.e = aVar.d;
                if (aVar == this.f) {
                    this.f = null;
                }
                aVar.d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(a aVar) {
        synchronized (this.d) {
            a aVar2 = this.h;
            if (aVar2 == null) {
                this.h = aVar;
                this.g = aVar;
                this.d.notify();
            } else {
                aVar2.d = aVar;
                this.h = aVar;
            }
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.c) {
            this.c.notifyAll();
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }
}
