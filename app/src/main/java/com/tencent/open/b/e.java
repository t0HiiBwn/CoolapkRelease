package com.tencent.open.b;

import com.tencent.open.utils.f;

/* compiled from: ProGuard */
public class e {
    public static int a(String str) {
        int a;
        if (com.tencent.open.utils.e.a() == null || (a = f.a(com.tencent.open.utils.e.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a;
    }

    public static int a() {
        int a = f.a(com.tencent.open.utils.e.a(), (String) null).a("Common_HttpRetryCount");
        if (a == 0) {
            return 2;
        }
        return a;
    }
}
