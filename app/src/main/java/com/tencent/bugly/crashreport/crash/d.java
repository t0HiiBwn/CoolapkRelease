package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class d {
    private static d a;
    private a b;
    private com.tencent.bugly.crashreport.common.info.a c;
    private b d;
    private Context e;

    static /* synthetic */ void a(d dVar) {
        x.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            dVar.c.getClass();
            z.a(cls, "sdkPackageName", "com.tencent.bugly", null);
            x.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            x.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    static /* synthetic */ void a(d dVar, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        int i2 = 5;
        if (i == 4) {
            str4 = "Unity";
        } else if (i == 5 || i == 6) {
            str4 = "Cocos";
        } else if (i != 8) {
            x.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
            return;
        } else {
            str4 = "H5";
        }
        x.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!dVar.b.b()) {
                x.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c2 = dVar.b.c();
            if (c2.e || !dVar.b.b()) {
                if (i == 5 || i == 6) {
                    if (!c2.j) {
                        x.e("[ExtraCrashManager] %s report is disabled.", str4);
                        x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                        return;
                    }
                } else if (i == 8 && !c2.k) {
                    x.e("[ExtraCrashManager] %s report is disabled.", str4);
                    x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
                if (i != 8) {
                    i2 = i;
                }
                CrashDetailBean crashDetailBean = new CrashDetailBean();
                crashDetailBean.C = b.g();
                crashDetailBean.D = b.e();
                crashDetailBean.E = b.i();
                crashDetailBean.F = dVar.c.k();
                crashDetailBean.G = dVar.c.j();
                crashDetailBean.H = dVar.c.l();
                crashDetailBean.w = z.a(dVar.e, c.e, (String) null);
                crashDetailBean.b = i2;
                crashDetailBean.e = dVar.c.h();
                crashDetailBean.f = dVar.c.k;
                crashDetailBean.g = dVar.c.q();
                crashDetailBean.m = dVar.c.g();
                crashDetailBean.n = str;
                crashDetailBean.o = str2;
                String str6 = "";
                if (str3 != null) {
                    String[] split = str3.split("\n");
                    if (split.length > 0) {
                        str6 = split[0];
                    }
                    str5 = str3;
                } else {
                    str5 = str6;
                }
                crashDetailBean.p = str6;
                crashDetailBean.q = str5;
                crashDetailBean.r = System.currentTimeMillis();
                crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
                crashDetailBean.z = z.a(c.f, false);
                crashDetailBean.A = dVar.c.d;
                crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
                crashDetailBean.I = dVar.c.s();
                crashDetailBean.h = dVar.c.p();
                crashDetailBean.M = dVar.c.a;
                crashDetailBean.N = dVar.c.a();
                if (!c.a().o()) {
                    dVar.d.d(crashDetailBean);
                }
                crashDetailBean.Q = dVar.c.z();
                crashDetailBean.R = dVar.c.A();
                crashDetailBean.S = dVar.c.t();
                crashDetailBean.T = dVar.c.y();
                crashDetailBean.y = y.a();
                if (crashDetailBean.O == null) {
                    crashDetailBean.O = new LinkedHashMap();
                }
                if (map != null) {
                    crashDetailBean.O.putAll(map);
                }
                String a2 = z.a();
                String str7 = dVar.c.d;
                String name = currentThread.getName();
                b.a(str4, a2, str7, name, str + "\n" + str2 + "\n" + str3, crashDetailBean);
                if (!dVar.d.a(crashDetailBean)) {
                    dVar.d.a(crashDetailBean, 3000L, false);
                }
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            x.e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
            String a3 = z.a();
            String str8 = dVar.c.d;
            String name2 = currentThread.getName();
            b.a(str4, a3, str8, name2, str + "\n" + str2 + "\n" + str3, null);
            x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            throw th;
        }
    }

    private d(Context context) {
        c a2 = c.a();
        if (a2 != null) {
            this.b = a.a();
            this.c = com.tencent.bugly.crashreport.common.info.a.a(context);
            this.d = a2.p;
            this.e = context;
            w.a().a(new Runnable() {
                /* class com.tencent.bugly.crashreport.crash.d.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    d.a(d.this);
                }
            });
        }
    }

    public static d a(Context context) {
        if (a == null) {
            a = new d(context);
        }
        return a;
    }

    public static void a(final Thread thread, final int i, final String str, final String str2, final String str3, final Map<String, String> map) {
        w.a().a(new Runnable() {
            /* class com.tencent.bugly.crashreport.crash.d.AnonymousClass2 */

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (d.a == null) {
                        x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        d.a(d.a, thread, i, str, str2, str3, map);
                    }
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                    x.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
