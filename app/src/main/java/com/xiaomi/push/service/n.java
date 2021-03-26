package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
import java.util.Collection;

public class n extends XMPushService.i {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private String f1028a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f1029a;
    private String b;
    private String c;

    public n(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f1028a = str;
        this.f1029a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo666a() {
        as.b bVar;
        k a2 = l.a((Context) this.a);
        if (a2 == null) {
            try {
                a2 = l.a(this.a, this.f1028a, this.b, this.c);
            } catch (Exception e) {
                b.d("fail to register push account. " + e);
            }
        }
        if (a2 == null) {
            b.d("no account for mipush");
            o.a(this.a, 70000002, "no account.");
            return;
        }
        Collection<as.b> a3 = as.a().m625a("5");
        if (a3.isEmpty()) {
            bVar = a2.a(this.a);
            x.a(this.a, bVar);
            as.a().a(bVar);
        } else {
            bVar = a3.iterator().next();
        }
        if (this.a.m588c()) {
            try {
                if (bVar.f966a == as.c.binded) {
                    x.a(this.a, this.f1028a, this.f1029a);
                } else if (bVar.f966a == as.c.unbind) {
                    XMPushService xMPushService = this.a;
                    xMPushService.getClass();
                    xMPushService.a(new XMPushService.a(bVar));
                }
            } catch (ft e2) {
                b.d("meet error, disconnect connection. " + e2);
                this.a.a(10, e2);
            }
        } else {
            this.a.a(true);
        }
    }
}
