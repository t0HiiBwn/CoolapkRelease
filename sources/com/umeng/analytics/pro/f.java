package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMDBManager */
class f {
    private static SQLiteOpenHelper b;
    private static Context d;
    private AtomicInteger a;
    private SQLiteDatabase c;

    private f() {
        this.a = new AtomicInteger();
    }

    /* compiled from: UMDBManager */
    private static class a {
        private static final f a = new f();

        private a() {
        }
    }

    public static f a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = e.a(applicationContext);
        }
        return a.a;
    }

    public synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.c = b.getWritableDatabase();
        }
        return this.c;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (Throwable unused) {
        }
    }
}
