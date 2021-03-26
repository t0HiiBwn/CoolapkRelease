package com.kepler.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

public class aj {
    private static Context a;
    private static String b;
    private static SharedPreferences c;

    private aj(Context context) {
        if (context != null) {
            c = context.getSharedPreferences("deviceid_prefs", 0);
            a = context;
            return;
        }
        throw new IllegalArgumentException("context  is required");
    }

    private static void d() {
        try {
            b = Settings.Secure.getString(a.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        String str = b;
        if (str == null || str.equals("9774d56d682e549c") || b.length() < 15) {
            b = new BigInteger(64, new SecureRandom()).toString(16);
        }
    }

    private static void e() {
        SharedPreferences.Editor edit = c.edit();
        edit.putString("kepler_deviceid", b);
        edit.commit();
    }

    public static void a(String str) {
        SharedPreferences.Editor edit = c.edit();
        edit.putInt(str, new Date().getDate());
        edit.commit();
    }

    public static boolean a() {
        return !c.getBoolean("kepler_start", false);
    }

    public static void b() {
        SharedPreferences.Editor edit = c.edit();
        edit.putBoolean("kepler_start", true);
        edit.commit();
    }

    public static void a(Context context) {
        new aj(context);
        String string = c.getString("kepler_deviceid", null);
        b = string;
        if (string == null) {
            d();
            e();
        }
    }

    public static String c() {
        return b;
    }
}
