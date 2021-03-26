package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

public class ao {
    private static volatile ao a;
    private Context b;

    private ao(Context context) {
        this.b = context;
    }

    public static ao a(Context context) {
        if (a == null) {
            synchronized (ao.class) {
                if (a == null) {
                    a = new ao(context);
                }
            }
        }
        return a;
    }

    public synchronized void a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.b.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    public synchronized void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.b.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public synchronized long b(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.b.getSharedPreferences(str, 4).getLong(str2, j);
    }

    public synchronized String b(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.b.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
