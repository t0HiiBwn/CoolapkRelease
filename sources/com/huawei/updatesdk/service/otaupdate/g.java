package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

public final class g {
    private static String a;
    private static Resources b;

    public static int a(Context context, String str) {
        return a(context, str, "id");
    }

    private static int a(Context context, String str, String str2) {
        if (b == null) {
            b = context.getResources();
        }
        return b.getIdentifier(str, str2, a(context));
    }

    private static String a(Context context) {
        if (a == null) {
            a = context.getPackageName();
        }
        return a;
    }

    public static int b(Context context, String str) {
        return a(context, str, "string");
    }

    public static String c(Context context, String str) {
        try {
            return context.getResources().getString(a(context, str, "string"));
        } catch (Resources.NotFoundException unused) {
            Log.e("UpdateSDK", "recource get error name: " + str);
            return "";
        }
    }

    public static int d(Context context, String str) {
        return a(context, str, "layout");
    }

    public static int e(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static int f(Context context, String str) {
        return a(context, str, "color");
    }
}
