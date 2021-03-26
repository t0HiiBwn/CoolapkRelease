package com.bytedance.sdk.openadsdk.i;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.i.b;
import com.bytedance.sdk.openadsdk.i.g.d;
import com.bytedance.sdk.openadsdk.i.h;
import com.bytedance.sdk.openadsdk.i.i;
import com.bytedance.sdk.openadsdk.i.l;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* compiled from: ProxyTask */
class g extends a {
    private final Socket m;
    private final c n;
    private final d o;
    private volatile b p;
    private volatile boolean q = true;

    /* compiled from: ProxyTask */
    public interface c {
        void a(g gVar);

        void b(g gVar);
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
    }

    g(a aVar) {
        super(aVar.a, aVar.b);
        this.m = aVar.c;
        this.n = aVar.d;
        this.o = d.c();
    }

    private b h() {
        try {
            this.i = i.a(this.m.getInputStream());
            OutputStream outputStream = this.m.getOutputStream();
            com.bytedance.sdk.openadsdk.i.a.a aVar = this.i.c.a == 1 ? e.a : e.b;
            if (aVar == null) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.a = aVar;
            this.g = this.i.c.b;
            this.h = this.i.c.c;
            this.j = new l(this.i.c.g);
            this.f = this.i.b;
            if (e.c) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.i.toString());
            }
            return new b(outputStream, this.i.c.d);
        } catch (IOException e) {
            d.a(this.m);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
            a(this.a == null ? null : Boolean.valueOf(g()), this.g, e);
            return null;
        } catch (i.d e2) {
            d.a(this.m);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            a(this.a == null ? null : Boolean.valueOf(g()), this.g, e2);
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.sdk.openadsdk.i.b.a a2;
        b h = h();
        if (h != null) {
            c cVar = this.n;
            if (cVar != null) {
                cVar.a(this);
            }
            this.a.a(this.h);
            if (e.h != 0 && ((a2 = this.b.a(this.h, this.i.c.a)) == null || this.a.c(this.h).length() < ((long) a2.c))) {
                this.o.a(g(), this.h);
            }
            try {
                a(h);
            } catch (com.bytedance.sdk.openadsdk.i.c.a e) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
                }
            } catch (VAdError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
                }
            }
            this.a.b(this.h);
            this.o.a(g(), null);
            a();
            d.a(this.m);
            c cVar2 = this.n;
            if (cVar2 != null) {
                cVar2.b(this);
            }
        }
    }

    private boolean a(b bVar) throws com.bytedance.sdk.openadsdk.i.c.a, VAdError {
        while (this.j.a()) {
            e();
            l.a b2 = this.j.b();
            try {
                a(bVar, b2);
                return true;
            } catch (com.bytedance.sdk.openadsdk.i.c.c e) {
                b2.a();
                a(Boolean.valueOf(g()), this.g, e);
            } catch (IOException e2) {
                if (e2 instanceof SocketTimeoutException) {
                    b2.b();
                }
                if (!b()) {
                    a(Boolean.valueOf(g()), this.g, e2);
                } else if (e.c) {
                    if ("Canceled".equalsIgnoreCase(e2.getMessage())) {
                        Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                    } else {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                    }
                }
            } catch (com.bytedance.sdk.openadsdk.i.c.d e3) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                return true;
            } catch (h.a e4) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                }
                this.q = false;
                a(Boolean.valueOf(g()), this.g, e4);
            } catch (com.bytedance.sdk.openadsdk.i.c.b e5) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
                return false;
            } catch (com.bytedance.sdk.adnet.err.a e6) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                }
            } catch (Exception e7) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
                }
            }
        }
        return false;
    }

    private void a(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.i.c.d, IOException, h.a, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        if ("HEAD".equalsIgnoreCase(this.i.a.a)) {
            b(bVar, aVar);
        } else {
            c(bVar, aVar);
        }
    }

    private void b(b bVar, l.a aVar) throws IOException, com.bytedance.sdk.openadsdk.i.c.d, VAdError {
        byte[] a2 = a(this.b.a(this.h, this.i.c.a), bVar, aVar);
        if (a2 != null) {
            bVar.a(a2, 0, a2.length);
        }
    }

    private void c(b bVar, l.a aVar) throws h.a, com.bytedance.sdk.openadsdk.i.c.d, IOException, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        int i;
        if (this.q) {
            File c2 = this.a.c(this.h);
            long length = c2.length();
            com.bytedance.sdk.openadsdk.i.b.a a2 = this.b.a(this.h, this.i.c.a);
            int b2 = bVar.b();
            long j = length - ((long) b2);
            int i2 = (int) j;
            if (a2 == null) {
                i = -1;
            } else {
                i = a2.c;
            }
            if (length > ((long) bVar.b())) {
                if (e.c) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + j);
                }
                a(true, i2, i, (int) length, b2);
                a(a2, c2, bVar, aVar);
                return;
            }
            a(false, i2, i, (int) length, b2);
        } else {
            a(false, 0, 0, 0, bVar.b());
        }
        d(bVar, aVar);
    }

    private byte[] a(com.bytedance.sdk.openadsdk.i.b.a aVar, b bVar, l.a aVar2) throws IOException, VAdError {
        if (aVar != null) {
            if (e.c) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return d.a(aVar, bVar.b()).getBytes(d.a);
        }
        com.bytedance.sdk.openadsdk.i.e.a a2 = a(aVar2, 0, -1, "HEAD");
        if (a2 == null) {
            return null;
        }
        try {
            String a3 = d.a(a2, false, false);
            if (a3 == null) {
                com.bytedance.sdk.openadsdk.i.b.a a4 = d.a(a2, this.b, this.h, this.i.c.a);
                if (e.c) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                return d.a(a4, bVar.b()).getBytes(d.a);
            }
            throw new com.bytedance.sdk.openadsdk.i.c.c(a3 + ", rawKey: " + this.g + ", url: " + aVar2);
        } finally {
            d.a(a2.d());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01cf A[SYNTHETIC, Splitter:B:90:0x01cf] */
    private void a(com.bytedance.sdk.openadsdk.i.b.a aVar, File file, b bVar, l.a aVar2) throws IOException, com.bytedance.sdk.openadsdk.i.c.d, h.a, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        final f fVar;
        Throwable th;
        b bVar2;
        if (!bVar.a()) {
            byte[] a2 = a(aVar, bVar, aVar2);
            e();
            if (a2 != null) {
                bVar.a(a2, 0, a2.length);
            } else {
                return;
            }
        }
        h hVar = null;
        if (aVar == null && (aVar = this.b.a(this.h, this.i.c.a)) == null) {
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            a((com.bytedance.sdk.openadsdk.i.b.a) null, bVar, aVar2);
            aVar = this.b.a(this.h, this.i.c.a);
            if (aVar == null) {
                throw new com.bytedance.sdk.openadsdk.i.c.c("failed to get header, rawKey: " + this.g + ", url: " + aVar2);
            }
        }
        if (file.length() >= ((long) aVar.c) || ((bVar2 = this.p) != null && !bVar2.b() && !bVar2.d())) {
            fVar = null;
        } else {
            b a3 = new b.a().a(this.a).a(this.b).a(this.g).b(this.h).a(new l(aVar2.a)).a(this.f).a(this.i).a((b.AbstractC0055b) new b.AbstractC0055b() {
                /* class com.bytedance.sdk.openadsdk.i.g.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.i.b.AbstractC0055b
                public void a(b bVar) {
                    g.this.c.addAndGet(bVar.c.get());
                    g.this.d.addAndGet(bVar.d.get());
                    synchronized (bVar.m) {
                        bVar.m.notifyAll();
                    }
                    if (bVar.d()) {
                        g.this.o.a(g.this.g(), null);
                    }
                }
            }).a();
            this.p = a3;
            fVar = new f(a3, null, 10, 1);
            e.a().execute(new com.bytedance.sdk.openadsdk.j.g() {
                /* class com.bytedance.sdk.openadsdk.i.g.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            h hVar2 = new h(file, "r");
            try {
                hVar2.a((long) bVar.b());
                int min = this.i.c.e > 0 ? Math.min(aVar.c, this.i.c.e) : aVar.c;
                while (bVar.b() < min) {
                    e();
                    int a4 = hVar2.a(bArr);
                    if (a4 <= 0) {
                        b bVar3 = this.p;
                        if (bVar3 != null) {
                            com.bytedance.sdk.openadsdk.i.c.b i = bVar3.i();
                            if (i == null) {
                                h.a h = bVar3.h();
                                if (h != null) {
                                    throw h;
                                }
                            } else {
                                throw i;
                            }
                        }
                        if (bVar3 != null && !bVar3.b()) {
                            if (!bVar3.d()) {
                                e();
                                synchronized (bVar3.m) {
                                    try {
                                        bVar3.m.wait(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        if (e.c) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bytedance.sdk.openadsdk.i.c.c("illegal state download task has finished, rawKey: " + this.g + ", url: " + aVar2);
                    }
                    bVar.b(bArr, 0, a4);
                    e();
                }
                if (e.c) {
                    Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + bVar.b() + ", " + min);
                }
                c();
                hVar2.a();
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                hVar = hVar2;
                if (hVar != null) {
                    hVar.a();
                }
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            if (hVar != null) {
            }
            if (fVar != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0104 A[Catch:{ all -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016f A[Catch:{ all -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ad A[EDGE_INSN: B:88:0x01ad->B:67:0x01ad ?: BREAK  , SYNTHETIC] */
    private void d(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.i.c.d, IOException, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        Throwable th;
        h hVar;
        com.bytedance.sdk.openadsdk.i.b.a a2;
        int i;
        byte[] bArr;
        InputStream d;
        int i2;
        int read;
        h.a e;
        i();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int b2 = bVar.b();
        com.bytedance.sdk.openadsdk.i.e.a a3 = a(aVar, b2, this.i.c.e, "GET");
        if (a3 != null) {
            h hVar2 = null;
            int i3 = 0;
            try {
                String a4 = d.a(a3, false, true);
                if (a4 == null) {
                    com.bytedance.sdk.openadsdk.i.b.a a5 = this.b.a(this.h, f());
                    int a6 = d.a(a3);
                    if (a5 == null || a5.c == a6) {
                        if (!bVar.a()) {
                            String a7 = d.a(a3, b2);
                            e();
                            byte[] bytes = a7.getBytes(d.a);
                            bVar.a(bytes, 0, bytes.length);
                        }
                        e();
                        File d2 = this.a.d(this.h);
                        if (!this.q || d2 == null || d2.length() < ((long) bVar.b())) {
                            if (e.c) {
                                Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + d2.length() + ", from: " + bVar.b());
                            }
                            hVar = null;
                        } else {
                            d.a(a3, this.b, this.h, this.i.c.a);
                            try {
                                hVar = new h(d2, "rwd");
                                try {
                                    hVar.a((long) bVar.b());
                                } catch (h.a e2) {
                                    e = e2;
                                }
                            } catch (h.a e3) {
                                e = e3;
                                hVar = null;
                                try {
                                    e.printStackTrace();
                                    hVar = null;
                                    if (e.c) {
                                    }
                                    a2 = this.b.a(this.h, f());
                                    if (a2 != null) {
                                    }
                                    bArr = new byte[8192];
                                    d = a3.d();
                                    i2 = 0;
                                    while (true) {
                                        try {
                                            read = d.read(bArr);
                                            if (read >= 0) {
                                            }
                                            e();
                                        } catch (Throwable th2) {
                                            th = th2;
                                            hVar2 = hVar;
                                            i3 = i2;
                                            d.a(a3.d());
                                            if (hVar2 != null) {
                                            }
                                            this.c.addAndGet(i3);
                                            this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                                            throw th;
                                        }
                                    }
                                    if (e.c) {
                                    }
                                    c();
                                    d.a(a3.d());
                                    if (hVar != null) {
                                    }
                                    this.c.addAndGet(i2);
                                    this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    hVar2 = hVar;
                                    d.a(a3.d());
                                    if (hVar2 != null) {
                                    }
                                    this.c.addAndGet(i3);
                                    this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                                    throw th;
                                }
                            }
                            if (e.c) {
                                Log.i("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + d2.length() + ", from: " + bVar.b());
                            }
                        }
                        a2 = this.b.a(this.h, f());
                        if (a2 != null) {
                            i = 0;
                        } else {
                            i = a2.c;
                        }
                        bArr = new byte[8192];
                        d = a3.d();
                        i2 = 0;
                        while (true) {
                            read = d.read(bArr);
                            if (read >= 0) {
                                break;
                            }
                            e();
                            if (read > 0) {
                                bVar.b(bArr, 0, read);
                                i2 += read;
                                if (hVar != null) {
                                    try {
                                        hVar.a(bArr, 0, read);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        i3 = i2;
                                        d.a(a3.d());
                                        if (hVar2 != null) {
                                            hVar2.a();
                                        }
                                        this.c.addAndGet(i3);
                                        this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                                        throw th;
                                    }
                                }
                                a(i, bVar.b());
                            }
                            e();
                        }
                        if (e.c) {
                            Log.i("TAG_PROXY_ProxyTask", "read from net complete!");
                        }
                        c();
                        d.a(a3.d());
                        if (hVar != null) {
                            hVar.a();
                        }
                        this.c.addAndGet(i2);
                        this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                        return;
                    }
                    if (e.c) {
                        Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + a5.c + ", " + a6 + ", key: " + this.h);
                    }
                    throw new com.bytedance.sdk.openadsdk.i.c.b("Content-Length not match, old length: " + a5.c + ", new length: " + a6 + ", rawKey: " + this.g + ", currentUrl: " + aVar + ", previousInfo: " + a5.e);
                }
                throw new com.bytedance.sdk.openadsdk.i.c.c(a4 + ", rawKey: " + this.g + ", url: " + aVar);
            } catch (Throwable th5) {
                th = th5;
                d.a(a3.d());
                if (hVar2 != null) {
                }
                this.c.addAndGet(i3);
                this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                throw th;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.a
    public void a() {
        super.a();
        i();
    }

    private void i() {
        b bVar = this.p;
        this.p = null;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* compiled from: ProxyTask */
    private static class b {
        private final OutputStream a;
        private int b;
        private boolean c;

        b(OutputStream outputStream, int i) {
            this.a = outputStream;
            this.b = i;
        }

        boolean a() {
            return this.c;
        }

        void a(byte[] bArr, int i, int i2) throws com.bytedance.sdk.openadsdk.i.c.d {
            if (!this.c) {
                try {
                    this.a.write(bArr, i, i2);
                    this.c = true;
                } catch (IOException e) {
                    throw new com.bytedance.sdk.openadsdk.i.c.d(e);
                }
            }
        }

        void b(byte[] bArr, int i, int i2) throws com.bytedance.sdk.openadsdk.i.c.d {
            try {
                this.a.write(bArr, i, i2);
                this.b += i2;
            } catch (IOException e) {
                throw new com.bytedance.sdk.openadsdk.i.c.d(e);
            }
        }

        int b() {
            return this.b;
        }
    }

    /* compiled from: ProxyTask */
    static final class a {
        com.bytedance.sdk.openadsdk.i.a.a a;
        com.bytedance.sdk.openadsdk.i.b.c b;
        Socket c;
        c d;

        a() {
        }

        a a(com.bytedance.sdk.openadsdk.i.b.c cVar) {
            if (cVar != null) {
                this.b = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        a a(Socket socket) {
            if (socket != null) {
                this.c = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        a a(c cVar) {
            this.d = cVar;
            return this;
        }

        g a() {
            if (this.b != null && this.c != null) {
                return new g(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
