package com.kepler.sdk;

import android.content.Context;

public class ae {
    public static void a(Context context, String str, int i) {
        try {
            context.getSharedPreferences("kepler_public", 0).edit().putInt(str, i).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int b(Context context, String str, int i) {
        try {
            return context.getSharedPreferences("kepler_public", 0).getInt(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static void a(Context context, String str, long j) {
        try {
            context.getSharedPreferences("kepler_public", 0).edit().putLong(str, j).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long b(Context context, String str, long j) {
        try {
            return context.getSharedPreferences("kepler_public", 0).getLong(str, j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kepler_public", 0).edit().putString(str, str2).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kepler_public", 0).getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
