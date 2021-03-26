package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.es;
import com.xiaomi.push.service.aw;

class et implements es.a {
    private volatile long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f414a = null;

    /* renamed from: a  reason: collision with other field name */
    protected Context f415a = null;

    public et(Context context) {
        this.f415a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            b.a(e);
        }
    }

    @Override // com.xiaomi.push.es.a
    /* renamed from: a */
    long mo311a() {
        return (long) fo.b();
    }

    @Override // com.xiaomi.push.es.a
    /* renamed from: a  reason: collision with other method in class */
    public void mo311a() {
        if (this.f414a != null) {
            try {
                ((AlarmManager) this.f415a.getSystemService("alarm")).cancel(this.f414a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f414a = null;
                b.c("unregister timer");
                this.a = 0;
                throw th;
            }
            this.f414a = null;
            b.c("unregister timer");
            this.a = 0;
        }
        this.a = 0;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f415a.getSystemService("alarm");
        this.f414a = PendingIntent.getBroadcast(this.f415a, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            bd.a((Object) alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.f414a);
        } else if (Build.VERSION.SDK_INT >= 19) {
            a(alarmManager, j, this.f414a);
        } else {
            alarmManager.set(0, j, this.f414a);
        }
        b.c("register timer " + j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r7.a < java.lang.System.currentTimeMillis()) goto L_0x0033;
     */
    @Override // com.xiaomi.push.es.a
    public void a(boolean z) {
        long a2 = mo311a();
        if (z || this.a != 0) {
            if (z) {
                mo311a();
            }
            if (z || this.a == 0) {
                a2 -= SystemClock.elapsedRealtime() % a2;
            } else {
                this.a += a2;
            }
            this.a = System.currentTimeMillis() + a2;
            Intent intent = new Intent(aw.o);
            intent.setPackage(this.f415a.getPackageName());
            a(intent, this.a);
        }
    }

    @Override // com.xiaomi.push.es.a
    /* renamed from: a */
    public boolean mo311a() {
        return this.a != 0;
    }
}
