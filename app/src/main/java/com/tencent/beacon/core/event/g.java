package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.b.a;
import com.tencent.beacon.core.b.e;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.c.j;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.c;
import com.tencent.beacon.core.d.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Heartbeat */
public final class g {
    private RDBean a;
    private Context b;
    private final boolean c;
    private boolean d = false;
    private int e = 20000;
    private int f = 0;
    private Runnable g = new Runnable() {
        /* class com.tencent.beacon.core.event.g.AnonymousClass1 */

        @Override // java.lang.Runnable
        public final void run() {
            try {
                g.this.a();
            } catch (Throwable th) {
                b.a(th);
            }
        }
    };

    public g(Context context) {
        this.b = context;
        this.c = a.g(context);
        this.d = a.a;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x002e: INVOKE  (r2v3 int) = 
      (wrap: android.content.Context : 0x002c: IGET  (r2v2 android.content.Context) = (r3v0 'this' com.tencent.beacon.core.event.g A[IMMUTABLE_TYPE, THIS]) com.tencent.beacon.core.event.g.b android.content.Context)
     type: STATIC call: com.tencent.beacon.core.b.a.h(android.content.Context):int)] */
    private Map d() {
        HashMap hashMap = new HashMap(4);
        e.a(this.b);
        hashMap.put("A33", e.j(this.b));
        if (this.c) {
            hashMap.put("A66", "F");
        } else {
            hashMap.put("A66", "B");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a.h(this.b));
        hashMap.put("A68", sb.toString());
        hashMap.put("A85", this.d ? "Y" : "N");
        hashMap.put("A20", e.g(this.b));
        hashMap.put("A69", e.h(this.b));
        return hashMap;
    }

    protected final void a() {
        if (c.b(this.b)) {
            i a2 = i.a(this.b);
            if (a2 != null) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(this.a);
                Iterator<j> it2 = i.a(this.b).c().iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
                Context context = this.b;
                a2.a(new j(context, com.tencent.beacon.core.b.b.a(context).a(), arrayList));
            }
            a(e() + 1);
            if (e() % 10 == 0) {
                com.tencent.beacon.core.a.b.a().a(108, this.g, 600000, (long) this.e);
                a(0);
            }
            if (this.d) {
                com.tencent.beacon.core.a.c.a(this.b).a().a("active_user_date", (Object) h.a()).b();
            }
        }
    }

    public final void b() {
        String a2 = h.a();
        com.tencent.beacon.core.a.c a3 = com.tencent.beacon.core.a.c.a(this.b);
        String a4 = a3.a("HEART_DENGTA", "");
        String a5 = a3.a("active_user_date", "");
        if (a2.equals(a4) || a5.equals(a2)) {
            b.c("[event] heartbeat had upload!", new Object[0]);
            return;
        }
        d a6 = d.a();
        if (a6.a("rqd_heartbeat")) {
            b.c("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
        } else if (!a6.b("rqd_heartbeat")) {
            b.c("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
        } else {
            this.a = k.a(this.b, null, "rqd_heartbeat", true, 0, 0, d(), true, false);
            com.tencent.beacon.core.a.b.a().a(108, this.g, 0, (long) this.e);
        }
    }

    public final void c() {
        com.tencent.beacon.core.a.c a2 = com.tencent.beacon.core.a.c.a(this.b);
        if (!h.a().equals(a2.a("active_user_date", ""))) {
            b.b("[event] recover a heart beat for active user.", new Object[0]);
            if (o.a("rqd_heartbeat", true, 0, 0, d(), true)) {
                a2.a().a("active_user_date", (Object) h.a()).b();
                return;
            }
            return;
        }
        b.c("[event] active user event had upload.", new Object[0]);
    }

    public static void a(Context context) {
        com.tencent.beacon.core.a.b.a().a(108, true);
        com.tencent.beacon.core.a.c.a(context).a().a("HEART_DENGTA", (Object) h.a()).b();
        b.a("[event] heartbeat uploaded success!", new Object[0]);
    }

    private synchronized int e() {
        return this.f;
    }

    private synchronized void a(int i) {
        this.f = i;
    }
}
