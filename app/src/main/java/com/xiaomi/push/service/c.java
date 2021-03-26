package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fb;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;

class c extends XMPushService.i {
    private XMPushService a = null;

    /* renamed from: a  reason: collision with other field name */
    private fb[] f1008a;

    public c(XMPushService xMPushService, fb[] fbVarArr) {
        super(4);
        this.a = xMPushService;
        this.f1008a = fbVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo648a() {
        try {
            fb[] fbVarArr = this.f1008a;
            if (fbVarArr != null) {
                this.a.a(fbVarArr);
            }
        } catch (ft e) {
            b.a(e);
            this.a.a(10, e);
        }
    }
}
