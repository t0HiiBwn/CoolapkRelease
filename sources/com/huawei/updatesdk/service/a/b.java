package com.huawei.updatesdk.service.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.updatesdk.a.a.b.a.a.a;

public class b {
    private SharedPreferences a;

    private b(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public static b a(String str, Context context) {
        SharedPreferences sharedPreferences;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                context = context.createDeviceProtectedStorageContext();
            }
            sharedPreferences = context.getSharedPreferences(str, 0);
        } catch (Exception unused) {
            a.d("SharedPreferencesWrapper", "getSharedPreference error");
            sharedPreferences = null;
        }
        return new b(sharedPreferences);
    }

    public void a(String str) {
        try {
            SharedPreferences.Editor edit = this.a.edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception unused) {
            a.d("SharedPreferencesWrapper", "remove error!!key:" + str);
        }
    }

    public void a(String str, long j) {
        try {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putLong(str, j);
            edit.commit();
        } catch (Exception e) {
            a.a("SharedPreferencesWrapper", "putLong error!!key:" + str, e);
        }
    }

    public void a(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception e) {
            a.a("SharedPreferencesWrapper", "putString error!!key:" + str, e);
        }
    }

    public long b(String str, long j) {
        try {
            return this.a.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    public String b(String str, String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
