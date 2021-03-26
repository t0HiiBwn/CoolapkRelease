package com.xiaomi.push;

import android.content.Context;

public class iu {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
