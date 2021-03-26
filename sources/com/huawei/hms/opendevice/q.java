package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Objects;

/* compiled from: PushPreferences */
public class q {
    protected SharedPreferences a;

    public q(Context context, String str) {
        Objects.requireNonNull(context, "context is null!");
        if (Build.VERSION.SDK_INT >= 24) {
            Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
            if (!sharedPreferences.getBoolean(str, false)) {
                if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                }
            }
            context = createDeviceProtectedStorageContext;
        }
        this.a = context.getSharedPreferences(str, 0);
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null && sharedPreferences.getBoolean(str, false);
    }

    public String b(String str) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    public long c(String str) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0);
        }
        return 0;
    }

    public boolean a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public void a(String str, Long l) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, l.longValue()).commit();
        }
    }

    public void a(String str, boolean z) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putBoolean(str, z).commit();
        }
    }

    public boolean d(String str) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public boolean e(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (edit = this.a.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }
}
