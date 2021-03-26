package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.gi;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.j;
import java.lang.ref.WeakReference;

public class ab extends j.a {
    private hi a;
    private WeakReference<XMPushService> b;
    private boolean c = false;

    public ab(hi hiVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.a = hiVar;
        this.b = weakReference;
        this.c = z;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.b;
        if (weakReference != null && this.a != null && (xMPushService = weakReference.get()) != null) {
            this.a.a(o.a());
            this.a.a(false);
            c.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.c());
            try {
                String l = this.a.l();
                xMPushService.a(l, ht.a(bu.a(l, this.a.e(), this.a, gi.Notification)), this.c);
            } catch (Exception e) {
                c.d("MoleInfo aw_ping : send help app ping error" + e.toString());
            }
        }
    }
}
