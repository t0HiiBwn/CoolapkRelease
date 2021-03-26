package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.b.a;
import com.tencent.beacon.core.c.g;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.event.d;
import com.tencent.beacon.core.event.o;

/* compiled from: StrategyQueryTask */
public final class c implements Runnable {
    private static long b;
    public boolean a = false;
    private Context c = null;

    public c(Context context) {
        this.c = context;
    }

    private static synchronized long a() {
        long j;
        synchronized (c.class) {
            j = b;
        }
        return j;
    }

    public static synchronized void a(long j) {
        synchronized (c.class) {
            b = j;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a = true;
        b();
        this.a = false;
    }

    private static boolean a(Context context, String str) {
        boolean z = true;
        try {
            com.tencent.beacon.core.a.c a2 = com.tencent.beacon.core.a.c.a(context);
            int parseInt = Integer.parseInt(a2.a("querytimes", "0"));
            if (!h.a().equals(str)) {
                parseInt = 0;
            }
            if (parseInt <= a.a().f()) {
                a2.a().a("querytimes", (Object) String.valueOf(parseInt + 1)).b();
                return false;
            }
            try {
                b.e("[strategy] sdk init max times", new Object[0]);
                return true;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            z = false;
            b.c("[strategy] set init times failed! ", new Object[0]);
            return z;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0185, code lost:
        if (r9.a("today_success_strategy_query_times") >= r10.l()) goto L_0x016f;
     */
    private synchronized void b() {
        boolean z;
        e a2 = b.a(this.c);
        if (!(a2 == null || a2.b != 101 || a2.c == null)) {
            try {
                g strategyHandler = StrategyQueryModule.getInstance(this.c).getStrategyHandler();
                if (strategyHandler != null) {
                    strategyHandler.a(101, a2.c, false);
                    b.e("common strategy setted by local db", new Object[0]);
                }
            } catch (Throwable th) {
                b.a(th);
            }
        }
        StrategyQueryModule instance = StrategyQueryModule.getInstance(this.c);
        if (instance.getCurrentQueryStep() == 0) {
            b.e("[strategy] stepCheckApp", new Object[0]);
            instance.setCurrentQueryStep(1);
            boolean b2 = a.b(this.c);
            b.e("[strategy] isAppFirstRun : %b", Boolean.valueOf(b2));
            if (b2) {
                Context context = this.c;
                b.e("[db] clear all analytics: %d", Integer.valueOf(com.tencent.beacon.core.a.a.b.a(context, com.tencent.beacon.core.b.b.a(context).a(), (int[]) null)));
                synchronized (instance) {
                    instance.setAppFirstRun(true);
                }
                for (com.tencent.beacon.core.c cVar : o.b) {
                    cVar.onAppFirstRun();
                }
            } else {
                long a3 = a();
                if (a3 > 0) {
                    b.e("[strategy] sleep: %d", Long.valueOf(a3));
                    try {
                        Thread.sleep(a3);
                    } catch (InterruptedException e) {
                        b.a(e);
                    }
                }
            }
        }
        b.e("[strategy] stepStartQuery", new Object[0]);
        instance.setCurrentQueryStep(2);
        instance.setCommonQueryTime(instance.getCommonQueryTime() + 1);
        for (com.tencent.beacon.core.c cVar2 : o.b) {
            cVar2.onStrategyQueryStarted();
        }
        if (!a.a().g()) {
            com.tencent.beacon.core.c.h myUpload = StrategyQueryModule.getMyUpload();
            int i = 0;
            while (myUpload == null) {
                i++;
                if (i >= 5) {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                    b.a(e2);
                }
                myUpload = StrategyQueryModule.getMyUpload();
            }
            if (myUpload != null) {
                com.tencent.beacon.core.a.c a4 = com.tencent.beacon.core.a.c.a(this.c);
                String a5 = a4.a("initsdkdate", "");
                if (!h.a().equals(a5)) {
                    a4.a().a("initsdkdate", (Object) h.a()).b();
                }
                boolean a6 = a(this.c, a5);
                Context context2 = this.c;
                d a7 = d.a();
                if (a7.m()) {
                    com.tencent.beacon.core.a.c a8 = com.tencent.beacon.core.a.c.a(context2);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = ((currentTimeMillis / 60000) + 480) % 1440;
                    if (j < 0 || j > 30 || currentTimeMillis - a8.b("last_success_strategy_query_time") > 90000000) {
                        if (!h.a().equals(a5)) {
                            a8.a().a("today_success_strategy_query_times", (Object) 0).b();
                        }
                    }
                    z = true;
                    if (!a6 || z) {
                        b.c("[strategy] query times or query success times arrive max, return!", new Object[0]);
                        StrategyQueryModule.getInstance(this.c).setAtLeastAComQuerySuccess(true);
                    } else {
                        Context context3 = this.c;
                        myUpload.a(new com.tencent.beacon.core.c.c(context3, com.tencent.beacon.core.b.b.a(context3).a()));
                    }
                }
                z = false;
                if (!a6) {
                }
                b.c("[strategy] query times or query success times arrive max, return!", new Object[0]);
                StrategyQueryModule.getInstance(this.c).setAtLeastAComQuerySuccess(true);
            } else {
                b.h("[strategy] uphandler is null", new Object[0]);
            }
        }
        b.h("[strategy] common query end!", new Object[0]);
        instance.setCurrentQueryStep(3);
        for (com.tencent.beacon.core.c cVar3 : o.b) {
            cVar3.onStrategyQueryFinished();
        }
        a strategy = StrategyQueryModule.getInstance(this.c).getStrategy();
        if (strategy == null) {
            b.d("[strategy] currentStrategy is null.", new Object[0]);
            return;
        }
        long c2 = (long) (strategy.c() * 60000);
        if (c2 > 0) {
            com.tencent.beacon.core.a.b.a().a(this, c2);
            b.h("[strategy] next time: %d", Long.valueOf(c2));
            StrategyQueryModule.getInstance(this.c).setCurrentQueryStep(4);
            return;
        }
        b.h("[strategy] stop loop query", new Object[0]);
    }
}
