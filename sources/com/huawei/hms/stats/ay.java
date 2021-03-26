package com.huawei.hms.stats;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

public class ay {
    public static boolean a(Context context) {
        return System.currentTimeMillis() - ap.b(context, "Privacy_MY", "flashKeyTime", -1) > 43200000;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return false;
            }
            af.c("hmsSdk", "not have read phone permission!");
            return true;
        } else if (context.checkSelfPermission(str) == 0) {
            return false;
        } else {
            af.c("hmsSdk", "not have read phone permission!");
            return true;
        }
    }

    public static boolean a(Context context, String str, int i) {
        String str2 = ap.a(context, str) + ".xml";
        long length = new File(context.getFilesDir(), "../shared_prefs/" + str2).length();
        if (length <= ((long) i)) {
            return false;
        }
        af.b("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i)));
        return true;
    }

    public static boolean a(String str, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j - Long.parseLong(str) > j2;
        } catch (NumberFormatException unused) {
            af.c("TaskAssistant", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
