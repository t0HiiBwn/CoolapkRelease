package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
public final class k implements s {
    private final e a;
    private final Inflater b;
    private int c;
    private boolean d;

    k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.a = eVar;
            this.b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) throws IOException {
        o e;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.d) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean b2 = b();
                try {
                    e = cVar.e(1);
                    int inflate = this.b.inflate(e.a, e.c, (int) Math.min(j, (long) (8192 - e.c)));
                    if (inflate > 0) {
                        e.c += inflate;
                        long j2 = (long) inflate;
                        cVar.b += j2;
                        return j2;
                    } else if (this.b.finished()) {
                        break;
                    } else if (this.b.needsDictionary()) {
                        break;
                    } else if (b2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            c();
            if (e.b != e.c) {
                return -1;
            }
            cVar.a = e.b();
            p.a(e);
            return -1;
        }
    }

    public final boolean b() throws IOException {
        if (!this.b.needsInput()) {
            return false;
        }
        c();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.a.e()) {
            return true;
        } else {
            o oVar = this.a.c().a;
            this.c = oVar.c - oVar.b;
            this.b.setInput(oVar.a, oVar.b, this.c);
            return false;
        }
    }

    private void c() throws IOException {
        int i = this.c;
        if (i != 0) {
            int remaining = i - this.b.getRemaining();
            this.c -= remaining;
            this.a.h((long) remaining);
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.a.a();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            this.b.end();
            this.d = true;
            this.a.close();
        }
    }
}
