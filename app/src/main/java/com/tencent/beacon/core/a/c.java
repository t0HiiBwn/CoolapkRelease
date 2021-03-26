package com.tencent.beacon.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.beacon.core.d.b;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: BeaconSharedPrefs */
public final class c {
    private static c a;
    private SharedPreferences b;
    private SharedPreferences.Editor c;
    private Lock d = new ReentrantLock();
    private Runnable e = new Runnable() {
        /* class com.tencent.beacon.core.a.c.AnonymousClass1 */

        @Override // java.lang.Runnable
        public final void run() {
            c.this.c();
        }
    };

    private c(Context context) {
        if (context != null) {
            this.b = context.getSharedPreferences("DENGTA_META", 0);
        }
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c(context);
            }
            cVar = a;
        }
        return cVar;
    }

    public final synchronized c a() {
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null && this.c == null) {
            this.c = sharedPreferences.edit();
        }
        return this;
    }

    public final synchronized c a(String str, Object obj) {
        if (this.b != null) {
            SharedPreferences.Editor editor = this.c;
            if (editor != null) {
                if (obj instanceof String) {
                    editor.putString(str, (String) obj);
                } else if (obj instanceof Boolean) {
                    editor.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    editor.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    editor.putLong(str, ((Long) obj).longValue());
                }
                return this;
            }
        }
        b.d("[sp] create failed or edit() has not called.", new Object[0]);
        return this;
    }

    public final synchronized String a(String str, String str2) {
        return this.b.getString(str, str2);
    }

    public final synchronized int a(String str) {
        return this.b.getInt(str, 0);
    }

    public final synchronized long b(String str) {
        return this.b.getLong(str, 0);
    }

    public final void b() {
        if (this.b != null && this.c != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b.a().a(this.e);
            } else {
                c();
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.d.tryLock()) {
            this.c.commit();
            this.d.unlock();
        }
    }
}
