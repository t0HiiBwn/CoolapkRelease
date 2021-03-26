package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Hpack */
final class d {
    static final c[] a = {new c(c.f, ""), new c(c.c, "GET"), new c(c.c, "POST"), new c(c.d, "/"), new c(c.d, "/index.html"), new c(c.e, "http"), new c(c.e, "https"), new c(c.b, "200"), new c(c.b, "204"), new c(c.b, "206"), new c(c.b, "304"), new c(c.b, "400"), new c(c.b, "404"), new c(c.b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
    static final Map<f, Integer> b = a();

    /* compiled from: Hpack */
    static final class a {
        c[] a;
        int b;
        int c;
        int d;
        private final List<c> e;
        private final e f;
        private final int g;
        private int h;

        a(int i, s sVar) {
            this(i, i, sVar);
        }

        a(int i, int i2, s sVar) {
            this.e = new ArrayList();
            c[] cVarArr = new c[8];
            this.a = cVarArr;
            this.b = cVarArr.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.f = l.a(sVar);
        }

        private void d() {
            int i = this.h;
            int i2 = this.d;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                e();
            } else {
                a(i2 - i);
            }
        }

        private void e() {
            Arrays.fill(this.a, (Object) null);
            this.b = this.a.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.a.length;
                while (true) {
                    length--;
                    i2 = this.b;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.a[length].i;
                    this.d -= this.a[length].i;
                    this.c--;
                    i3++;
                }
                c[] cVarArr = this.a;
                System.arraycopy(cVarArr, i2 + 1, cVarArr, i2 + 1 + i3, this.c);
                this.b += i3;
            }
            return i3;
        }

        void a() throws IOException {
            while (!this.f.e()) {
                int h2 = this.f.h() & 255;
                if (h2 == 128) {
                    throw new IOException("index == 0");
                } else if ((h2 & 128) == 128) {
                    b(a(h2, 127) - 1);
                } else if (h2 == 64) {
                    g();
                } else if ((h2 & 64) == 64) {
                    e(a(h2, 63) - 1);
                } else if ((h2 & 32) == 32) {
                    int a2 = a(h2, 31);
                    this.h = a2;
                    if (a2 < 0 || a2 > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (h2 == 16 || h2 == 0) {
                    f();
                } else {
                    d(a(h2, 15) - 1);
                }
            }
        }

        public List<c> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.e.add(d.a[i]);
                return;
            }
            int c2 = c(i - d.a.length);
            if (c2 >= 0) {
                c[] cVarArr = this.a;
                if (c2 <= cVarArr.length - 1) {
                    this.e.add(cVarArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int c(int i) {
            return this.b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new c(f(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new c(d.a(c()), c()));
        }

        private void e(int i) throws IOException {
            a(-1, new c(f(i), c()));
        }

        private void g() throws IOException {
            a(-1, new c(d.a(c()), c()));
        }

        private f f(int i) {
            if (g(i)) {
                return d.a[i].g;
            }
            return this.a[c(i - d.a.length)].g;
        }

        private boolean g(int i) {
            return i >= 0 && i <= d.a.length - 1;
        }

        private void a(int i, c cVar) {
            this.e.add(cVar);
            int i2 = cVar.i;
            if (i != -1) {
                i2 -= this.a[c(i)].i;
            }
            int i3 = this.h;
            if (i2 > i3) {
                e();
                return;
            }
            int a2 = a((this.d + i2) - i3);
            if (i == -1) {
                int i4 = this.c + 1;
                c[] cVarArr = this.a;
                if (i4 > cVarArr.length) {
                    c[] cVarArr2 = new c[(cVarArr.length * 2)];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.b = this.a.length - 1;
                    this.a = cVarArr2;
                }
                int i5 = this.b;
                this.b = i5 - 1;
                this.a[i5] = cVar;
                this.c++;
            } else {
                this.a[i + c(i) + a2] = cVar;
            }
            this.d += i2;
        }

        private int h() throws IOException {
            return this.f.h() & 255;
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int h2 = h();
                if ((h2 & 128) == 0) {
                    return i2 + (h2 << i4);
                }
                i2 += (h2 & 127) << i4;
                i4 += 7;
            }
        }

        f c() throws IOException {
            int h2 = h();
            boolean z = (h2 & 128) == 128;
            int a2 = a(h2, 127);
            if (z) {
                return f.a(k.a().a(this.f.g((long) a2)));
            }
            return this.f.c((long) a2);
        }
    }

    private static Map<f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i = 0;
        while (true) {
            c[] cVarArr = a;
            if (i >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i].g)) {
                linkedHashMap.put(cVarArr[i].g, Integer.valueOf(i));
            }
            i++;
        }
    }

    /* compiled from: Hpack */
    static final class b {
        int a;
        int b;
        c[] c;
        int d;
        int e;
        int f;
        private final c g;
        private final boolean h;
        private int i;
        private boolean j;

        b(c cVar) {
            this(4096, true, cVar);
        }

        b(int i2, boolean z, c cVar) {
            this.i = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.c = cVarArr;
            this.d = cVarArr.length - 1;
            this.e = 0;
            this.f = 0;
            this.a = i2;
            this.b = i2;
            this.h = z;
            this.g = cVar;
        }

        private void a() {
            Arrays.fill(this.c, (Object) null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    i3 = this.d;
                    if (length < i3 || i2 <= 0) {
                        break;
                    }
                    i2 -= this.c[length].i;
                    this.f -= this.c[length].i;
                    this.e--;
                    i4++;
                }
                c[] cVarArr = this.c;
                System.arraycopy(cVarArr, i3 + 1, cVarArr, i3 + 1 + i4, this.e);
                c[] cVarArr2 = this.c;
                int i5 = this.d;
                Arrays.fill(cVarArr2, i5 + 1, i5 + 1 + i4, (Object) null);
                this.d += i4;
            }
            return i4;
        }

        private void a(c cVar) {
            int i2 = cVar.i;
            int i3 = this.b;
            if (i2 > i3) {
                a();
                return;
            }
            b((this.f + i2) - i3);
            int i4 = this.e + 1;
            c[] cVarArr = this.c;
            if (i4 > cVarArr.length) {
                c[] cVarArr2 = new c[(cVarArr.length * 2)];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.d = this.c.length - 1;
                this.c = cVarArr2;
            }
            int i5 = this.d;
            this.d = i5 - 1;
            this.c[i5] = cVar;
            this.e++;
            this.f += i2;
        }

        void a(List<c> list) throws IOException {
            int i2;
            int i3;
            if (this.j) {
                int i4 = this.i;
                if (i4 < this.b) {
                    a(i4, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                a(this.b, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                c cVar = list.get(i5);
                f f2 = cVar.g.f();
                f fVar = cVar.h;
                Integer num = d.b.get(f2);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        if (com.bytedance.sdk.a.b.a.c.a(d.a[i3 - 1].h, fVar)) {
                            i2 = i3;
                        } else if (com.bytedance.sdk.a.b.a.c.a(d.a[i3].h, fVar)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.d + 1;
                    int length = this.c.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (com.bytedance.sdk.a.b.a.c.a(this.c[i6].g, f2)) {
                            if (com.bytedance.sdk.a.b.a.c.a(this.c[i6].h, fVar)) {
                                i3 = d.a.length + (i6 - this.d);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.d) + d.a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    a(i3, 127, 128);
                } else if (i2 == -1) {
                    this.g.i(64);
                    a(f2);
                    a(fVar);
                    a(cVar);
                } else if (!f2.a(c.a) || c.f.equals(f2)) {
                    a(i2, 63, 64);
                    a(fVar);
                    a(cVar);
                } else {
                    a(i2, 15, 0);
                    a(fVar);
                }
            }
        }

        void a(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.g.i(i2 | i4);
                return;
            }
            this.g.i(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.g.i(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.g.i(i5);
        }

        void a(f fVar) throws IOException {
            if (!this.h || k.a().a(fVar) >= fVar.g()) {
                a(fVar.g(), 127, 0);
                this.g.a(fVar);
                return;
            }
            c cVar = new c();
            k.a().a(fVar, cVar);
            f n = cVar.n();
            a(n.g(), 127, 128);
            this.g.a(n);
        }

        void a(int i2) {
            this.a = i2;
            int min = Math.min(i2, 16384);
            int i3 = this.b;
            if (i3 != min) {
                if (min < i3) {
                    this.i = Math.min(this.i, min);
                }
                this.j = true;
                this.b = min;
                b();
            }
        }

        private void b() {
            int i2 = this.b;
            int i3 = this.f;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                a();
            } else {
                b(i3 - i2);
            }
        }
    }

    static f a(f fVar) throws IOException {
        int g = fVar.g();
        for (int i = 0; i < g; i++) {
            byte a2 = fVar.a(i);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }
}
