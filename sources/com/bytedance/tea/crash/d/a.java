package com.bytedance.tea.crash.d;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.e;
import com.bytedance.tea.crash.f;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.m;
import com.bytedance.tea.crash.h;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: CrashCatchDispatcher */
public class a implements Thread.UncaughtExceptionHandler {
    private static a a;
    private Thread.UncaughtExceptionHandler b;
    private HashSet<Thread.UncaughtExceptionHandler> c = new HashSet<>();
    private b d;
    private long e = -1;

    private a() {
        c();
        b();
    }

    private void b() {
        try {
            new Thread() {
                /* class com.bytedance.tea.crash.d.a.AnonymousClass1 */

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    try {
                        while (true) {
                            SystemClock.sleep(Math.abs(new Random().nextLong()) % 5000);
                            a.this.c();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }.start();
        } catch (Throwable unused) {
        }
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    /* access modifiers changed from: private */
    public void c() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.b == null) {
                this.b = defaultUncaughtExceptionHandler;
            } else {
                this.c.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        b bVar;
        if (SystemClock.uptimeMillis() - this.e >= 20000) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.e = SystemClock.uptimeMillis();
                boolean a2 = a(thread, th);
                if (!a2) {
                    c(thread, th);
                    return;
                }
                c cVar = c.JAVA;
                b(thread, th);
                if (a2 && (bVar = this.d) != null && bVar.a(th)) {
                    this.d.a(currentTimeMillis, thread, th);
                    Log.i("crash_dispatcher", "end dispose " + th);
                }
                c(thread, th);
            } catch (Throwable th2) {
                c(thread, th);
                throw th2;
            }
        }
    }

    private boolean a(Thread thread, Throwable th) {
        f d2 = h.b().d();
        if (d2 == null) {
            return true;
        }
        try {
            if (d2.a(th, thread)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void b(Thread thread, Throwable th) {
        List<e> b2 = h.b().b();
        c cVar = c.JAVA;
        for (e eVar : b2) {
            try {
                eVar.a(cVar, m.a(th), thread);
            } catch (Throwable th2) {
                j.b(th2);
            }
        }
    }

    private void c(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it2 = this.c.iterator();
            while (it2.hasNext()) {
                try {
                    it2.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.b.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }
}
