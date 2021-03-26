package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.u;

class dx implements dw.a {
    protected Context a = null;
    private PendingIntent b = null;
    private volatile long c = 0;

    public dx(Context context) {
        this.a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            c.a(e);
        }
    }

    @Override // com.xiaomi.push.dw.a
    public void a() {
        if (this.b != null) {
            try {
                ((AlarmManager) this.a.getSystemService("alarm")).cancel(this.b);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.b = null;
                c.c("unregister timer");
                this.c = 0;
                throw th;
            }
            this.b = null;
            c.c("unregister timer");
            this.c = 0;
        }
        this.c = 0;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.a.getSystemService("alarm");
        this.b = PendingIntent.getBroadcast(this.a, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            ac.a(alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.b);
        } else if (Build.VERSION.SDK_INT >= 19) {
            a(alarmManager, j, this.b);
        } else {
            alarmManager.set(0, j, this.b);
        }
        c.c("register timer " + j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r7.c < java.lang.System.currentTimeMillis()) goto L_0x0033;
     */
    @Override // com.xiaomi.push.dw.a
    public void a(boolean z) {
        long c2 = c();
        if (z || this.c != 0) {
            if (z) {
                a();
            }
            if (z || this.c == 0) {
                c2 -= SystemClock.elapsedRealtime() % c2;
            } else {
                this.c += c2;
            }
            this.c = System.currentTimeMillis() + c2;
            Intent intent = new Intent(u.o);
            intent.setPackage(this.a.getPackageName());
            a(intent, this.c);
        }
    }

    @Override // com.xiaomi.push.dw.a
    public boolean b() {
        return this.c != 0;
    }

    long c() {
        return (long) es.c();
    }
}
