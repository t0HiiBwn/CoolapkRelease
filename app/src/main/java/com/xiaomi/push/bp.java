package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

public class bp {
    private static volatile bp a;

    /* renamed from: a  reason: collision with other field name */
    private Context f231a;

    private bp(Context context) {
        this.f231a = context;
    }

    public static bp a(Context context) {
        if (a == null) {
            synchronized (bp.class) {
                if (a == null) {
                    a = new bp(context);
                }
            }
        }
        return a;
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f231a.getSharedPreferences(str, 4).getLong(str2, j);
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f231a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m146a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f231a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m147a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f231a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
