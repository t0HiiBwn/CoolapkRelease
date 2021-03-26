package com.amap.api.mapcore2d;

import java.net.Proxy;

/* compiled from: DownloadManager */
public class et {
    private eu a;
    private ew b;

    /* compiled from: DownloadManager */
    public interface a {
        void a(Throwable th);

        void a(byte[] bArr, long j);

        void b();

        void c();
    }

    public et(ew ewVar) {
        this(ewVar, 0, -1);
    }

    public et(ew ewVar, long j, long j2) {
        this(ewVar, j, j2, false);
    }

    public et(ew ewVar, long j, long j2, boolean z) {
        Proxy proxy;
        this.b = ewVar;
        if (ewVar.e == null) {
            proxy = null;
        } else {
            proxy = ewVar.e;
        }
        eu euVar = new eu(this.b.c, this.b.d, proxy, z);
        this.a = euVar;
        euVar.b(j2);
        this.a.a(j);
    }

    public void a(a aVar) {
        this.a.a(this.b.h(), this.b.n(), this.b.m(), this.b.f(), this.b.g(), this.b.a_(), aVar);
    }
}
