package com.tencent.msdk.dns.core.rest.c;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.LookupResult;
import com.tencent.msdk.dns.core.c;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.j;
import com.tencent.msdk.dns.core.l;
import com.tencent.msdk.dns.core.rest.share.AbsRestDns;
import com.tencent.msdk.dns.core.rest.share.g;
import com.tencent.msdk.dns.core.rest.share.h;
import java.io.Closeable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;

/* compiled from: UdpDns */
public final class b extends AbsRestDns {
    private final int a;
    private final c b;

    public b(int i) {
        i = 2 != i ? 1 : i;
        this.a = i;
        this.b = new c("Udp", i);
    }

    @Override // com.tencent.msdk.dns.core.f
    public c a() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010f, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0110, code lost:
        r4.errorCode = 31002;
        r4.errorMsg = r15.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0118, code lost:
        throw r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0125, code lost:
        r15 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0126, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0128, code lost:
        r15 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0129, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0163, code lost:
        r5.close();
        com.tencent.msdk.dns.base.log.b.b("%s closed", r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0125 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0163  */
    @Override // com.tencent.msdk.dns.core.f
    public LookupResult a(l<g> lVar) {
        if (lVar != null) {
            String str = lVar.b;
            int i = lVar.c;
            g gVar = (g) lVar.d;
            AbsRestDns.Statistics statistics = new AbsRestDns.Statistics();
            statistics.retryTimes = lVar.l;
            statistics.asyncLookup = lVar.k;
            statistics.netChangeLookup = lVar.m;
            statistics.startLookup();
            if (a(lVar, statistics)) {
                statistics.endLookup();
                return new LookupResult(statistics.ips, statistics);
            }
            DatagramSocket datagramSocket = null;
            try {
                DatagramSocket datagramSocket2 = new DatagramSocket();
                try {
                    com.tencent.msdk.dns.base.log.b.b("%s opened", datagramSocket2);
                    try {
                        datagramSocket2.setSoTimeout(i);
                        InetSocketAddress a2 = c.a(gVar.b, this.a);
                        if (a2 == null) {
                            com.tencent.msdk.dns.base.log.b.b("UdpDns(%d) lookup for %s get socket address failed", Integer.valueOf(this.a), str);
                            statistics.errorCode = 1006;
                        } else {
                            String a3 = a(str, gVar, lVar.f);
                            if (TextUtils.isEmpty(a3)) {
                                statistics.errorCode = 1007;
                            } else {
                                byte[] bytes = a3.getBytes("UTF-8");
                                datagramSocket2.send(new DatagramPacket(bytes, bytes.length, a2.getAddress(), a2.getPort()));
                                DatagramPacket datagramPacket = new DatagramPacket(new byte[2048], 2048);
                                datagramSocket2.receive(datagramPacket);
                                String b2 = a.b(new String(datagramPacket.getData(), 0, datagramPacket.getLength()), gVar.c);
                                com.tencent.msdk.dns.base.log.b.b("UdpDns(%d) lookup for %s rsp:[%s]", Integer.valueOf(this.a), str, b2);
                                if (TextUtils.isEmpty(b2)) {
                                    statistics.isGetEmptyResponse = true;
                                    statistics.errorCode = 41001;
                                } else {
                                    com.tencent.msdk.dns.core.rest.share.a.a a4 = com.tencent.msdk.dns.core.rest.share.a.b.a(gVar.b, this.a, b2);
                                    if (a4 == com.tencent.msdk.dns.core.rest.share.a.a.a) {
                                        statistics.isGetEmptyResponse = true;
                                        statistics.errorCode = 41002;
                                    } else {
                                        this.c.a(lVar, a4);
                                        statistics.errorCode = 0;
                                        statistics.clientIp = a4.c;
                                        statistics.ttl = a4.e;
                                        statistics.ips = a4.d;
                                    }
                                }
                            }
                        }
                        datagramSocket2.close();
                        com.tencent.msdk.dns.base.log.b.b("%s closed", datagramSocket2);
                        statistics.endLookup();
                        return new LookupResult(statistics.ips, statistics);
                    } catch (SocketException e) {
                        statistics.errorCode = 1002;
                        statistics.errorMsg = e.getMessage();
                        throw e;
                    }
                } catch (Exception e2) {
                    statistics.errorCode = 31002;
                    statistics.errorMsg = e2.getMessage();
                    throw e2;
                } catch (Throwable th) {
                }
            } catch (SocketException e3) {
                statistics.errorCode = 1001;
                statistics.errorMsg = e3.getMessage();
                throw e3;
            } catch (Exception e4) {
                Exception e5 = e4;
                try {
                    com.tencent.msdk.dns.base.log.b.b(e5, "HttpDns(%d) lookup failed", Integer.valueOf(this.a));
                    if (datagramSocket != null) {
                        datagramSocket.close();
                        com.tencent.msdk.dns.base.log.b.b("%s closed", datagramSocket);
                    }
                    statistics.endLookup();
                    return new LookupResult(statistics.ips, statistics);
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    if (datagramSocket != null) {
                    }
                    statistics.endLookup();
                    throw th3;
                }
            }
        } else {
            throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
        }
    }

    @Override // com.tencent.msdk.dns.core.f
    public f.b a(j<g> jVar) {
        return new a(jVar, this, null);
    }

    /* access modifiers changed from: private */
    public String a(String str, g gVar, int i) {
        String a2 = a.a(str, gVar.c);
        if (1 == this.a) {
            return h.a(a2, gVar.b, i);
        }
        return h.b(a2, gVar.b, i);
    }

    /* compiled from: UdpDns */
    private class a extends AbsRestDns.a {
        private DatagramChannel h = null;
        private final f.b.a i = new AbsRestDns.a.C0150a() {
            /* class com.tencent.msdk.dns.core.rest.c.b.a.AnonymousClass1 */

            @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a.C0150a, com.tencent.msdk.dns.core.f.b.a
            public boolean c() {
                return super.c();
            }

            @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a.C0150a, com.tencent.msdk.dns.core.f.b.a
            public boolean d() {
                return super.d();
            }
        };

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected int j() {
            return 0;
        }

        a(j<g> jVar, f fVar, AbsRestDns.a aVar) {
            super(jVar, fVar, aVar);
            if (3 != this.b) {
                Selector p = this.c.p();
                if (p != null) {
                    String b = this.c.b();
                    try {
                        this.h = DatagramChannel.open();
                        try {
                            com.tencent.msdk.dns.base.log.b.b("UdpDns(%d) lookup for %s %s opened", Integer.valueOf(b.this.a), b, this.h);
                            try {
                                this.h.configureBlocking(false);
                                try {
                                    this.e = this.h.register(p, 5);
                                    this.e.attach(this.h);
                                    this.b = 2;
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
                            com.tencent.msdk.dns.base.log.b.b(e3, "UdpDns(%d) lookup for %s create datagram channel failed", Integer.valueOf(b.this.a), b);
                            d();
                        }
                    } catch (Exception e4) {
                        this.f.errorCode = 1003;
                        this.f.errorMsg = e4.getMessage();
                        throw e4;
                    }
                } else {
                    throw new IllegalArgumentException("selector".concat(" can not be null"));
                }
            }
        }

        @Override // com.tencent.msdk.dns.core.f.b
        public f.b.a h() {
            return this.i;
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected int k() {
            g gVar = (g) this.c.c();
            String b = this.c.b();
            InetSocketAddress a2 = c.a(gVar.b, b.this.a);
            if (a2 == null) {
                com.tencent.msdk.dns.base.log.b.b("UdpDns(%d) lookup for %s get target socket address failed", Integer.valueOf(b.this.a), b);
                this.f.errorCode = 1006;
                d();
                return 1;
            }
            String a3 = b.this.a(b, gVar, this.c.e());
            if (TextUtils.isEmpty(a3)) {
                this.f.errorCode = 1007;
                d();
                return 1;
            }
            try {
                this.h.send(ByteBuffer.wrap(a3.getBytes("UTF-8")), a2);
                this.e.interestOps(1);
                return 0;
            } catch (Exception e) {
                com.tencent.msdk.dns.base.log.b.b(e, "UdpDns(%d) lookup for %s send request failed", Integer.valueOf(b.this.a), b);
                d();
                this.f.errorCode = 31002;
                this.f.errorMsg = e.getMessage();
                return 1;
            }
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected com.tencent.msdk.dns.core.rest.share.a.a l() {
            g gVar = (g) this.c.c();
            String b = this.c.b();
            ByteBuffer allocate = ByteBuffer.allocate(2048);
            try {
                this.h.receive(allocate);
                allocate.flip();
                int limit = allocate.limit();
                byte[] bArr = new byte[limit];
                allocate.get(bArr, 0, limit);
                String b2 = a.b(new String(bArr, Charset.forName("UTF-8")), gVar.c);
                com.tencent.msdk.dns.base.log.b.b("UdpDns(%d) lookup for %s, len:%d, rsp:[%s]", Integer.valueOf(b.this.a), b, Integer.valueOf(limit), b2);
                if (TextUtils.isEmpty(b2)) {
                    this.f.errorCode = 41001;
                }
                return com.tencent.msdk.dns.core.rest.share.a.b.a(gVar.b, b.this.a, b2);
            } catch (Exception e) {
                com.tencent.msdk.dns.base.log.b.b(e, "UdpDns(%d) lookup for %s receive response failed", Integer.valueOf(b.this.a), b);
                this.f.errorCode = 31002;
                this.f.errorMsg = e.getMessage();
                return com.tencent.msdk.dns.core.rest.share.a.a.a;
            }
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected void m() {
            com.tencent.msdk.dns.base.e.a.a((Closeable) this.h);
        }

        @Override // com.tencent.msdk.dns.core.rest.share.AbsRestDns.a
        protected AbsRestDns.a n() {
            return new a(this.c, this.d, this);
        }
    }
}
