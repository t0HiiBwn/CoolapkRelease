package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;

/* compiled from: TTPathConst */
public class e {
    public static String a = "com.bytedance.openadsdk";
    public static String b = ("content://" + a + ".TTMultiProvider");

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            a = p.a().getPackageName();
            b = "content://" + a + ".TTMultiProvider";
        }
    }
}
