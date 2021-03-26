package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ef;
import com.xiaomi.push.ey;
import com.xiaomi.push.service.XMPushService;

class ba extends XMPushService.i {
    private XMPushService a = null;
    private ef[] b;

    public ba(XMPushService xMPushService, ef[] efVarArr) {
        super(4);
        this.a = xMPushService;
        this.b = efVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ef[] efVarArr = this.b;
            if (efVarArr != null) {
                this.a.a(efVarArr);
            }
        } catch (ey e) {
            c.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "batch send message.";
    }
}
