package com.bytedance.sdk.a.b.a.a;

import com.bytedance.sdk.a.b.a.c.d;
import com.bytedance.sdk.a.b.a.c.e;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheStrategy */
public final class c {
    public final y a;
    public final aa b;

    c(y yVar, aa aaVar) {
        this.a = yVar;
        this.b = aaVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.k().d() == false) goto L_0x0059;
     */
    public static boolean a(aa aaVar, y yVar) {
        int c = aaVar.c();
        if (!(c == 200 || c == 410 || c == 414 || c == 501 || c == 203 || c == 204)) {
            if (c != 307) {
                if (!(c == 308 || c == 404 || c == 405)) {
                    switch (c) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (aaVar.a("Expires") == null) {
                if (aaVar.k().c() == -1) {
                    if (!aaVar.k().e()) {
                    }
                }
            }
        }
        if (aaVar.k().b() || yVar.f().b()) {
            return false;
        }
        return true;
    }

    /* compiled from: CacheStrategy */
    public static class a {
        final long a;
        final y b;
        final aa c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;

        /* renamed from: l  reason: collision with root package name */
        private int f1264l = -1;

        public a(long j2, y yVar, aa aaVar) {
            this.a = j2;
            this.b = yVar;
            this.c = aaVar;
            if (aaVar != null) {
                this.i = aaVar.l();
                this.j = aaVar.m();
                r g2 = aaVar.g();
                int a2 = g2.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    String a3 = g2.a(i2);
                    String b2 = g2.b(i2);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.d = d.a(b2);
                        this.e = b2;
                    } else if ("Expires".equalsIgnoreCase(a3)) {
                        this.h = d.a(b2);
                    } else if ("Last-Modified".equalsIgnoreCase(a3)) {
                        this.f = d.a(b2);
                        this.g = b2;
                    } else if ("ETag".equalsIgnoreCase(a3)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.f1264l = e.b(b2, -1);
                    }
                }
            }
        }

        public c a() {
            c b2 = b();
            return (b2.a == null || !this.b.f().i()) ? b2 : new c(null, null);
        }

        private c b() {
            if (this.c == null) {
                return new c(this.b, null);
            }
            if (this.b.g() && this.c.f() == null) {
                return new c(this.b, null);
            }
            if (!c.a(this.c, this.b)) {
                return new c(this.b, null);
            }
            com.bytedance.sdk.a.b.d f2 = this.b.f();
            if (f2.a() || a(this.b)) {
                return new c(this.b, null);
            }
            com.bytedance.sdk.a.b.d k2 = this.c.k();
            if (k2.j()) {
                return new c(null, this.c);
            }
            long d2 = d();
            long c2 = c();
            if (f2.c() != -1) {
                c2 = Math.min(c2, TimeUnit.SECONDS.toMillis((long) f2.c()));
            }
            long j2 = 0;
            long millis = f2.h() != -1 ? TimeUnit.SECONDS.toMillis((long) f2.h()) : 0;
            if (!k2.f() && f2.g() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) f2.g());
            }
            if (!k2.a()) {
                long j3 = millis + d2;
                if (j3 < j2 + c2) {
                    aa.a i2 = this.c.i();
                    if (j3 >= c2) {
                        i2.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d2 > 86400000 && e()) {
                        i2.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, i2.a());
                }
            }
            String str = this.k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f != null) {
                str = this.g;
            } else if (this.d == null) {
                return new c(this.b, null);
            } else {
                str = this.e;
            }
            r.a c3 = this.b.c().c();
            com.bytedance.sdk.a.b.a.a.a.a(c3, str2, str);
            return new c(this.b.e().a(c3.a()).d(), this.c);
        }

        private long c() {
            com.bytedance.sdk.a.b.d k2 = this.c.k();
            if (k2.c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) k2.c());
            }
            if (this.h != null) {
                Date date = this.d;
                long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f == null || this.c.a().a().k() != null) {
                return 0;
            } else {
                Date date2 = this.d;
                long time2 = (date2 != null ? date2.getTime() : this.i) - this.f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        private long d() {
            Date date = this.d;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0L, this.j - date.getTime());
            }
            if (this.f1264l != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) this.f1264l));
            }
            long j3 = this.j;
            return j2 + (j3 - this.i) + (this.a - j3);
        }

        private boolean e() {
            return this.c.k().c() == -1 && this.h == null;
        }

        private static boolean a(y yVar) {
            return (yVar.a("If-Modified-Since") == null && yVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
