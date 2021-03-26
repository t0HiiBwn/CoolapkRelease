package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ef;
import com.xiaomi.push.ey;
import com.xiaomi.push.service.XMPushService;

class ac extends XMPushService.i {
    private XMPushService a = null;
    private ef b;

    public ac(XMPushService xMPushService, ef efVar) {
        super(4);
        this.a = xMPushService;
        this.b = efVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ef efVar = this.b;
            if (efVar != null) {
                this.a.a(efVar);
            }
        } catch (ey e) {
            c.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send a message.";
    }
}
