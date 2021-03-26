package com.tencent.tpns.baseapi.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import com.tencent.tpns.baseapi.base.util.Logger;

/* compiled from: ProGuard */
public class TPushAlarmManager {
    private static TPushAlarmManager a = new TPushAlarmManager();
    private static AlarmManager b = null;

    private TPushAlarmManager() {
    }

    public static TPushAlarmManager getAlarmManager(Context context) {
        if (b == null) {
            a(context);
        }
        return a;
    }

    public void setRepeating(long j, long j2, PendingIntent pendingIntent) {
        AlarmManager alarmManager = b;
        if (alarmManager != null) {
            alarmManager.setRepeating(2, j, j2, pendingIntent);
        }
    }

    public void set(int i, long j, PendingIntent pendingIntent, boolean z) {
        if (Build.VERSION.SDK_INT >= 23 && !z) {
            try {
                Logger.d("TPushAlarmManager", "Alarm setExactAndAllowWhileIdle  delay: " + j);
                b.setExactAndAllowWhileIdle(i, j, pendingIntent);
            } catch (Throwable th) {
                Logger.e("TPushAlarmManager", "Alarm scheule using setExactAndAllowWhileIdle, error: " + j, th);
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            try {
                Logger.d("TPushAlarmManager", "Alarm scheule using setExact, delay: " + j);
                b.setExact(i, j, pendingIntent);
            } catch (Throwable th2) {
                Logger.e("TPushAlarmManager", "Alarm scheule using setExact, error: " + j, th2);
            }
        } else {
            try {
                Logger.d("TPushAlarmManager", "Alarm scheule using set, delay: " + j);
                b.set(i, j, pendingIntent);
            } catch (Throwable th3) {
                Logger.e("TPushAlarmManager", "Alarm scheule using set, error: " + j, th3);
            }
        }
    }

    public void cancal(PendingIntent pendingIntent) {
        AlarmManager alarmManager = b;
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    private static synchronized void a(Context context) {
        synchronized (TPushAlarmManager.class) {
            if (b == null && context != null) {
                b = (AlarmManager) context.getSystemService("alarm");
            }
        }
    }
}
