package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.aa;
import com.xiaomi.push.g;
import com.xiaomi.push.iz;
import com.xiaomi.push.j;
import java.util.concurrent.ConcurrentHashMap;

public final class ai implements g {
    private static volatile ai f;
    Context a;
    private SharedPreferences b;
    private long c;
    private volatile boolean d = false;
    private ConcurrentHashMap<String, a> e = new ConcurrentHashMap<>();

    public static abstract class a implements Runnable {
        String a;
        long b;

        a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        abstract void a(ai aiVar);

        @Override // java.lang.Runnable
        public void run() {
            if (ai.f != null) {
                Context context = ai.f.a;
                if (aa.d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = ai.f.b;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.a, 0) > this.b || g.a(context)) {
                        SharedPreferences.Editor edit = ai.f.b.edit();
                        iz.a(edit.putLong(":ts-" + this.a, System.currentTimeMillis()));
                        a(ai.f);
                    }
                }
            }
        }
    }

    private ai(Context context) {
        this.a = context.getApplicationContext();
        this.b = context.getSharedPreferences("sync", 0);
    }

    public static ai a(Context context) {
        if (f == null) {
            synchronized (ai.class) {
                if (f == null) {
                    f = new ai(context);
                }
            }
        }
        return f;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.b;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.g
    public void a() {
        if (!this.d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.c >= 3600000) {
                this.c = currentTimeMillis;
                this.d = true;
                j.a(this.a).a(new aj(this), (int) (Math.random() * 10.0d));
            }
        }
    }

    public void a(a aVar) {
        if (this.e.putIfAbsent(aVar.a, aVar) == null) {
            j.a(this.a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f.b.edit();
        iz.a(edit.putString(str + ":" + str2, str3));
    }
}
