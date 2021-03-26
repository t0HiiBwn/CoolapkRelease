package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dw;
import com.xiaomi.push.fj;
import com.xiaomi.push.fm;
import java.util.Map;

class bv extends fj {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bv(XMPushService xMPushService, Map map, int i, String str, fm fmVar) {
        super(map, i, str, fmVar);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fj
    /* renamed from: a */
    public byte[] mo337a() {
        try {
            dw.b bVar = new dw.b();
            bVar.a(bh.a().m642a());
            return bVar.mo211a();
        } catch (Exception e) {
            b.m41a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
