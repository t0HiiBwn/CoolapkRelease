package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.LookupResult;
import com.tencent.msdk.dns.core.c;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.j;
import com.tencent.msdk.dns.core.l;
import com.tencent.msdk.dns.core.rest.share.AbsRestDns;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/* compiled from: AbsHttpDns */
public abstract class a extends AbsRestDns {
    protected final int a;
    protected final c b;

    public abstract String a(String str, g gVar, int i);

    public abstract String a(String str, String str2);

    public abstract SocketAddress a(String str, int i);

    public abstract String b();

    public abstract String c();

    public a(int i) {
        i = 2 != i ? 1 : i;
        this.a = i;
        this.b = new c(c(), i);
    }

    @Override // com.tencent.msdk.dns.core.f
    public c a() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e0, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e1, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e3, code lost:
        r10 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:14:0x006e] */
    @Override // com.tencent.msdk.dns.core.f
    public LookupResult a(l<g> lVar) {
        Exception e;
        BufferedReader bufferedReader;
        if (lVar != null) {
            String str = lVar.b;
            int i = lVar.c;
            g gVar = (g) lVar.d;
            AbsRestDns.Statistics statistics = new AbsRestDns.Statistics();
            statistics.retryTimes = lVar.f1450l;
            statistics.asyncLookup = lVar.k;
            statistics.netChangeLookup = lVar.m;
            statistics.startLookup();
            if (a(lVar, statistics)) {
                statistics.endLookup();
                return new LookupResult(statistics.ips, statistics);
            }
            BufferedReader bufferedReader2 = null;
            try {
                String a2 = a(str, gVar, lVar.f);
                if (TextUtils.isEmpty(a2)) {
                    statistics.errorCode = 1007;
                    LookupResult lookupResult = new LookupResult(statistics.ips, statistics);
                    com.tencent.msdk.dns.base.e.a.a((Closeable) null);
                    statistics.endLookup();
                    return lookupResult;
                }
                try {
                    URLConnection openConnection = new URL(a2).openConnection();
                    openConnection.setConnectTimeout(i);
                    openConnection.setReadTimeout(i);
                    bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream(), "UTF-8"));
                } catch (Exception e2) {
                    Exception e3 = e2;
                    statistics.errorCode = 31002;
                    statistics.errorMsg = e3.getMessage();
                    throw e3;
                }
                try {
                    String a3 = a(bufferedReader.readLine(), gVar.c);
                    b.b(b() + "lookup byUrl: %s, rsp:[%s]", a2, a3);
                    if (TextUtils.isEmpty(a3)) {
                        statistics.isGetEmptyResponse = true;
                        statistics.errorCode = 41001;
                    }
                    com.tencent.msdk.dns.core.rest.share.a.a a4 = com.tencent.msdk.dns.core.rest.share.a.b.a(gVar.b, this.a, a3);
                    if (a4 == com.tencent.msdk.dns.core.rest.share.a.a.a) {
                        statistics.isGetEmptyResponse = true;
                        statistics.errorCode = 41002;
                        LookupResult lookupResult2 = new LookupResult(statistics.ips, statistics);
                        com.tencent.msdk.dns.base.e.a.a((Closeable) bufferedReader);
                        statistics.endLookup();
                        return lookupResult2;
                    }
                    this.c.a(lVar, a4);
                    statistics.errorCode = 0;
                    statistics.clientIp = a4.c;
                    statistics.ttl = a4.e;
                    statistics.ips = a4.d;
                    com.tencent.msdk.dns.base.e.a.a((Closeable) bufferedReader);
                    statistics.endLookup();
                    return new LookupResult(statistics.ips, statistics);
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader2 = bufferedReader;
                    try {
                        b.b(e, b() + "lookup failed", new Object[0]);
                        com.tencent.msdk.dns.base.e.a.a((Closeable) bufferedReader2);
                        statistics.endLookup();
                        return new LookupResult(statistics.ips, statistics);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        com.tencent.msdk.dns.base.e.a.a((Closeable) bufferedReader2);
                        statistics.endLookup();
                        throw th2;
                    }
                } catch (Throwable th3) {
                }
            } catch (Exception e5) {
                e = e5;
                b.b(e, b() + "lookup failed", new Object[0]);
                com.tencent.msdk.dns.base.e.a.a((Closeable) bufferedReader2);
                statistics.endLookup();
                return new LookupResult(statistics.ips, statistics);
            }
        } else {
            throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
        }
    }

    @Override // com.tencent.msdk.dns.core.f
    public f.b a(j<g> jVar) {
        return new C0133a(jVar, this, null);
    }

    /* renamed from: com.tencent.msdk.dns.core.rest.share.a$a  reason: collision with other inner class name */
    /* compiled from: AbsHttpDns */
    private class C0133a extends AbsRestDns.a {
        private SocketChannel h = null;
        private SocketAddress i = null;
        private ByteBuffer j = null;
        private StringBuilder k = null;

        /* renamed from: l  reason: collision with root package name */
        private ByteBuffer f1452l = null;
        private final f.b.a m = new AbsRestDns.a.C0132a() {
            /* class com.tencent.msdk.dns.core.rest.share.a.C0133a.AnonymousClass1 */

            @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a.C0132a, com.tencent.msdk.dns.core.f.b.a
            public boolean b() {
                if (C0133a.this.h != null) {
                    try {
                        boolean finishConnect = C0133a.this.h.finishConnect();
                        C0133a.this.e.interestOps(4);
                        return finishConnect;
                    } catch (Exception e) {
                        b.b(e, a.this.b() + "connect failed", new Object[0]);
                        C0133a.this.d();
                        C0133a.this.f.errorCode = 11001;
                        C0133a.this.f.errorMsg = e.getMessage();
                    }
                }
                return false;
            }

            @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a.C0132a, com.tencent.msdk.dns.core.f.b.a
            public boolean c() {
                if (C0133a.this.h != null) {
                    return C0133a.this.h.isConnected() && super.c();
                }
                return super.c();
            }

            @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a.C0132a, com.tencent.msdk.dns.core.f.b.a
            public boolean d() {
                if (C0133a.this.h == null) {
                    return super.d();
                }
                b.b(a.this.b() + ", channel isConnected:" + C0133a.this.h.isConnected(), new Object[0]);
                if (!C0133a.this.h.isConnected() || !super.d()) {
                    return false;
                }
                return true;
            }
        };

        @Override // com.tencent.msdk.dns.core.f.b
        public f.b.a h() {
            return this.m;
        }

        C0133a(j<g> jVar, f fVar, AbsRestDns.a aVar) {
            super(jVar, fVar, aVar);
            if (3 != this.b) {
                Selector p = this.c.p();
                if (p != null) {
                    try {
                        this.h = SocketChannel.open();
                        try {
                            b.b(a.this.b() + "%s opened", this.h);
                            try {
                                this.h.configureBlocking(false);
                                try {
                                    this.e = this.h.register(p, 13);
                                    this.e.attach(this.h);
                                    this.b = 1;
                                    SocketAddress a2 = a.this.a(((g) this.c.c()).b, a.this.a);
                                    this.i = a2;
                                    if (a2 == null) {
                                        b.b(a.this.b() + "get target socket address failed", new Object[0]);
                                        this.f.errorCode = 1006;
                                        d();
                                    }
                                } catch (Exception e) {
                                    this.f.errorCode = 1005;
                                    this.f.errorMsg = e.getMessage();
                                    throw e;
                                }
                            } catch (Exception e2) {
                                this.f.errorCode = 1004;
                                this.f.errorMsg = e2.getMessage();
                                throw e2;
                            }
                        } catch (Exception e3) {
                            b.b(e3, a.this.b() + "create socket channel failed", new Object[0]);
                            d();
                        }
                    } catch (Exception e4) {
                        this.f.errorCode = 1001;
                        this.f.errorMsg = e4.getMessage();
                        throw e4;
                    }
                } else {
                    throw new IllegalArgumentException("selector".concat(" can not be null"));
                }
            }
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected int j() {
            try {
                this.h.connect(this.i);
                return 0;
            } catch (Exception e) {
                b.b(e, a.this.b() + "connect failed", new Object[0]);
                d();
                this.f.errorCode = 11001;
                this.f.errorMsg = e.getMessage();
                return 1;
            }
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected int k() {
            String a2 = a.this.a(this.c.b(), (g) this.c.c(), this.c.e());
            if (TextUtils.isEmpty(a2)) {
                this.f.errorCode = 1007;
                d();
                return 1;
            }
            String a3 = com.tencent.msdk.dns.base.e.b.a(a2);
            if (TextUtils.isEmpty(a3)) {
                this.f.errorCode = 1008;
                d();
                return 1;
            }
            try {
                b.a(a.this.b() + "send httpReq:{\n%s}", a3);
                b.b(a.this.b() + "lookup send byUrl: %s", a2);
                if (this.f1452l == null) {
                    this.f1452l = ByteBuffer.wrap(a3.getBytes("UTF-8"));
                }
                ByteBuffer byteBuffer = this.f1452l;
                int i2 = 0;
                while (byteBuffer.hasRemaining()) {
                    int write = this.h.write(byteBuffer);
                    StringBuilder sb = new StringBuilder();
                    sb.append(a.this.b());
                    sb.append("send request count:");
                    i2++;
                    sb.append(i2);
                    sb.append(", res:");
                    sb.append(write);
                    b.b(sb.toString(), new Object[0]);
                    if (write <= 0) {
                        break;
                    }
                }
                if (byteBuffer.hasRemaining()) {
                    b.b(a.this.b() + "send request has remaining, try again", new Object[0]);
                    return 2;
                }
                this.f1452l = null;
                this.e.interestOps(1);
                b.b(a.this.b() + "send request finish", new Object[0]);
                return 0;
            } catch (Exception e) {
                b.b(e, a.this.b() + "send request failed, for exception", new Object[0]);
                d();
                this.f.errorCode = 21001;
                this.f.errorMsg = e.getMessage();
                return 1;
            }
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected com.tencent.msdk.dns.core.rest.share.a.a l() {
            int read;
            b.b(a.this.b() + "receive responseInternal call", new Object[0]);
            g gVar = (g) this.c.c();
            if (this.j == null) {
                this.j = ByteBuffer.allocate(1024);
            }
            if (this.k == null) {
                this.k = new StringBuilder();
            }
            ByteBuffer byteBuffer = this.j;
            StringBuilder sb = this.k;
            int i2 = 0;
            while (true) {
                try {
                    read = this.h.read(byteBuffer);
                    b.b(a.this.b() + "receive response get len:%d, lastLen:%d", Integer.valueOf(read), Integer.valueOf(i2));
                    if (read > 0) {
                        i2 += read;
                        byteBuffer.flip();
                        read = byteBuffer.limit();
                        byte[] bArr = new byte[read];
                        byteBuffer.get(bArr, 0, read);
                        String str = new String(bArr, Charset.forName("UTF-8"));
                        sb.append(str);
                        if (com.tencent.msdk.dns.base.e.b.b(str)) {
                            b.b(a.this.b() + "receive response check http rsp finished:%d, so break", Integer.valueOf(read));
                            break;
                        }
                        byteBuffer.clear();
                        continue;
                    } else if (read == 0) {
                        b.b(a.this.b() + "receive response get len:0, and break", new Object[0]);
                        break;
                    }
                    if (read < 0) {
                        break;
                    }
                } catch (Exception e) {
                    b.b(e, a.this.b() + "receive response failed, for exception", new Object[0]);
                    this.f.isGetEmptyResponse = true;
                    this.f.errorCode = 31002;
                    this.f.errorMsg = e.getMessage();
                    return com.tencent.msdk.dns.core.rest.share.a.a.a;
                }
            }
            b.b(a.this.b() + "receive response get total len:%d", Integer.valueOf(i2));
            if (read == 0) {
                b.b(a.this.b() + "receive response failed, need continue, for total len:%d", Integer.valueOf(i2));
                this.f.errorCode = 31001;
                return com.tencent.msdk.dns.core.rest.share.a.a.b;
            } else if (i2 <= 0) {
                b.b(a.this.b() + "receive response failed, for total len:%d", Integer.valueOf(i2));
                this.f.isGetEmptyResponse = true;
                this.f.errorCode = 31002;
                return com.tencent.msdk.dns.core.rest.share.a.a.a;
            } else {
                String sb2 = sb.toString();
                b.a(a.this.b() + "receive rspHttpRsp:{\n%s}", sb2);
                String c = com.tencent.msdk.dns.base.e.b.c(sb2);
                String a2 = a.this.a(c, gVar.c);
                b.b(a.this.b() + "receive rawLen:%d, raw:[%s], rsp body content:[%s]", Integer.valueOf(i2), c, a2);
                if (!TextUtils.isEmpty(a2)) {
                    return com.tencent.msdk.dns.core.rest.share.a.b.a(gVar.b, a.this.a, a2);
                }
                this.f.isGetEmptyResponse = true;
                this.f.errorCode = 41001;
                return com.tencent.msdk.dns.core.rest.share.a.a.a;
            }
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected void m() {
            com.tencent.msdk.dns.base.e.a.a((Closeable) this.h);
            this.f1452l = null;
            this.j = null;
            this.k = null;
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected AbsRestDns.a n() {
            return new C0133a(this.c, this.d, this);
        }
    }
}
