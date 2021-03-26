package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
public final class j implements s {
    private int a = 0;
    private final e b;
    private final Inflater c;
    private final k d;
    private final CRC32 e = new CRC32();

    public j(s sVar) {
        if (sVar != null) {
            Inflater inflater = new Inflater(true);
            this.c = inflater;
            e a2 = l.a(sVar);
            this.b = a2;
            this.d = new k(a2, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i == 0) {
            return 0;
        } else {
            if (this.a == 0) {
                b();
                this.a = 1;
            }
            if (this.a == 1) {
                long j2 = cVar.b;
                long a2 = this.d.a(cVar, j);
                if (a2 != -1) {
                    a(cVar, j2, a2);
                    return a2;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                c();
                this.a = 3;
                if (!this.b.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    private void b() throws IOException {
        this.b.a(10);
        byte b2 = this.b.c().b(3L);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            a(this.b.c(), 0, 10);
        }
        a("ID1ID2", 8075, this.b.i());
        this.b.h(8);
        if (((b2 >> 2) & 1) == 1) {
            this.b.a(2);
            if (z) {
                a(this.b.c(), 0, 2);
            }
            long k = (long) this.b.c().k();
            this.b.a(k);
            if (z) {
                a(this.b.c(), 0, k);
            }
            this.b.h(k);
        }
        if (((b2 >> 3) & 1) == 1) {
            long a2 = this.b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.b.c(), 0, a2 + 1);
                }
                this.b.h(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b2 >> 4) & 1) == 1) {
            long a3 = this.b.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.b.c(), 0, a3 + 1);
                }
                this.b.h(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.b.k(), (short) ((int) this.e.getValue()));
            this.e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.b.l(), (int) this.e.getValue());
        a("ISIZE", this.b.l(), (int) this.c.getBytesWritten());
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.b.a();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    private void a(c cVar, long j, long j2) {
        o oVar = cVar.a;
        while (j >= ((long) (oVar.c - oVar.b))) {
            j -= (long) (oVar.c - oVar.b);
            oVar = oVar.f;
        }
        while (j2 > 0) {
            int i = (int) (((long) oVar.b) + j);
            int min = (int) Math.min((long) (oVar.c - i), j2);
            this.e.update(oVar.a, i, min);
            j2 -= (long) min;
            oVar = oVar.f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
