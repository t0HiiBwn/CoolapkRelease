package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fb;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;

class bd extends XMPushService.i {
    private fb a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f985a = null;

    public bd(XMPushService xMPushService, fb fbVar) {
        super(4);
        this.f985a = xMPushService;
        this.a = fbVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo638a() {
        try {
            fb fbVar = this.a;
            if (fbVar != null) {
                this.f985a.a(fbVar);
            }
        } catch (ft e) {
            b.a(e);
            this.f985a.a(10, e);
        }
    }
}
