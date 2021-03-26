package com.xiaomi.push.service;

import com.xiaomi.push.ai;
import com.xiaomi.push.hc;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import java.lang.ref.WeakReference;

public class b extends ai.a {
    private ib a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f980a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f981a = false;

    public b(ib ibVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.a = ibVar;
        this.f980a = weakReference;
        this.f981a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f980a;
        if (weakReference != null && this.a != null && (xMPushService = weakReference.get()) != null) {
            this.a.a(aq.a());
            this.a.a(false);
            com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.m480a());
            try {
                String c = this.a.c();
                xMPushService.a(c, im.a(x.a(c, this.a.b(), this.a, hc.Notification)), this.f981a);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
            }
        }
    }
}
