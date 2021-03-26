package com.xiaomi.push;

import com.xiaomi.a.a.a.c;

public class ja {
    public static String a(String str, String str2) {
        try {
            return (String) jb.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            c.a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
