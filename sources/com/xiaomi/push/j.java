package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import com.xiaomi.a.a.a.c;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class j {
    private static volatile j a;
    private ScheduledThreadPoolExecutor b = new ScheduledThreadPoolExecutor(1);
    private SparseArray<ScheduledFuture> c = new SparseArray<>();
    private Object d = new Object();
    private SharedPreferences e;

    public static abstract class a implements Runnable {
        public abstract int a();
    }

    private static class b implements Runnable {
        a a;

        public b(a aVar) {
            this.a = aVar;
        }

        void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.a.run();
            b();
        }
    }

    private j(Context context) {
        this.e = context.getSharedPreferences("mipush_extra", 0);
    }

    public static j a(Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(context);
                }
            }
        }
        return a;
    }

    private static String b(int i) {
        return "last_job_time" + i;
    }

    private ScheduledFuture b(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.d) {
            scheduledFuture = this.c.get(aVar.a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.b.schedule(runnable, (long) i, TimeUnit.SECONDS);
    }

    public boolean a(int i) {
        synchronized (this.d) {
            ScheduledFuture scheduledFuture = this.c.get(i);
            if (scheduledFuture == null) {
                return false;
            }
            this.c.remove(i);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        if (aVar == null || b(aVar) != null) {
            return false;
        }
        String b2 = b(aVar.a());
        k kVar = new k(this, aVar, b2);
        long abs = Math.abs(System.currentTimeMillis() - this.e.getLong(b2, 0)) / 1000;
        if (abs < ((long) (i - i2))) {
            i2 = (int) (((long) i) - abs);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.b.scheduleAtFixedRate(kVar, (long) i2, (long) i, TimeUnit.SECONDS);
            synchronized (this.d) {
                this.c.put(aVar.a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e2) {
            c.a(e2);
            return true;
        }
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || b(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.b.schedule(new l(this, aVar), (long) i, TimeUnit.SECONDS);
        synchronized (this.d) {
            this.c.put(aVar.a(), schedule);
        }
        return true;
    }
}
