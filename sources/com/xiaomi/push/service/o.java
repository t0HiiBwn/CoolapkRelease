package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.ah;

public class o {
    private static long a = 0;
    private static String b = "";

    public static String a() {
        if (TextUtils.isEmpty(b)) {
            b = ah.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        long j = a;
        a = 1 + j;
        sb.append(j);
        return sb.toString();
    }
}
