package com.bytedance.sdk.a.b.a.d;

import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.a.c.i;
import com.bytedance.sdk.a.b.a.c.k;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* compiled from: Http1Codec */
public final class a implements com.bytedance.sdk.a.b.a.c.c {
    final v a;
    final g b;
    final com.bytedance.sdk.a.a.e c;
    final com.bytedance.sdk.a.a.d d;
    int e = 0;
    private long f = 262144;

    public a(v vVar, g gVar, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
        this.a = vVar;
        this.b = gVar;
        this.c = eVar;
        this.d = dVar;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(y yVar, long j) {
        if ("chunked".equalsIgnoreCase(yVar.a("Transfer-Encoding"))) {
            return d();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a(y yVar) throws IOException {
        a(yVar.c(), i.a(yVar, this.b.b().a().b().type()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public ab a(aa aaVar) throws IOException {
        this.b.c.f(this.b.b);
        String a2 = aaVar.a("Content-Type");
        if (!com.bytedance.sdk.a.b.a.c.e.b(aaVar)) {
            return new h(a2, 0, l.a(b(0)));
        }
        if ("chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) {
            return new h(a2, -1, l.a(a(aaVar.a().a())));
        }
        long a3 = com.bytedance.sdk.a.b.a.c.e.a(aaVar);
        if (a3 != -1) {
            return new h(a2, a3, l.a(b(a3)));
        }
        return new h(a2, -1, l.a(e()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.d.flush();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.d.flush();
    }

    public void a(com.bytedance.sdk.a.b.r rVar, String str) throws IOException {
        if (this.e == 0) {
            this.d.b(str).b("\r\n");
            int a2 = rVar.a();
            for (int i = 0; i < a2; i++) {
                this.d.b(rVar.a(i)).b(": ").b(rVar.b(i)).b("\r\n");
            }
            this.d.b("\r\n");
            this.e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public aa.a a(boolean z) throws IOException {
        int i = this.e;
        if (i == 1 || i == 3) {
            try {
                k a2 = k.a(f());
                aa.a a3 = new aa.a().a(a2.a).a(a2.b).a(a2.c).a(c());
                if (z && a2.b == 100) {
                    return null;
                }
                this.e = 4;
                return a3;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.b);
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.e);
        }
    }

    private String f() throws IOException {
        String e2 = this.c.e(this.f);
        this.f -= (long) e2.length();
        return e2;
    }

    public com.bytedance.sdk.a.b.r c() throws IOException {
        r.a aVar = new r.a();
        while (true) {
            String f2 = f();
            if (f2.length() == 0) {
                return aVar.a();
            }
            com.bytedance.sdk.a.b.a.a.a.a(aVar, f2);
        }
    }

    public com.bytedance.sdk.a.a.r d() {
        if (this.e == 1) {
            this.e = 2;
            return new b();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public com.bytedance.sdk.a.a.r a(long j) {
        if (this.e == 1) {
            this.e = 2;
            return new d(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public s b(long j) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public s a(com.bytedance.sdk.a.b.s sVar) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new c(sVar);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public s e() throws IOException {
        if (this.e == 4) {
            g gVar = this.b;
            if (gVar != null) {
                this.e = 5;
                gVar.d();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.e);
    }

    void a(com.bytedance.sdk.a.a.i iVar) {
        t a2 = iVar.a();
        iVar.a(t.c);
        a2.f();
        a2.e();
    }

    /* compiled from: Http1Codec */
    private final class d implements com.bytedance.sdk.a.a.r {
        private final com.bytedance.sdk.a.a.i b;
        private boolean c;
        private long d;

        d(long j) {
            this.b = new com.bytedance.sdk.a.a.i(a.this.d.a());
            this.d = j;
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return this.b;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (!this.c) {
                com.bytedance.sdk.a.b.a.c.a(cVar.b(), 0, j);
                if (j <= this.d) {
                    a.this.d.a_(cVar, j);
                    this.d -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.d + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (!this.c) {
                a.this.d.flush();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.c) {
                this.c = true;
                if (this.d <= 0) {
                    a.this.a(this.b);
                    a.this.e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    /* compiled from: Http1Codec */
    private final class b implements com.bytedance.sdk.a.a.r {
        private final com.bytedance.sdk.a.a.i b;
        private boolean c;

        b() {
            this.b = new com.bytedance.sdk.a.a.i(a.this.d.a());
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return this.b;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (this.c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                a.this.d.k(j);
                a.this.d.b("\r\n");
                a.this.d.a_(cVar, j);
                a.this.d.b("\r\n");
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (!this.c) {
                a.this.d.flush();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (!this.c) {
                this.c = true;
                a.this.d.b("0\r\n\r\n");
                a.this.a(this.b);
                a.this.e = 3;
            }
        }
    }

    /* renamed from: com.bytedance.sdk.a.b.a.d.a$a  reason: collision with other inner class name */
    /* compiled from: Http1Codec */
    private abstract class AbstractC0028a implements s {
        protected final com.bytedance.sdk.a.a.i a;
        protected boolean b;
        protected long c;

        private AbstractC0028a() {
            this.a = new com.bytedance.sdk.a.a.i(a.this.c.a());
            this.c = 0;
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return this.a;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = a.this.c.a(cVar, j);
                if (a2 > 0) {
                    this.c += a2;
                }
                return a2;
            } catch (IOException e) {
                a(false, e);
                throw e;
            }
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            if (a.this.e != 6) {
                if (a.this.e == 5) {
                    a.this.a(this.a);
                    a.this.e = 6;
                    if (a.this.b != null) {
                        a.this.b.a(!z, a.this, this.c, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + a.this.e);
            }
        }
    }

    /* compiled from: Http1Codec */
    private class e extends AbstractC0028a {
        private long f;

        e(long j) throws IOException {
            super();
            this.f = j;
            if (j == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0028a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.b) {
                long j2 = this.f;
                if (j2 == 0) {
                    return -1;
                }
                long a = super.a(cVar, Math.min(j2, j));
                if (a != -1) {
                    long j3 = this.f - a;
                    this.f = j3;
                    if (j3 == 0) {
                        a(true, (IOException) null);
                    }
                    return a;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, (IOException) protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.b) {
                if (this.f != 0 && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    private class c extends AbstractC0028a {
        private final com.bytedance.sdk.a.b.s f;
        private long g = -1;
        private boolean h = true;

        c(com.bytedance.sdk.a.b.s sVar) {
            super();
            this.f = sVar;
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0028a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (!this.h) {
                return -1;
            } else {
                long j2 = this.g;
                if (j2 == 0 || j2 == -1) {
                    b();
                    if (!this.h) {
                        return -1;
                    }
                }
                long a = super.a(cVar, Math.min(j, this.g));
                if (a != -1) {
                    this.g -= a;
                    return a;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, (IOException) protocolException);
                throw protocolException;
            }
        }

        private void b() throws IOException {
            if (this.g != -1) {
                a.this.c.p();
            }
            try {
                this.g = a.this.c.m();
                String trim = a.this.c.p().trim();
                if (this.g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                } else if (this.g == 0) {
                    this.h = false;
                    com.bytedance.sdk.a.b.a.c.e.a(a.this.a.f(), this.f, a.this.c());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.b) {
                if (this.h && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    private class f extends AbstractC0028a {
        private boolean f;

        f() {
            super();
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0028a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f) {
                return -1;
            } else {
                long a = super.a(cVar, j);
                if (a != -1) {
                    return a;
                }
                this.f = true;
                a(true, (IOException) null);
                return -1;
            }
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.b) {
                if (!this.f) {
                    a(false, (IOException) null);
                }
                this.b = true;
            }
        }
    }
}
