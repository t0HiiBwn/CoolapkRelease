package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dd;
import com.xiaomi.push.en;
import com.xiaomi.push.eq;
import java.util.Map;

class at extends en {
    final /* synthetic */ XMPushService d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    at(XMPushService xMPushService, Map map, int i, String str, eq eqVar) {
        super(map, i, str, eqVar);
        this.d = xMPushService;
    }

    @Override // com.xiaomi.push.en
    public byte[] c() {
        try {
            dd.b bVar = new dd.b();
            bVar.a(ag.a().c());
            return bVar.c();
        } catch (Exception e) {
            c.a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
