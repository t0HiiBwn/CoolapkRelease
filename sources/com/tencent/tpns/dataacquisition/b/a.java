package com.tencent.tpns.dataacquisition.b;

import android.content.Context;
import android.util.Log;

public class a {
    private static boolean a = true;

    public static void a(Object obj) {
        if (a) {
            Log.w("TPush-DataAcq", "" + obj);
        }
    }

    public static void a(String str, Throwable th) {
        Log.e("TPush-DataAcq", "" + str, th);
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            a("checkPermission error", th);
            return false;
        }
    }

    public static void b(Object obj) {
        Log.e("TPush-DataAcq", "" + obj);
    }
}
