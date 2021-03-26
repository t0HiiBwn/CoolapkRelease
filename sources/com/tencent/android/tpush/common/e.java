package com.tencent.android.tpush.common;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: ProGuard */
public class e {
    public static boolean a() {
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            return "xiaomi".equals(str.trim().toLowerCase());
        }
        return false;
    }
}
