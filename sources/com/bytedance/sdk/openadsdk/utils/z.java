package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

/* compiled from: Predicate */
public class z {
    public static void a(Object obj, String str) {
        if (obj == null) {
            b(str);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b(str2);
        }
    }

    public static void a(boolean z, String str) {
        if (!z) {
            b(str);
        }
    }

    public static void a(String str) {
        b(str);
    }

    public static void a(Context context, String str) {
        if (!(context instanceof Activity)) {
            b(str);
        }
    }

    private static void b(String str) {
        throw new IllegalArgumentException(str);
    }
}
