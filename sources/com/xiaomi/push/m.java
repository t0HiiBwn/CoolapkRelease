package com.xiaomi.push;

import android.content.Context;

public class m {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
