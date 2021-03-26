package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ai {
    private static volatile ai a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f186a;

    /* renamed from: a  reason: collision with other field name */
    private Object f187a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private Map<String, ScheduledFuture> f188a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f189a = new ScheduledThreadPoolExecutor(1);

    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo141a();
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

    private ai(Context context) {
        this.f186a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (a == null) {
            synchronized (ai.class) {
                if (a == null) {
                    a = new ai(context);
                }
            }
        }
        return a;
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f187a) {
            scheduledFuture = this.f188a.get(aVar.mo141a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f189a.schedule(runnable, (long) i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m102a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.mo141a());
        aj ajVar = new aj(this, aVar, z, a2);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f186a.getLong(a2, 0)) / 1000;
            if (abs < ((long) (i - i2))) {
                i2 = (int) (((long) i) - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f189a.scheduleAtFixedRate(ajVar, (long) i2, (long) i, TimeUnit.SECONDS);
            synchronized (this.f187a) {
                this.f188a.put(aVar.mo141a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m103a(String str) {
        synchronized (this.f187a) {
            ScheduledFuture scheduledFuture = this.f188a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f188a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f189a.schedule(new ak(this, aVar), (long) i, TimeUnit.SECONDS);
        synchronized (this.f187a) {
            this.f188a.put(aVar.mo141a(), schedule);
        }
        return true;
    }
}
