package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.r;
import java.io.Closeable;

/* compiled from: Response */
public final class aa implements Closeable {
    final y a;
    final w b;
    final int c;
    final String d;
    final q e;
    final r f;
    final ab g;
    final aa h;
    final aa i;
    final aa j;
    final long k;

    /* renamed from: l  reason: collision with root package name */
    final long f1273l;
    private volatile d m;

    aa(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.f1273l = aVar.f1274l;
    }

    public y a() {
        return this.a;
    }

    public w b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        int i2 = this.c;
        return i2 >= 200 && i2 < 300;
    }

    public String e() {
        return this.d;
    }

    public q f() {
        return this.e;
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String a2 = this.f.a(str);
        return a2 != null ? a2 : str2;
    }

    public r g() {
        return this.f;
    }

    public ab h() {
        return this.g;
    }

    public a i() {
        return new a(this);
    }

    public aa j() {
        return this.j;
    }

    public d k() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f);
        this.m = a2;
        return a2;
    }

    public long l() {
        return this.k;
    }

    public long m() {
        return this.f1273l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ab abVar = this.g;
        if (abVar != null) {
            abVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    @Override // java.lang.Object
    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a() + '}';
    }

    /* compiled from: Response */
    public static class a {
        y a;
        w b;
        int c;
        String d;
        q e;
        r.a f;
        ab g;
        aa h;
        aa i;
        aa j;
        long k;

        /* renamed from: l  reason: collision with root package name */
        long f1274l;

        public a() {
            this.c = -1;
            this.f = new r.a();
        }

        a(aa aaVar) {
            this.c = -1;
            this.a = aaVar.a;
            this.b = aaVar.b;
            this.c = aaVar.c;
            this.d = aaVar.d;
            this.e = aaVar.e;
            this.f = aaVar.f.c();
            this.g = aaVar.g;
            this.h = aaVar.h;
            this.i = aaVar.i;
            this.j = aaVar.j;
            this.k = aaVar.k;
            this.f1274l = aaVar.f1273l;
        }

        public a a(y yVar) {
            this.a = yVar;
            return this;
        }

        public a a(w wVar) {
            this.b = wVar;
            return this;
        }

        public a a(int i2) {
            this.c = i2;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a a(q qVar) {
            this.e = qVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f = rVar.c();
            return this;
        }

        public a a(ab abVar) {
            this.g = abVar;
            return this;
        }

        public a a(aa aaVar) {
            if (aaVar != null) {
                a("networkResponse", aaVar);
            }
            this.h = aaVar;
            return this;
        }

        public a b(aa aaVar) {
            if (aaVar != null) {
                a("cacheResponse", aaVar);
            }
            this.i = aaVar;
            return this;
        }

        private void a(String str, aa aaVar) {
            if (aaVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (aaVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (aaVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (aaVar.j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a c(aa aaVar) {
            if (aaVar != null) {
                d(aaVar);
            }
            this.j = aaVar;
            return this;
        }

        private void d(aa aaVar) {
            if (aaVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(long j2) {
            this.k = j2;
            return this;
        }

        public a b(long j2) {
            this.f1274l = j2;
            return this;
        }

        public aa a() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.c < 0) {
                throw new IllegalStateException("code < 0: " + this.c);
            } else if (this.d != null) {
                return new aa(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }
}
