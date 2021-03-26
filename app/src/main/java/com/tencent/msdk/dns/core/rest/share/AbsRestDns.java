package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.LookupResult;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.j;
import com.tencent.msdk.dns.core.l;
import com.tencent.msdk.dns.core.stat.AbsStatistics;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbsRestDns implements f<g> {
    protected final d c = new d(this, new com.tencent.msdk.dns.core.a.a());

    protected boolean a(l<g> lVar, Statistics statistics) {
        String str;
        LookupResult a2;
        if (lVar == null) {
            throw new IllegalArgumentException("lookupParams".concat(" can not be empty"));
        } else if (statistics != null) {
            if (!lVar.k && (a2 = this.c.a((str = lVar.b))) != null) {
                String[] strArr = a2.ipSet.ips;
                if (!com.tencent.msdk.dns.base.e.a.a((Object[]) strArr)) {
                    Statistics statistics2 = (Statistics) a2.stat;
                    statistics.errorCode = 0;
                    statistics.clientIp = statistics2.clientIp;
                    statistics.ttl = statistics2.ttl;
                    statistics.ips = strArr;
                    statistics.cached = true;
                    b.b("Lookup for %s, cache hit", str);
                    return true;
                }
            }
            return false;
        } else {
            throw new IllegalArgumentException("stat".concat(" can not be null"));
        }
    }

    @Override // com.tencent.msdk.dns.core.f
    public LookupResult b(l<g> lVar) {
        Statistics statistics = new Statistics();
        statistics.retryTimes = lVar.f1450l;
        statistics.asyncLookup = lVar.k;
        statistics.netChangeLookup = lVar.m;
        statistics.startLookup();
        a(lVar, statistics);
        statistics.endLookup();
        return new LookupResult(statistics.ips, statistics);
    }

    public abstract class a implements f.b {
        private final a a;
        protected int b = 0;
        protected j<g> c;
        protected final f d;
        protected SelectionKey e = null;
        protected final Statistics f;
        private List<a> h;

        protected abstract int j();

        protected abstract int k();

        protected abstract com.tencent.msdk.dns.core.rest.share.a.a l();

        protected abstract void m();

        protected abstract a n();

        public a(j<g> jVar, f fVar, a aVar) {
            Statistics statistics = new Statistics();
            this.f = statistics;
            this.h = Collections.emptyList();
            if (jVar == null) {
                throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
            } else if (fVar != null) {
                statistics.startLookup();
                statistics.retryTimes = jVar.j();
                statistics.asyncLookup = jVar.i();
                statistics.netChangeLookup = jVar.k();
                this.c = jVar;
                this.d = fVar;
                this.a = aVar;
                if (!jVar.i() && AbsRestDns.this.c.a(jVar.b()) != null) {
                    this.b = 3;
                }
            } else {
                throw new IllegalArgumentException("dns".concat(" can not be null"));
            }
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public void a() {
            int i;
            if (1 == this.b) {
                int i2 = 4;
                int i3 = 2;
                try {
                    if (j() != 2 && i2 != i) {
                    }
                } finally {
                    if (i2 != this.b) {
                        this.b = i3;
                    }
                }
            }
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public final void b() {
            int i;
            if (2 == this.b) {
                int i2 = 3;
                int i3 = 4;
                try {
                    if (k() != 2 && i3 != i) {
                    }
                } finally {
                    if (i3 != this.b) {
                        this.b = i2;
                    }
                }
            }
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public final String[] c() {
            if (3 != this.b) {
                b.b("HttpDns(%d) mState is not readable", Integer.valueOf(this.d.a().b));
                return this.f.ips;
            }
            com.tencent.msdk.dns.core.rest.share.a.a aVar = com.tencent.msdk.dns.core.rest.share.a.a.a;
            try {
                if (AbsRestDns.this.a(this.c.a(), this.f)) {
                    return this.f.ips;
                }
                com.tencent.msdk.dns.core.rest.share.a.a l2 = l();
                if (!(l2 == com.tencent.msdk.dns.core.rest.share.a.a.a || l2 == com.tencent.msdk.dns.core.rest.share.a.a.b)) {
                    this.f.errorCode = 0;
                    AbsRestDns.this.c.a(this.c.a(), l2);
                }
                this.f.clientIp = l2.c;
                this.f.ttl = l2.e;
                this.f.ips = l2.d;
                if (l2 != com.tencent.msdk.dns.core.rest.share.a.a.b) {
                    d();
                    o();
                }
                return this.f.ips;
            } finally {
                if (aVar != com.tencent.msdk.dns.core.rest.share.a.a.b) {
                    d();
                    o();
                }
            }
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public final void d() {
            if (4 != this.b) {
                this.b = 4;
                this.f.endLookup();
                m();
            }
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public final f.b e() {
            a n = n();
            if (Collections.emptyList() == this.h) {
                this.h = new ArrayList();
            }
            this.h.add(n);
            return n;
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public final f f() {
            return this.d;
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public final boolean g() {
            return 4 == this.b;
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public f.c i() {
            return this.f;
        }

        private void o() {
            if (4 == this.b) {
                a aVar = this.a;
                if (aVar != null) {
                    aVar.d();
                }
                for (a aVar2 : this.h) {
                    aVar2.d();
                }
            }
        }

        /* renamed from: com.tencent.msdk.dns.core.rest.share.AbsRestDns$a$a  reason: collision with other inner class name */
        public class C0132a implements f.b.a {
            @Override // com.tencent.msdk.dns.core.f.b.a
            public boolean b() {
                return false;
            }

            public C0132a() {
            }

            @Override // com.tencent.msdk.dns.core.f.b.a
            public boolean a() {
                if (a.this.e == null) {
                    if (1 == a.this.b) {
                        return true;
                    }
                    return false;
                } else if (!a.this.e.isValid()) {
                    a.this.d();
                    return false;
                } else if (1 != a.this.b || !a.this.e.isConnectable()) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override // com.tencent.msdk.dns.core.f.b.a
            public boolean c() {
                if (a.this.e == null) {
                    if (3 == a.this.b) {
                        return true;
                    }
                    return false;
                } else if (!a.this.e.isValid()) {
                    a.this.d();
                    return false;
                } else if (3 != a.this.b || !a.this.e.isReadable()) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override // com.tencent.msdk.dns.core.f.b.a
            public boolean d() {
                if (a.this.e == null) {
                    if (2 == a.this.b) {
                        return true;
                    }
                    return false;
                } else if (!a.this.e.isValid()) {
                    a.this.d();
                    return false;
                } else if (2 != a.this.b || !a.this.e.isWritable()) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override // com.tencent.msdk.dns.core.f.b.a
            public boolean e() {
                if (a.this.e == null) {
                    if (a.this.b == 0) {
                        return true;
                    }
                    return false;
                } else if (a.this.e.isValid()) {
                    return true;
                } else {
                    a.this.d();
                    return false;
                }
            }
        }
    }

    public static class Statistics extends AbsStatistics {
        public static final Statistics NOT_LOOKUP;
        public boolean asyncLookup = false;
        public boolean cached = false;
        public String clientIp = "0";
        public int errorCode = 2;
        public String errorMsg = " ";
        public boolean netChangeLookup = false;
        public int retryTimes = 0;
        public int ttl = 0;

        static {
            Statistics statistics = new Statistics();
            NOT_LOOKUP = statistics;
            statistics.errorCode = 1;
        }

        public Statistics() {
        }

        Statistics(String[] strArr, String str, int i) {
            if (strArr == null) {
                throw new IllegalArgumentException("ips".concat(" can not be null"));
            } else if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("clientIp".concat(" can not be empty"));
            } else if (!com.tencent.msdk.dns.core.rest.share.a.a.a(i)) {
                this.ips = strArr;
                this.clientIp = str;
                this.ttl = i;
            } else {
                throw new IllegalArgumentException("ttl".concat(" is invalid"));
            }
        }

        public String toString() {
            return "Statistics{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', clientIp='" + this.clientIp + "', ttl=" + this.ttl + ", retryTimes=" + this.retryTimes + ", cached=" + this.cached + ", asyncLookup=" + this.asyncLookup + ", netChangeLookup=" + this.netChangeLookup + ", ips=" + Arrays.toString(this.ips) + ", costTimeMills=" + this.costTimeMills + ", startLookupTimeMills=" + this.startLookupTimeMills + '}';
        }
    }
}
