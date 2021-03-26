package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.c.f;
import com.bytedance.sdk.a.b.r;
import java.net.URL;
import java.util.Objects;

/* compiled from: Request */
public final class y {
    final s a;
    final String b;
    final r c;
    final z d;
    final Object e;
    private volatile d f;

    y(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public s a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public r c() {
        return this.c;
    }

    public String a(String str) {
        return this.c.a(str);
    }

    public z d() {
        return this.d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.c);
        this.f = a2;
        return a2;
    }

    public boolean g() {
        return this.a.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        Object obj = this.e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* compiled from: Request */
    public static class a {
        s a;
        String b;
        r.a c;
        z d;
        Object e;

        public a() {
            this.b = "GET";
            this.c = new r.a();
        }

        a(y yVar) {
            this.a = yVar.a;
            this.b = yVar.b;
            this.d = yVar.d;
            this.e = yVar.e;
            this.c = yVar.c.c();
        }

        public a a(s sVar) {
            Objects.requireNonNull(sVar, "url == null");
            this.a = sVar;
            return this;
        }

        public a a(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            s e2 = s.e(str);
            if (e2 != null) {
                return a(e2);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        public a a(URL url) {
            Objects.requireNonNull(url, "url == null");
            s a2 = s.a(url);
            if (a2 != null) {
                return a(a2);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }

        public a a(String str, String str2) {
            this.c.c(str, str2);
            return this;
        }

        public a b(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public a b(String str) {
            this.c.b(str);
            return this;
        }

        public a a(r rVar) {
            this.c = rVar.c();
            return this;
        }

        public a a() {
            return a("GET", (z) null);
        }

        public a b() {
            return a("HEAD", (z) null);
        }

        public a a(z zVar) {
            return a("POST", zVar);
        }

        public a b(z zVar) {
            return a("DELETE", zVar);
        }

        public a c() {
            return b(c.d);
        }

        public a c(z zVar) {
            return a("PUT", zVar);
        }

        public a d(z zVar) {
            return a("PATCH", zVar);
        }

        public a a(String str, z zVar) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (zVar != null && !f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (zVar != null || !f.b(str)) {
                this.b = str;
                this.d = zVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public y d() {
            if (this.a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
