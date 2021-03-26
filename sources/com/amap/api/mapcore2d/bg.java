package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferenceManager */
public class bg {
    private static bg a;
    private static SharedPreferences b;

    private bg() {
    }

    public static void a(Context context) {
        a = new bg();
        b = context.getSharedPreferences("amap_preferences", 0);
    }

    public static bg a() {
        if (a == null) {
            a = new bg();
        }
        return a;
    }

    public static String a(String str) {
        return b.getString(str, null);
    }

    public static String a(String str, String str2) {
        return b.getString(str, str2);
    }

    public static boolean a(String str, boolean z) {
        return b.getBoolean(str, z);
    }

    public static void b(String str, boolean z) {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).commit();
        }
    }

    public int a(String str, int i) {
        return b.getInt(str, i);
    }

    public void b(String str, int i) {
        SharedPreferences.Editor edit = b.edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor edit = b.edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
