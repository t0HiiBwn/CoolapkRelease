package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.bi;

public class aq {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f957a = "";

    public static String a() {
        if (TextUtils.isEmpty(f957a)) {
            f957a = bi.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f957a);
        long j = a;
        a = 1 + j;
        sb.append(j);
        return sb.toString();
    }
}
