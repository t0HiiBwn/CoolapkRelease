package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ey;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.q;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;

public class bl extends XMPushService.i {
    private XMPushService a;
    private byte[] b;
    private String c;
    private String d;
    private String e;

    public bl(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.c = str;
        this.b = bArr;
        this.d = str2;
        this.e = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        q.b bVar;
        bi a2 = bj.a(this.a);
        if (a2 == null) {
            try {
                a2 = bj.a(this.a, this.c, this.d, this.e);
            } catch (IOException | JSONException e2) {
                c.a(e2);
            }
        }
        if (a2 == null) {
            c.d("no account for mipush");
            bm.a(this.a, 70000002, "no account.");
            return;
        }
        Collection<q.b> c2 = q.a().c("5");
        if (c2.isEmpty()) {
            bVar = a2.a(this.a);
            bu.a(this.a, bVar);
            q.a().a(bVar);
        } else {
            bVar = c2.iterator().next();
        }
        if (this.a.f()) {
            try {
                if (bVar.m == q.c.binded) {
                    bu.a(this.a, this.c, this.b);
                } else if (bVar.m == q.c.unbind) {
                    XMPushService xMPushService = this.a;
                    xMPushService.getClass();
                    xMPushService.a(new XMPushService.a(bVar));
                }
            } catch (ey e3) {
                c.a(e3);
                this.a.a(10, e3);
            }
        } else {
            this.a.a(true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "register app";
    }
}
