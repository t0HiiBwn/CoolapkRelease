package com.tencent.msdk.dns.core.rest.b;

import com.tencent.msdk.dns.core.rest.share.a;
import com.tencent.msdk.dns.core.rest.share.g;
import com.tencent.msdk.dns.core.rest.share.h;
import java.net.SocketAddress;

/* compiled from: DesHttpDns */
public final class b extends a {
    private com.tencent.msdk.dns.core.rest.share.b d;

    @Override // com.tencent.msdk.dns.core.rest.share.a
    public String c() {
        return "DesHttp";
    }

    public b(int i) {
        super(i);
        this.d = null;
        this.d = new c();
    }

    @Override // com.tencent.msdk.dns.core.rest.share.a
    public String b() {
        return "DesHttp(" + this.a + ")";
    }

    @Override // com.tencent.msdk.dns.core.rest.share.a
    public String a(String str, g gVar, int i) {
        String str2;
        String a = a.a(str, gVar.c);
        if (1 == this.a) {
            str2 = h.a(a, gVar.b, i);
        } else {
            str2 = h.b(a, gVar.b, i);
        }
        return this.d.b(gVar.b, str2);
    }

    @Override // com.tencent.msdk.dns.core.rest.share.a
    public String a(String str, String str2) {
        return a.b(str, str2);
    }

    @Override // com.tencent.msdk.dns.core.rest.share.a
    public SocketAddress a(String str, int i) {
        return this.d.a(str, i);
    }
}
