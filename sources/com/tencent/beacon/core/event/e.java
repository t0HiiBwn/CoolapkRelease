package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.g;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.core.strategy.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: EventTunnel */
public final class e {
    public boolean a;
    private Context b;
    private String c;
    private Map<String, String> d = null;
    private final Object e = new Object();
    private h f = null;
    private h g = null;
    private String h = "10000";

    public e(Context context, String str) {
        this.b = context;
        this.c = str;
        this.f = new a(context, this);
        this.g = new i(context, this);
    }

    public final h a() {
        return this.f;
    }

    public final h b() {
        return this.g;
    }

    public final boolean b(boolean z) {
        if (!TunnelModule.isModuleAble()) {
            b.d("[module] this module not ready!", new Object[0]);
            return false;
        }
        synchronized (this.e) {
            if (i() > 0) {
                try {
                    if (i.a(this.b) != null) {
                        b bVar = new b(this.b, this.c);
                        bVar.a(z);
                        i.a(this.b).a(bVar);
                    }
                    return true;
                } catch (Throwable th) {
                    b.d("[event] up common error: %s", th.toString());
                    b.a(th);
                }
            }
            return false;
        }
    }

    public final void c() {
        synchronized (this.e) {
            int i = i();
            int i2 = 20;
            while (i > 0 && i2 > 0) {
                i2--;
                b.a("[db] -> upload db events, [%d] need to upload.", Integer.valueOf(i));
                if (b(false)) {
                    i = i();
                } else {
                    return;
                }
            }
        }
    }

    private int i() {
        if (this.a) {
            return l.a(this.b, this.c);
        }
        return -1;
    }

    public final void d() {
        try {
            a strategy = StrategyQueryModule.getInstance(this.b).getStrategy();
            if (strategy != null) {
                a.C0141a b2 = strategy.b(1);
                if (!(b2 == null || d.a() == null)) {
                    Set<String> d2 = b2.d();
                    if (d2 != null && d2.size() > 0) {
                        d.a().a(d2);
                    }
                    Set<String> f2 = b2.f();
                    if (f2 != null && f2.size() > 0) {
                        d.a().b(f2);
                    }
                }
                if (!this.a || b2 == null) {
                    b.d("[event] module is disable", new Object[0]);
                    return;
                }
                if (i() > 0) {
                    b.e("[event] asyn up module %d", 1);
                    com.tencent.beacon.core.a.b.a().a(new Runnable() {
                        /* class com.tencent.beacon.core.event.e.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public final void run() {
                            e.this.b(true);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            b.a(th);
            b.d("[event] common query end error %s", th.toString());
        }
    }

    public final void e() {
        this.f.c();
        this.g.c();
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String f() {
        return this.c;
    }

    public final Map<String, String> g() {
        return this.d;
    }

    public final void a(Map<String, String> map) {
        if (map != null && map.size() <= 20) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            this.d.putAll(map);
        }
    }

    public final void b(String str) {
        this.h = str;
    }

    public final String h() {
        return this.h;
    }

    public final void a(boolean z) {
        h hVar = this.f;
        if (hVar != null) {
            hVar.a(z);
        }
        h hVar2 = this.g;
        if (hVar2 != null) {
            hVar2.a(z);
        }
        this.a = z;
    }

    public final boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        h hVar;
        String str2 = null;
        if (!g.a(str)) {
            String trim = str.replace('|', '_').trim();
            if (trim.length() == 0) {
                b.d("[core] eventName is invalid!! eventName length == 0!", new Object[0]);
            } else if (!com.tencent.beacon.core.d.a.b(trim)) {
                b.d("[core] eventName should be ASCII code in 32-126! eventName:" + str, new Object[0]);
            } else if (trim.length() > 128) {
                b.c("[core] eventName length should be less than 128! eventName:" + str, new Object[0]);
                str2 = trim.substring(0, 128);
            } else {
                str2 = trim;
            }
        }
        if (str2 == null) {
            return false;
        }
        b.a("[event] UserEvent: %s, %b, %d, %d, %b, %b", str2, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z2), Boolean.valueOf(z3));
        if (d.a().a(str2)) {
            b.d("[event] '%s' is not allowed in strategy (false).", str2);
            return false;
        } else if (!z || d.a().b(str2)) {
            if (z2) {
                hVar = this.g;
            } else {
                hVar = this.f;
            }
            if (hVar == null) {
                return false;
            }
            RDBean a2 = k.a(this.b, this.c, str2, z, j, j2, map, z2, z3);
            if (a2 != null) {
                return hVar.a(a2);
            }
            b.d("[event] RDBean is null, return false!", new Object[0]);
            return false;
        } else {
            b.d("[event] '%s' is sampled by svr rate (false).", str2);
            return false;
        }
    }
}
