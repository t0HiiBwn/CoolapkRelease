package com.huawei.updatesdk.service.e;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<Integer, String> a;
    private static b b = new b();
    private int c = 0;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(1, "1.0");
        hashMap.put(2, "1.5");
        hashMap.put(3, "1.6");
        hashMap.put(4, "2.0");
        hashMap.put(5, "2.0");
        hashMap.put(6, "2.3");
        hashMap.put(7, "3.0");
        hashMap.put(8, "3.0.5");
        hashMap.put(8, "3.1");
        hashMap.put(9, "4.0");
        hashMap.put(10, "4.1");
        hashMap.put(11, "5.0");
        hashMap.put(12, "5.1");
    }

    private b() {
        int c2 = c();
        this.c = c2;
        if (c2 == 0) {
            this.c = d();
        }
        a.a("EMUISupportUtil", "emuiVersion:" + this.c);
    }

    public static b a() {
        return b;
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("_");
            if (split.length == 2) {
                return split[1];
            }
        }
        return "";
    }

    private int c() {
        return com.huawei.updatesdk.a.a.c.a.b.a("ro.build.hw_emui_api_level", 0);
    }

    private int d() {
        String a2 = a(com.huawei.updatesdk.a.a.c.a.b.a("ro.build.version.emui", ""));
        if (TextUtils.isEmpty(a2)) {
            return 0;
        }
        for (Map.Entry<Integer, String> entry : a.entrySet()) {
            if (a2.equals(entry.getValue())) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    public int b() {
        return this.c;
    }
}
