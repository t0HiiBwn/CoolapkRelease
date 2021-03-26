package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.anr.b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
public final class c {
    public static int a = 0;
    public static boolean b = false;
    public static int c = 2;
    public static boolean d = true;
    public static int e = 20480;
    public static int f = 20480;
    public static long g = 604800000;
    public static String h = null;
    public static boolean i = false;
    public static String j = null;
    public static int k = 5000;
    public static boolean l = true;
    public static boolean m;
    public static String n;
    public static String o;
    private static c r;
    public final b p;
    private final Context q;
    private final e s;
    private final NativeCrashHandler t;
    private a u;
    private w v;
    private final b w;
    private Boolean x;
    private int y = 31;
    private boolean z = false;

    private c(int i2, Context context, w wVar, boolean z2, BuglyStrategy.a aVar, o oVar, String str) {
        a = i2;
        Context a2 = z.a(context);
        this.q = a2;
        this.u = a.a();
        this.v = wVar;
        u a3 = u.a();
        p a4 = p.a();
        b bVar = new b(i2, a2, a3, a4, this.u, aVar, oVar);
        this.p = bVar;
        com.tencent.bugly.crashreport.common.info.a a5 = com.tencent.bugly.crashreport.common.info.a.a(a2);
        this.s = new e(a2, bVar, this.u, a5);
        NativeCrashHandler instance = NativeCrashHandler.getInstance(a2, a5, bVar, this.u, wVar, z2, str);
        this.t = instance;
        a5.E = instance;
        this.w = b.a(a2, this.u, a5, wVar, a4, bVar, aVar);
    }

    public static synchronized c a(int i2, Context context, boolean z2, BuglyStrategy.a aVar, o oVar, String str) {
        c cVar;
        synchronized (c.class) {
            if (r == null) {
                r = new c(1004, context, w.a(), z2, aVar, null, null);
            }
            cVar = r;
        }
        return cVar;
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = r;
        }
        return cVar;
    }

    public final void a(StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.c();
        w.a().a(new Thread() {
            /* class com.tencent.bugly.crashreport.crash.c.AnonymousClass2 */

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                ArrayList arrayList;
                if (z.a(c.this.q, "local_crash_lock", 10000)) {
                    List<CrashDetailBean> a2 = c.this.p.a();
                    if (a2 != null && a2.size() > 0) {
                        x.c("Size of crash list: %s", Integer.valueOf(a2.size()));
                        int size = a2.size();
                        if (((long) size) > 20) {
                            ArrayList arrayList2 = new ArrayList();
                            Collections.sort(a2);
                            for (int i = 0; ((long) i) < 20; i++) {
                                arrayList2.add(a2.get((size - 1) - i));
                            }
                            arrayList = arrayList2;
                        } else {
                            arrayList = a2;
                        }
                        c.this.p.a(arrayList, 0, false, false, false);
                    }
                    z.b(c.this.q, "local_crash_lock");
                }
            }
        }, 3000);
    }

    public final boolean b() {
        Boolean bool = this.x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().d;
        List<r> a2 = p.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a2 == null || a2.size() <= 0) {
            this.x = false;
            return false;
        }
        for (r rVar : a2) {
            if (str.equals(rVar.c)) {
                this.x = true;
                arrayList.add(rVar);
            }
        }
        if (arrayList.size() > 0) {
            p.a().a(arrayList);
        }
        return true;
    }

    public final synchronized void c() {
        this.s.a();
        this.t.setUserOpened(true);
        this.w.a(true);
    }

    public final synchronized void d() {
        this.s.b();
        this.t.setUserOpened(false);
        this.w.a(false);
    }

    public final void e() {
        this.s.a();
    }

    public final void f() {
        this.t.setUserOpened(false);
    }

    public final void g() {
        this.t.setUserOpened(true);
    }

    public final void h() {
        this.w.a(true);
    }

    public final void i() {
        this.w.a(false);
    }

    public final void j() {
        this.t.enableCatchAnrTrace();
    }

    public final synchronized void a(boolean z2, boolean z3, boolean z4) {
        this.t.testNativeCrash(z2, z3, z4);
    }

    public final synchronized void k() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                    z.b(5000);
                    i2 = i3;
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return;
                }
            }
        }
    }

    public final boolean l() {
        return this.w.a();
    }

    public final void a(final Thread thread, final Throwable th, boolean z2, String str, byte[] bArr, final boolean z3) {
        this.v.a(new Runnable(false, null, null) {
            /* class com.tencent.bugly.crashreport.crash.c.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.c("post a throwable %b", Boolean.valueOf(false));
                    c.this.s.a(thread, th, false, null, null);
                    if (z3) {
                        x.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(c.this.q).u();
                    }
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                    x.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.p.e(crashDetailBean);
    }

    public final void a(long j2) {
        w.a().a(new Thread() {
            /* class com.tencent.bugly.crashreport.crash.c.AnonymousClass2 */

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                ArrayList arrayList;
                if (z.a(c.this.q, "local_crash_lock", 10000)) {
                    List<CrashDetailBean> a2 = c.this.p.a();
                    if (a2 != null && a2.size() > 0) {
                        x.c("Size of crash list: %s", Integer.valueOf(a2.size()));
                        int size = a2.size();
                        if (((long) size) > 20) {
                            ArrayList arrayList2 = new ArrayList();
                            Collections.sort(a2);
                            for (int i = 0; ((long) i) < 20; i++) {
                                arrayList2.add(a2.get((size - 1) - i));
                            }
                            arrayList = arrayList2;
                        } else {
                            arrayList = a2;
                        }
                        c.this.p.a(arrayList, 0, false, false, false);
                    }
                    z.b(c.this.q, "local_crash_lock");
                }
            }
        }, j2);
    }

    public final void m() {
        this.t.checkUploadRecordCrash();
    }

    public final void n() {
        if (com.tencent.bugly.crashreport.common.info.a.b().d.equals(AppInfo.a(this.q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }

    public final void a(int i2) {
        this.y = i2;
    }

    public final void a(boolean z2) {
        this.z = z2;
    }

    public final boolean o() {
        return this.z;
    }

    public final boolean p() {
        return (this.y & 16) > 0;
    }

    public final boolean q() {
        return (this.y & 8) > 0;
    }

    public final boolean r() {
        return (this.y & 4) > 0;
    }

    public final boolean s() {
        return (this.y & 2) > 0;
    }

    public final boolean t() {
        return (this.y & 1) > 0;
    }
}
