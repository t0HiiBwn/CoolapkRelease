package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.b.a.e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Writer */
final class j implements Closeable {
    private static final Logger b = Logger.getLogger(e.class.getName());
    final d.b a;
    private final com.bytedance.sdk.a.a.d c;
    private final boolean d;
    private final c e;
    private int f = 16384;
    private boolean g;

    j(com.bytedance.sdk.a.a.d dVar, boolean z) {
        this.c = dVar;
        this.d = z;
        c cVar = new c();
        this.e = cVar;
        this.a = new d.b(cVar);
    }

    public synchronized void a() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (this.d) {
            Logger logger = b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.bytedance.sdk.a.b.a.c.a(">> CONNECTION %s", e.a.e()));
            }
            this.c.c(e.a.h());
            this.c.flush();
        }
    }

    public synchronized void a(n nVar) throws IOException {
        if (!this.g) {
            this.f = nVar.d(this.f);
            if (nVar.c() != -1) {
                this.a.a(nVar.c());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, int i2, List<c> list) throws IOException {
        if (!this.g) {
            this.a.a(list);
            long b2 = this.e.b();
            int min = (int) Math.min((long) (this.f - 4), b2);
            long j = (long) min;
            int i3 = (b2 > j ? 1 : (b2 == j ? 0 : -1));
            a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : 0);
            this.c.g(i2 & Integer.MAX_VALUE);
            this.c.a_(this.e, j);
            if (i3 > 0) {
                b(i, b2 - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b() throws IOException {
        if (!this.g) {
            this.c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, int i2, List<c> list) throws IOException {
        if (!this.g) {
            a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, b bVar) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (bVar.g != -1) {
            a(i, 4, (byte) 3, (byte) 0);
            this.c.g(bVar.g);
            this.c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int c() {
        return this.f;
    }

    public synchronized void a(boolean z, int i, c cVar, int i2) throws IOException {
        if (!this.g) {
            byte b2 = 0;
            if (z) {
                b2 = (byte) 1;
            }
            a(i, b2, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    void a(int i, byte b2, c cVar, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.c.a_(cVar, (long) i2);
        }
    }

    public synchronized void b(n nVar) throws IOException {
        if (!this.g) {
            int i = 0;
            a(0, nVar.b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (nVar.a(i)) {
                    this.c.h(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.c.g(nVar.b(i));
                }
                i++;
            }
            this.c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, int i2) throws IOException {
        if (!this.g) {
            a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.c.g(i);
            this.c.g(i2);
            this.c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, b bVar, byte[] bArr) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (bVar.g != -1) {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.c.g(i);
            this.c.g(bVar.g);
            if (bArr.length > 0) {
                this.c.c(bArr);
            }
            this.c.flush();
        } else {
            throw e.a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    public synchronized void a(int i, long j) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            a(i, 4, (byte) 8, (byte) 0);
            this.c.g((int) j);
            this.c.flush();
        }
    }

    public void a(int i, int i2, byte b2, byte b3) throws IOException {
        Logger logger = b;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.a(false, i, i2, b2, b3));
        }
        int i3 = this.f;
        if (i2 > i3) {
            throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            a(this.c, i2);
            this.c.i(b2 & 255);
            this.c.i(b3 & 255);
            this.c.g(i & Integer.MAX_VALUE);
        } else {
            throw e.a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.g = true;
        this.c.close();
    }

    private static void a(com.bytedance.sdk.a.a.d dVar, int i) throws IOException {
        dVar.i((i >>> 16) & 255);
        dVar.i((i >>> 8) & 255);
        dVar.i(i & 255);
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f, j);
            long j2 = (long) min;
            j -= j2;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.c.a_(this.e, j2);
        }
    }

    void a(boolean z, int i, List<c> list) throws IOException {
        if (!this.g) {
            this.a.a(list);
            long b2 = this.e.b();
            int min = (int) Math.min((long) this.f, b2);
            long j = (long) min;
            int i2 = (b2 > j ? 1 : (b2 == j ? 0 : -1));
            byte b3 = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b3 = (byte) (b3 | 1);
            }
            a(i, min, (byte) 1, b3);
            this.c.a_(this.e, j);
            if (i2 > 0) {
                b(i, b2 - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
