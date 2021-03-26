package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.af;
import com.xiaomi.push.ai;
import com.xiaomi.push.bc;
import com.xiaomi.push.r;
import java.util.concurrent.ConcurrentHashMap;

public final class bj implements ah {
    private static volatile bj a;

    /* renamed from: a  reason: collision with other field name */
    private long f997a;

    /* renamed from: a  reason: collision with other field name */
    Context f998a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f999a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f1000a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f1001a = false;

    public static abstract class a implements Runnable {
        long a;

        /* renamed from: a  reason: collision with other field name */
        String f1002a;

        a(String str, long j) {
            this.f1002a = str;
            this.a = j;
        }

        abstract void a(bj bjVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bj.a != null) {
                Context context = bj.a.f998a;
                if (bc.c(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = bj.a.f999a;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f1002a, 0) > this.a || af.a(context)) {
                        SharedPreferences.Editor edit = bj.a.f999a.edit();
                        r.a(edit.putLong(":ts-" + this.f1002a, System.currentTimeMillis()));
                        a(bj.a);
                    }
                }
            }
        }
    }

    private bj(Context context) {
        this.f998a = context.getApplicationContext();
        this.f999a = context.getSharedPreferences("sync", 0);
    }

    public static bj a(Context context) {
        if (a == null) {
            synchronized (bj.class) {
                if (a == null) {
                    a = new bj(context);
                }
            }
        }
        return a;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f999a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ah
    public void a() {
        if (!this.f1001a) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f997a >= 3600000) {
                this.f997a = currentTimeMillis;
                this.f1001a = true;
                ai.a(this.f998a).a(new bk(this), (int) (Math.random() * 10.0d));
            }
        }
    }

    public void a(a aVar) {
        if (this.f1000a.putIfAbsent(aVar.f1002a, aVar) == null) {
            ai.a(this.f998a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = a.f999a.edit();
        r.a(edit.putString(str + ":" + str2, str3));
    }
}
