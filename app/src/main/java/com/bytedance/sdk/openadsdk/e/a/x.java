package com.bytedance.sdk.openadsdk.e.a;

import android.text.TextUtils;

/* compiled from: SerializeHelper */
class x {
    private static boolean a;

    static String a() {
        return "";
    }

    static String a(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":");
        sb.append(th instanceof r ? ((r) th).a : 0);
        sb.append("}");
        return sb.toString();
    }

    static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String substring = a ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!substring.isEmpty()) {
            return str2 + "," + substring + "}";
        }
        return str2 + "}";
    }

    static void a(boolean z) {
        a = z;
    }
}
